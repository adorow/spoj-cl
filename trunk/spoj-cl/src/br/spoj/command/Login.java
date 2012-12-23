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
import org.apache.http.NameValuePair;

// O arquivo 'spoj-login-form.txt' possui o formulário de Login. A partir dele ja eh possivel fazer o resto
public class Login extends DefaultSpojCommand {

	private String user;
	private String password;
	
	/**
	 * Creates a login command.
	 * 
	 * @param user the user to be authenticated.
	 * @param password the password used for authentication.
	 */
	public Login(String user, String password) {
		this.user = user;
		this.password = password;
	}


	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String path = "/";
		final NameValuePair[] params = { pair("login_user", user), pair("password", password) };

		try {
			HttpResponse response = context().executePost(path, params);
			String httpResponse = getAsString(response);
			
			if (httpResponse.contains("Authentication failed!")) {
				throw new SpojCommandExecutionException("Authentication failed!");
			}
			
			// why there's still a login form? some kind of new error?
			if (httpResponse.contains("<form name=\"login\"")) {
				unknownErrorReceived(httpResponse);
			}
			
			return "Logged in succesfully";
		} catch (IOException ioe) {
			throw new SpojCommandExecutionException(ioe);
		}
	}
	
}
