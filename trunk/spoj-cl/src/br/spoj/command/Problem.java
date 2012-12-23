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

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpResponse;

// Para executar:
// http://br.spoj.pl/problems/<CODIGO PROBLEMA/
// E buscar a defini��o completa de um determinado problema
public class Problem  extends DefaultSpojCommand {

	private String problemCode;

	/**
	 * Creates a problem command.
	 * 
	 * @param problemCode the id of the problem do look for.
	 */
	public Problem(String problemCode) {
		this.problemCode = problemCode.toUpperCase();
	}

	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String path = "/problems/" + problemCode;

		try {
			HttpResponse httpResponse = context().executeGet(path);
			String response = getAsString(httpResponse);

			response = getProb(response);
			
			if (StringUtils.isEmpty(response)) {
				final String content = getContent(response);
				if (content.contains(context().getHost().getWrongProblemCodeString())) {
					return "Wrong problem code!";
				} else {
					return "Unable to identify problem";
				}
			}
			
			response = removeHeader(response);
			response = removeComments(response);
			
			response = translateHtmlToString(response);
			
			return response;
			
		} catch (IOException ioe) {
			throw new SpojCommandExecutionException(ioe);
		}
	}

	private String removeHeader(String response) {
		int begginingOfProblemDescription = response.indexOf("<table ");
		return response.substring(begginingOfProblemDescription);
	}

	private String removeComments(String response) {
		int begginingOfComments = response.indexOf("<div id=\"ccontent\"");
		return response.substring(0, begginingOfComments);
	}

	private String getContent(String html) {
		return get(html, "td", "content");
	}
	
	private String getProb(String html) {
		return get(html, "div", "prob");
	}
	
	private String get(String html, String tag, String classAttribute) {
		final String startTag = "<" + tag + " class=\"" + classAttribute + "\"";
		final String endTag = "</" + tag + ">";
		
		int start = html.indexOf(startTag);
		if (start < 0) return "";
		
		// ignore internal tags of the same type to find the last one
		int end = html.indexOf(endTag, start);
		int nextStartTag = html.indexOf("<" + tag, start + 1);
		while (nextStartTag > -1 && nextStartTag < end) {
			end = html.indexOf(endTag, end + 1);
			nextStartTag = html.indexOf("<" + tag, nextStartTag + 1);
		}
		
		if (end < 0) return "";
		return html.substring(start, end + endTag.length());
	}
	
}
