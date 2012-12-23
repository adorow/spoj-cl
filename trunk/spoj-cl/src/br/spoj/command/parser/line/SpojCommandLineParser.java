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
package br.spoj.command.parser.line;

import br.spoj.command.SpojCommand;
import br.spoj.command.parser.InvalidArgumentsException;

/**
 * A factory to create {@link SpojCommand}s from given {@link String} params.
 * 
 * @author Anderson Dorow
 *
 * @param <T> the type of command generated from this factory.
 */
public interface SpojCommandLineParser<T extends SpojCommand> {

	/**
	 * Parse the arguments and create a {@link SpojCommand} with them.
	 * 
	 * @param arguments the given arguments.
	 * @return the {@link SpojCommand} created using the arguments given.
	 * @throws InvalidArgumentsException if some of the arguments are wrongly formatted, or if there is a wrong number of parameters.
	 */
	T parse(String... arguments) throws InvalidArgumentsException;
	
	
}
