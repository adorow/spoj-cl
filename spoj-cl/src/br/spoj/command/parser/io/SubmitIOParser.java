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
package br.spoj.command.parser.io;

import java.io.Console;
import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

import br.spoj.ProgrammingLanguage;
import br.spoj.command.Submit;
import br.spoj.command.parser.InvalidArgumentsException;

public class SubmitIOParser implements SpojCommandIOParser<Submit> {

	/**
	 * {@inheritDoc}
	 */
	public Submit parse(Console in) throws InvalidArgumentsException {
		final String problemCode = in.readLine("> Problem code: ");
		final String sourceFilename = in.readLine("> Source file: ");
		final String strPL = in.readLine("> Programming language (got from file extension if empty): ");
		
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
