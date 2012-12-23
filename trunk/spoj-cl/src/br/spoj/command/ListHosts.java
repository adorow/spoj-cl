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


public class ListHosts  extends DefaultSpojCommand {

	/**
	 * Creates a help command.
	 */
	public ListHosts() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String ln = String.format("%n");

		StringBuilder sb = new StringBuilder();
		sb.append("The following hosts can be used: (code_for_sethost: host)").append(ln);
		for (SpojHost host : SpojHost.values()) {
			sb.append(' ').append(host.getAbbreviation()).append(": ").append(host.getAddress()).append(ln);
		}
		
		return sb.toString();
	}

	
	
}
