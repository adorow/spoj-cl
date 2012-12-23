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
// https://br.spoj.pl/logout
// E buscar como resultado o c�digo fonte
public class Logout  extends DefaultSpojCommand {

	/**
	 * Creates a logout command.
	 */
	public Logout() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String path = "/logout";

		try {
			HttpResponse response = context().executeGet(path);
			getAsString(response);// discard, there's nothing special in the return of logout
			
			return "Logged out of " + context().getHost().getAddress();
		} catch (IOException ioe) {
			throw new SpojCommandExecutionException(ioe);
		}
	}

	
	
}
