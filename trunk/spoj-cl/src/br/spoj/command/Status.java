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
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
	
// Para executar:
// https://br.spoj.pl/status/
// E buscar o resultado para um problema de determinado ID (para isso poderah ter que executar mais de uma requisicao, pois pode demorar para rodar o problema, e, caso o problema nao apare�a na tela, descartar)
public class Status extends DefaultSpojCommand {

	private String submissionId;

	/**
	 * Creates a status command.
	 * 
	 * @param submissionId the id of the submission to look for.
	 */
	public Status(String submissionId) {
		this.submissionId = submissionId;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String path = "/status/";
		
		SubmissionResult result = null;
		String strResult = null;
		
		// while we don't have a valid result, we keep asking the status
		while (result == null) { 
			try {
				HttpResponse response = context().executeGet(path);
				
				String httpResult = getAsString(response);
				int submissionStrIndex = httpResult.indexOf(submissionId);
				if (submissionStrIndex < 0) {
					throw new SpojCommandExecutionException("Can't find the submission with " + submissionId);
				}
				
				String substr = httpResult.substring(submissionStrIndex);
				// skip some <TD>s
				final String TD = "<td";
				for (int i = 0; i < 5; i++) {
					int tdIndex = substr.indexOf(TD);
					if (tdIndex < 0) {
						throw new SpojCommandExecutionException("Can't correctly find the submission " + submissionId);
					}
					substr = substr.substring(tdIndex + TD.length());
				}
				
				strResult = substr.substring(substr.indexOf('>')+1, substr.indexOf('<')).trim();
				
				strResult = strResult.trim().replaceAll(" +", " ");// remove trailing, remove subsequent whitespaces in the middle of the string
				
				SpojHost host = WebContext.INSTANCE.getHost();
				result = host.getSubmissionResult(strResult);
			} catch (IOException ioe) {
				throw new SpojCommandExecutionException(ioe);
			}
			
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// ignore
			}
		}
		
		return result.toString();
	}
	
	
}
