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

import java.io.Console;
import java.io.PrintStream;

import br.spoj.command.CommandDef;
import br.spoj.command.Info;
import br.spoj.command.SpojCommand;
import br.spoj.command.SpojCommandExecutionException;
import br.spoj.command.parser.InvalidArgumentsException;
import br.spoj.command.parser.io.SpojCommandIOParser;
import br.spoj.command.parser.io.factory.SpojCommandIOParserFactory;
import br.spoj.command.parser.line.SpojCommandLineParser;
import br.spoj.command.parser.line.factory.SpojCommandLineParserFactory;


public class Main {

	public static void main(String[] args) throws Exception {
		final Console console = System.console();
		final PrintStream out = System.out;

		out.println(new Info().execute());
		
		String cmdName;
		String[] arguments;
		for (;;) {
			cmdName = console.readLine("> ");
			cmdName = cmdName.trim();
			int firstSpace = cmdName.indexOf(' ');
			if (firstSpace > -1) {
				// there is more than one argument, let's do it in command line style
				arguments = cmdName.substring(firstSpace+1).split(" ");
				cmdName = cmdName.substring(0, firstSpace);
			} else {
				arguments = null;
			}
			
			final CommandDef cmd = CommandDef.get(cmdName);
			final SpojCommand spojCommand;
			
			try {
				if (arguments == null) {
					SpojCommandIOParser<? extends SpojCommand> parser = SpojCommandIOParserFactory.getParser(cmd);
					spojCommand = parser.parse(console);
				} else {
					SpojCommandLineParser<? extends SpojCommand> parser = SpojCommandLineParserFactory.getParser(cmd);
					spojCommand = parser.parse(arguments);
				}
			} catch (InvalidArgumentsException iae) { 
				out.println("Error: " + iae.getMessage());
				continue;
			} catch (Throwable t) {
				out.println("Unexpected error: " + t.getMessage());
				continue;
			}
			
			final String result;
			try {
				result = spojCommand.execute();
				
			} catch (SpojCommandExecutionException scee) {
				out.println("Error: " + scee.getMessage());
				continue;
			} catch (Throwable t) {
				out.println("Unexpected error: " + t.getMessage());
				continue;
			}

			out.println(result);
			out.println();
			
			if (cmd == CommandDef.EXIT) {
				break;
			}
		}
	}

}
