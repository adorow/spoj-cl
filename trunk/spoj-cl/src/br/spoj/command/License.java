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

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;


public class License  extends DefaultSpojCommand {

	/**
	 * Creates a license command.
	 */
	public License() {
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String execute() throws SpojCommandExecutionException {
		try {
			String license = IOUtils.toString(new FileInputStream("gpl-3.0.txt"));
			return license;
		} catch (IOException ioe) {
			throw new SpojCommandExecutionException(ioe);
		}
	}

	
	
}
