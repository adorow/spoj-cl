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
package br.spoj.command.parser.io.factory;

import br.spoj.command.CommandDef;
import br.spoj.command.SpojCommand;
import br.spoj.command.parser.io.ExitIOParser;
import br.spoj.command.parser.io.GetHostIOParser;
import br.spoj.command.parser.io.HelpIOParser;
import br.spoj.command.parser.io.InfoIOParser;
import br.spoj.command.parser.io.LicenseIOParser;
import br.spoj.command.parser.io.ListHostsIOParser;
import br.spoj.command.parser.io.ListProgrammingLanguagesIOParser;
import br.spoj.command.parser.io.LoginIOParser;
import br.spoj.command.parser.io.LogoutIOParser;
import br.spoj.command.parser.io.ProblemIOParser;
import br.spoj.command.parser.io.SetHostIOParser;
import br.spoj.command.parser.io.SpojCommandIOParser;
import br.spoj.command.parser.io.StatusIOParser;
import br.spoj.command.parser.io.SubmitIOParser;
import br.spoj.command.parser.io.UnknownIOParser;

/**
 * A factory for {@link SpojCommandIOParser}s.
 * 
 * @author Anderson Dorow
 */
public final class SpojCommandIOParserFactory {

	/**
	 * Obtains a {@link SpojCommandIOParser} for a command with the given <code>commandName</code>.
	 * @param <T> the type of the {@link SpojCommand} created byt the {@link SpojCommandIOParser}.
	 * @param commandName the name of the command.
	 * @return the {@link SpojCommandIOParser} for the {@link SpojCommand} named <code>commandName</code>.
	 * @throws NullPointerException if the {@link CommandDef} informed is <code>null</code>.
	 * @throws IllegalArgumentException if there is no command associated with the given name.
	 */
	public static SpojCommandIOParser<? extends SpojCommand> getParser(CommandDef cmd) {
		switch (cmd) {
		case EXIT:
			return new ExitIOParser();
		case GET_HOST:
			return new GetHostIOParser();
		case HELP:
			return new HelpIOParser();
		case INFO:
			return new InfoIOParser();
		case LICENSE:
			return new LicenseIOParser();
		case LIST_HOSTS:
			return new ListHostsIOParser();
		case LIST_PLS:
			return new ListProgrammingLanguagesIOParser();
		case SET_HOST:
			return new SetHostIOParser();
		case LOGIN:
			return new LoginIOParser();
		case LOGOUT:
			return new LogoutIOParser();
		case PROBLEM:
			return new ProblemIOParser();
		case STATUS:
			return new StatusIOParser();
		case SUBMIT:
			return new SubmitIOParser();
		default:
			return new UnknownIOParser();
		}
	}
	
}
