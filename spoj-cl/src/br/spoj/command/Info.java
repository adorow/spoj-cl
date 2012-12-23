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


public class Info  extends DefaultSpojCommand {

	/**
	 * Creates a info command.
	 */
	public Info() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String ln = String.format("%n");
		StringBuilder sb = new StringBuilder();

		sb.append("SPOJ command line utility").append(ln);
		sb.append("Developed by Anderson Dorow (andersondorow@gmail.com)").append(ln);
		sb.append("Write '").append(CommandDef.HELP).append("' to show the possible commands.").append(ln);
		
		return sb.toString();
	}

	
	
}
