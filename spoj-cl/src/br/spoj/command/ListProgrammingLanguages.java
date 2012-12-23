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

import org.apache.commons.lang.ArrayUtils;

import br.spoj.ProgrammingLanguage;


public class ListProgrammingLanguages  extends DefaultSpojCommand {

	/**
	 * Creates a help command.
	 */
	public ListProgrammingLanguages() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		final String ln = String.format("%n");

		StringBuilder sb = new StringBuilder();
		sb.append("The following programming languages can be used: (name_to_use_on_submission: extensions_accepted_on_file_submitted)").append(ln);
		for (ProgrammingLanguage pl : ProgrammingLanguage.values()) {
			sb.append(' ').append(pl.languageName()).append(": ").append(ArrayUtils.toString(pl.extensions())).append(ln);
		}
		
		return sb.toString();
	}

}
