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

public enum CommandDef {

	EXIT("Exits the application"),
	HELP("Shows a list of all the possible commands"),
	INFO("Shows info about the program"),
	LICENSE("Shows the software's license"),
	SET_HOST("Change the SPOJ host to connect to"),
	LOGIN("Log into the currently set SPOJ host"),
	LOGOUT("Logs out of the current SPOJ host"),
	PROBLEM("Loads a problem"),
	STATUS("Shows the final status of a submission"),
	SUBMIT("Submits a solution to the host"),
	
	UNKNOWN("");
	
	private String helpHint;

	private CommandDef(String helpHint) {
		this.helpHint = helpHint;
	}
	
	public String getHelpHint() {
		return helpHint;
	}
	
	public boolean isValid() {
		return this != UNKNOWN;
	}
	
	public String getCommandName() {
		return name().replaceAll("_", "").toLowerCase();
	}
	
	@Override
	public String toString() {
		return getCommandName();
	}
	
	public static CommandDef get(String name) {
		for (CommandDef def : CommandDef.values()) {
			if (def.getCommandName().equalsIgnoreCase(name)) {
				return def;
			}
		}
		return UNKNOWN;
	}
	
}
