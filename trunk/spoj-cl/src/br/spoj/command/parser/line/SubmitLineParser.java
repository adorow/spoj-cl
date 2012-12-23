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

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import br.spoj.ProgrammingLanguage;
import br.spoj.command.Submit;
import br.spoj.command.parser.InvalidArgumentsException;

public class SubmitLineParser implements SpojCommandLineParser<Submit> {

	/**
	 * {@inheritDoc}
	 */
	public Submit parse(String... arguments) throws InvalidArgumentsException {
		if (arguments.length != 2 && arguments.length != 3) {
			throw new InvalidArgumentsException("The submit command needs two parameters: problemCode sourceFile, and an optional third parameter: programmingLanguageName");
		}

		final String problemCode = arguments[0];
		final String sourceFilename = arguments[1];
		final String strPL = arguments.length > 2 ? arguments[2] : "";
		
		final ProgrammingLanguage pl;
		final File sourceFile;
		
		if (!StringUtils.isEmpty(strPL)) {
			pl = ProgrammingLanguage.getByName(strPL);
			if (pl == null) {
				throw new InvalidArgumentsException("The programming language name '" +strPL+"' is not a valid PL name.");
			}
		} else {
			final String ext = FilenameUtils.getExtension(sourceFilename);
			
			if (StringUtils.isEmpty(ext)) {
				throw new InvalidArgumentsException("Extension of '" + sourceFilename + "' not indicated.");
			}
			pl = ProgrammingLanguage.getLanguageFromExtension(ext);
			if (pl == null) {
				throw new InvalidArgumentsException("Extension  '" + ext + "' is not associated with any programming language.");
			}
		}

		sourceFile = new File(sourceFilename);
		if (!sourceFile.exists()) {
			throw new InvalidArgumentsException("The file '" +sourceFilename+"' does not exist.");
		}
		
		return new Submit(problemCode, pl, sourceFile);
	}

}
