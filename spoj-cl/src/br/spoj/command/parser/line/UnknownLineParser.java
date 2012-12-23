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

import br.spoj.command.Unknown;
import br.spoj.command.parser.InvalidArgumentsException;

public class UnknownLineParser implements SpojCommandLineParser<Unknown> {

	/**
	 * {@inheritDoc}
	 */
	public Unknown parse(String... arguments) throws InvalidArgumentsException {
		return new Unknown();
	}

}
