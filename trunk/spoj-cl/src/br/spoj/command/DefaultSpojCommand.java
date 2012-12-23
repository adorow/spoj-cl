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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import util.html.HtmlUtil;

/**
 * A default implementation of a {@link SpojCommand}.
 * 
 * @author Anderson Dorow
 */
abstract class DefaultSpojCommand implements SpojCommand {

	/**
	 * Returns the context used.
	 * 
	 * @return the context.
	 */
	protected final WebContext context() {
		return WebContext.INSTANCE;
	}
	
	/**
	 * Creates a new {@link NameValuePair}.
	 * @param name the name.
	 * @param value the value.
	 * @return the pair created.
	 */
	protected final NameValuePair pair(String name, String value) {
		return new BasicNameValuePair(name, value);
	}
	
	/**
	 * Reads the response, and gives a {@link String} with the content.
	 * @param response the response.
	 * @return a {@link String} with the returned content.
	 * @throws IOException if an I/O error occurs.
	 */
	protected final String getAsString(HttpResponse response) throws IOException {
		HttpEntity responseEntity = response.getEntity();
		return IOUtils.toString(responseEntity.getContent(), context().charset().name());
	}
	
	/**
	 * Removes HTML data from HTML, and translates HTML characters to normal string characters.
	 * 
	 * @param html the HTML.
	 * @return the cleaned text.
	 * @throws IOException if an I/O error occurs.
	 */
	protected final String translateHtmlToString(String html) throws IOException {
		html = html.replaceAll("<BR>", String.format("%n"));// turn <BR>s into line feeds
		html = HtmlUtil.translateSpecialCharacters(html);
		html = HtmlUtil.removeTags(html);
		html = removeMultipleBlankLines(html);
		return html;
	}
	
	private String removeMultipleBlankLines(String html) throws IOException {
		final BufferedReader reader = new BufferedReader(new StringReader(html));
		final StringBuilder sb = new StringBuilder(8192);
		try {
			String line = null;
			boolean lastLineWasBlank = true;// variable to just let one blank line
			
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.length() == 0) {
					if (lastLineWasBlank) {
						continue;// don't let another blank line
					}
					lastLineWasBlank = true;
				} else {
					lastLineWasBlank = false;
				}
				
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		
		return sb.toString();
	}

	/**
	 * Throws a generic error, indicating that the result could not be correctly parsed.
	 * 
	 * @param httpResult the HTTP response received.
	 * @throws SpojCommandExecutionException always thrown.
	 */
	protected final void unknownErrorReceived(String httpResult) throws SpojCommandExecutionException {
		throw new SpojCommandExecutionException("There is a problem, but I don't know what it is. Here is the response I received: \n" + httpResult);
	}
	
}
