/*
 * This file is part of spoj-cl.
 *
 * spoj-cl is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * spoj-cl is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with spoj-cl.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.spoj.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * A context, to keep track of the status of authentication between command executions.
 * 
 * @author Anderson Dorow
 */
class WebContext {

	private final Charset charset = Charset.forName("ISO-8859-1");

	private String scheme = "http";
	private SpojHost host = SpojHost.ENGLISH;
	
	public static final WebContext INSTANCE = new WebContext();
	
	private HttpClient httpClient;
	
	/**
	 * Get the {@link HttpClient} used to send requests and receive responses.
	 * 
	 * @return the {@link HttpClient} used by this context.
	 */
	private HttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = new DefaultHttpClient();
		}
		return httpClient;
	}
	
	private URI newURI(String path) {
		try {
			return URIUtils.createURI(scheme, host.getAddress(), -1, path, null, null);
		} catch (URISyntaxException e) {
			throw new IllegalArgumentException(e);
		}
		
	}
	
	private HttpEntity newEntity(NameValuePair... params) {
		if (params.length > 0) {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			for (NameValuePair nameValuePair : params) {
				formparams.add(nameValuePair);
			}
			try {
				return new UrlEncodedFormEntity(formparams, charset.name());
			} catch (UnsupportedEncodingException e) {
				try {
					return new UrlEncodedFormEntity(formparams);
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();// HOW???
				}
			}
		}
		return new BasicHttpEntity(); 
	}
	
	private HttpPost newPost(String path, NameValuePair... params) {
		URI uri = newURI(path);
	    HttpEntity entity = newEntity(params);
	    
	    HttpPost post = new HttpPost(uri);
	    post.setEntity(entity);
	    return post;
	}

	private HttpGet newGet(String path) {
		URI uri = newURI(path);
		
		HttpGet get = new HttpGet(uri);
		return get;
	}
	
	private HttpResponse execute(HttpRequestBase request) throws IOException {
		return getHttpClient().execute(request);
	}

	/**
	 * Gets the charset used.
	 * 
	 * @return the charset used.
	 */
	public Charset charset() {
		return charset;
	}
	
	/**
	 * Get the current host.
	 * 
	 * @return the host.
	 */
	public SpojHost getHost() {
		return host;
	}
	
	/**
	 * Configure the conected host.
	 * 
	 * @param host the host.
	 */
	public void setHost(SpojHost host) {
		this.host = host;
	}
	
	/**
	 * Executes a POST request.
	 * 
	 * @param path the path.
	 * @param params the params.
	 * @return the response received.
	 * @throws IOException if an I/O error occurs.
	 */
	public HttpResponse executePost(String path, NameValuePair... params) throws IOException {
		return execute(newPost(path, params));
	}

	/**
	 * Executes a GET request.
	 * 
	 * @param path the path.
	 * @return the response received.
	 * @throws IOException if an I/O error occurs.
	 */
	public HttpResponse executeGet(String path) throws IOException {
		return execute(newGet(path));
	}

	
}
