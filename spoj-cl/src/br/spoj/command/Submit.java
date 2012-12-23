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
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import br.spoj.ProgrammingLanguage;

//Para executar:
//http://br.spoj.pl/submit/
//setar o que eh preciso, e submeter o problema
// e retornar o ID gerado para a solução gerada
public class Submit  extends DefaultSpojCommand {
	
	private String problemCode;
	private ProgrammingLanguage programmingLanguage;

	private File sourceFile;
	private String sourceCode;

	/**
	 * Creates a submit command.
	 * 
	 * @param problemCode the code of the problem to which a solution may be sent.
	 * @param programmingLanguage the programming language of the code.
	 * @param sourceFile the source file of the solution.
	 */
	public Submit(String problemCode, ProgrammingLanguage programmingLanguage, File sourceFile) {
		this.problemCode = problemCode.toUpperCase();
		this.programmingLanguage = programmingLanguage;
		this.sourceFile = sourceFile;
	}
	
	/**
	 * Creates a submit command.
	 * 
	 * @param problemCode the code of the problem to which a solution may be sent.
	 * @param programmingLanguage the programming language of the code.
	 * @param sourceCode the source code of the solution.
	 */
	public Submit(String problemCode, ProgrammingLanguage programmingLanguage, String sourceCode) {
		this.problemCode = problemCode.toUpperCase();
		this.programmingLanguage = programmingLanguage;
		this.sourceCode = sourceCode;
	}

	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException  {
		loadSourceCodeIfNeeded();
		
		final String path = "/submit/complete/";
		final NameValuePair[] params = { pair("problemcode", problemCode), pair("lang", String.valueOf(programmingLanguage.languageId())), pair("file", sourceCode) };

		try {
			HttpResponse response = context().executePost(path, params);
			
			String httpResult = getAsString(response);
			final String strIdPrefix = "<input type=\"hidden\" name=\"newSubmissionId\" value=\"";
			
			int prefixIndex = httpResult.indexOf(strIdPrefix);
			if (prefixIndex < 0) {
				// the submission id was not found, so, an error occurred, but what?
				if (httpResult.contains("authorisation required")) {
					throw new SpojCommandExecutionException("The server says you are not logged in. Maybe you forgot to do that?");
				}
				if (httpResult.contains("Wrong problem code!")) {
					throw new SpojCommandExecutionException(problemCode + " is not a valid problem code.");
				}
				
				unknownErrorReceived(httpResult);
			}
			
			String almostTheResult = httpResult.substring(prefixIndex + strIdPrefix.length());
			// Example of submission input: <input type="hidden" name="newSubmissionId" value="1234567"/>
			String submissionId = almostTheResult.substring(0, almostTheResult.indexOf('"'));
			
			Status status = new Status(submissionId);
			return status.execute();
		} catch (IOException ioe) {
			throw new SpojCommandExecutionException(ioe);
		}
	}

	private void loadSourceCodeIfNeeded() throws SpojCommandExecutionException {
		try {
			if (sourceCode == null) {
				sourceCode = IOUtils.toString(new FileInputStream(sourceFile));
			}
		} catch (IOException ioe) {
			throw new SpojCommandExecutionException(ioe);
		}
	}
	
}
