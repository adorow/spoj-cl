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
package br.spoj.command.parser;

/**
 * An exception that indicates that the parse of a command gone wrong.
 * 
 * @author Anderson Dorow
 */
public class InvalidArgumentsException extends Exception {

	private static final long serialVersionUID = 5271890764910797050L;

	/**
	 * Create a new invalid arguments exception.
	 * 
	 * @param message the erro message.
	 */
	public InvalidArgumentsException(String message) {
		super(message);
	}
	
}
