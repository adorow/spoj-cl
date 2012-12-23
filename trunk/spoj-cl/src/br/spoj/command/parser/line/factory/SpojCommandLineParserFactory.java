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
package br.spoj.command.parser.line.factory;

import br.spoj.command.CommandDef;
import br.spoj.command.SpojCommand;
import br.spoj.command.parser.line.ExitLineParser;
import br.spoj.command.parser.line.HelpLineParser;
import br.spoj.command.parser.line.InfoLineParser;
import br.spoj.command.parser.line.LoginLineParser;
import br.spoj.command.parser.line.LogoutLineParser;
import br.spoj.command.parser.line.ProblemLineParser;
import br.spoj.command.parser.line.SetHostLineParser;
import br.spoj.command.parser.line.SpojCommandLineParser;
import br.spoj.command.parser.line.StatusLineParser;
import br.spoj.command.parser.line.SubmitLineParser;
import br.spoj.command.parser.line.UnknownLineParser;

/**
 * A factory for {@link SpojCommandLineParser}s.
 * 
 * @author Anderson Dorow
 */
public final class SpojCommandLineParserFactory {

	/**
	 * Obtains a {@link SpojCommandLineParser} for a command with the given <code>commandName</code>.
	 * @param <T> the type of the {@link SpojCommand} created byt the {@link SpojCommandLineParser}.
	 * @param commandName the name of the command.
	 * @return the {@link SpojCommandLineParser} for the {@link SpojCommand} named <code>commandName</code>.
	 * @throws NullPointerException if the {@link CommandDef} informed is <code>null</code>.
	 * @throws IllegalArgumentException if there is no command associated with the given name.
	 */
	public static SpojCommandLineParser<? extends SpojCommand> getParser(CommandDef cmd) {
		switch (cmd) {
		case EXIT:
			return new ExitLineParser();
		case HELP:
			return new HelpLineParser();
		case INFO:
			return new InfoLineParser();
		case SETHOST:
			return new SetHostLineParser();
		case LOGIN:
			return new LoginLineParser();
		case LOGOUT:
			return new LogoutLineParser();
		case PROBLEM:
			return new ProblemLineParser();
		case STATUS:
			return new StatusLineParser();
		case SUBMIT:
			return new SubmitLineParser();
		default:
			return new UnknownLineParser();	
		}
		
	}
	
}
