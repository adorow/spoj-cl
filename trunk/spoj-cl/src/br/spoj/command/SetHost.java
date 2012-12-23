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

	
public class SetHost extends DefaultSpojCommand {

	private String hostAbbreviation;

	/**
	 * Creates a sethost command.
	 * 
	 * @param hostAbbreviation the host to update to.
	 */
	public SetHost(String hostAbbreviation) {
		this.hostAbbreviation = hostAbbreviation;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		SpojHost newHost = SpojHost.getByAbbreviation(hostAbbreviation);
		if (newHost == null)
		{
			// TODO add info on what are the right values
			throw new SpojCommandExecutionException("'" + hostAbbreviation + "' is not a valid host value.");
		}
		
		if (context().getHost() == newHost) {
			return "Already set to use " + newHost.getAddress();
		}
		
		StringBuilder result = new StringBuilder();
		final String ln = String.format("%n");
		try {
			result.append(new Logout().execute()).append(ln);
		} catch (Throwable t) {
			// ignore any errors here, because is not important if logout fails
		}
		context().setHost(newHost);
		result.append("Set new host to " + newHost.getAddress());
		
		return result.toString();
	}
	
	
}
