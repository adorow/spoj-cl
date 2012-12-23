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

import org.apache.http.HttpResponse;

// Para executar:
// http://br.spoj.pl/problems/<CODIGO PROBLEMA/
// E buscar a definição completa de um determinado problema
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
			HttpResponse response = context().executeGet(path);
			String httpResponse = getAsString(response);

			final String start = "<div class=\"prob\">"; 
			final String end = "</div>";
			
			int iStart = httpResponse.indexOf(start);
			int iEnd = httpResponse.indexOf(end, iStart+start.length());
			
			final String htmlProblem = httpResponse.substring(iStart+start.length(), iEnd);
			
			final String noHtmlProblem = translateHtmlToString(htmlProblem);
			
			return noHtmlProblem;
			
		} catch (IOException ioe) {
			throw new SpojCommandExecutionException(ioe);
		}
	}

}
