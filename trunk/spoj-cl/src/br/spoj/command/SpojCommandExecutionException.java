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


/**
 * An exception meaning thar an error occurred during the execution of a {@link SpojCommand}.
 * 
 * @author Anderson Dorow
 */
public class SpojCommandExecutionException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new {@link SpojCommandExecutionException} with the specified detail message.  
     *
     * @param   message   the detail message. 
     */
	public SpojCommandExecutionException(String message) {
		super(message);
	}
	
	/**
     * Constructs a new {@link SpojCommandExecutionException} with the specified detail message and
     * cause. 
     *
     * @param  message the detail message.
     * @param  cause the cause.
     */
	public SpojCommandExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new {@link SpojCommandExecutionException} with the specified cause.
	 * 
	 * @param cause the cause.
	 */
	public SpojCommandExecutionException(Throwable cause) {
		super(cause);
	}
	
}
