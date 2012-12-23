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


public class Help  extends DefaultSpojCommand {

	/**
	 * Creates a help command.
	 */
	public Help() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String ln = String.format("%n");
		StringBuilder sb = new StringBuilder();
		sb.append("Available commands: ").append(ln);
		for (CommandDef def : CommandDef.values()) {
			if (def.isValid()) {
				sb.append(" ").append(def).append(": ").append(def.getHelpHint()).append(ln);
			}
		}
		
		return sb.toString();
	}

	
	
}
