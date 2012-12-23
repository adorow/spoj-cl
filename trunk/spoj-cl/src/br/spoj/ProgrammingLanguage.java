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
package br.spoj;

import java.util.Arrays;

/**
 * Definition of the programming languages used in SPOJ.
 * 
 * @author Anderson Dorow
 */
public enum ProgrammingLanguage {

	/** ADA */
	ADA_95(7, "ADA", "gnat 4.3.2"),
	/** Assembler */
	ASSEMBLER(13, "Assembler", "nasm 2.03.01", "asm"),
	/** Bash */
	BASH(28, "Bash", "bash-4.0.37", "sh"),
	/** Brainfuck */
	BRAINFUCK(12, "Brainfuck", "bff 1.0.3.1"),
	/** C */
	C(11, "C", "gcc 4.3.2", "c"),
	/** C# */
	C_SHARP(27, "C#", "gmcs 2.0.1", "cs"),
//	/** C++ */
//	CPP(1, "C++", "g++ 4.0.0-8", "cpp", "c++"),
	/** C++ */
	CPP(41, "C++", "g++ 4.3.2", "cpp", "c++"),
	/** C99 Strict */
	C99_STRICT(34, "C99", "gcc 4.3.2"),
	/** Clips */
	CLIPS(14, "Clips", "clips 6.24"),
//	/** Common Lisp */
//	COMMON_LISP(31, "Lisp", "sbcl 1.0.18"),
	/** Common Lisp */
	COMMON_LISP(32, "Lisp", "clisp 2.44.1"),
	/** D */
	D(20, "D", "gdc 4.1.3"),
	/** Fortran 95 */
	FORTRAN_95(5, "Fortran", "gfortran 4.3.2"),
	/** Haskell */
	HASKELL(21, "Haskell", "ghc 6.10.4", "hs"),
	/** Icon */
	ICON(16, "Icon", "iconc 9.4.3"),
	/** Intercal */
	INTERCAL(9, "Intercal", "ick 0.28-4"),
	/** JAR */
	JAR(24, "JAR", "JavaSE 6", "jar"),
	/** Java */
	JAVA(10, "Java", "Java SE 6", "java"),
	/** Lua */
	LUA(26, "Lua", "luac 5.1.3", "lua"),
	/** Nemerle */
	NEMERLE(30, "Nemerle", "ncc 0.9.3"),
	/** Nice */
	NICE(25, "Nice", "nicec 0.9.6"),
	/** OCaml */
	OCAML(8, "OCaml", "ocamlopt 3.10.2"),
//	/** Pascal */
//	PASCAL(2, "Pascal", "gpc 20070904", "pas"),
	/** Pascal */
	PASCAL(22, "Pascal", "fpc 2.2.4", "pas"),
	/** Perl */
	PERL(3, "Perl", "perl 5.12.1", "pl"),
	/** PHP */
	PHP(29, "PHP", "php 5.2.6", "php"),
	/** Pike */
	PIKE(19, "Pike", "pike 7.6.112"),
	/** Prolog */
	PROLOG(15, "Prolog", "swipl 5.6.58"),
	/** Python */
	PYTHON(4, "Python", "python 2.5", "py"),
	/** Ruby */
	RUBY(17, "Ruby", "ruby 1.9.0", "rb"),
//	/** Scheme */
//	SCHEME(18, "Scheme", "stalin 0.11"),
	/** Scheme */
	SCHEME(33, "Scheme", "guile 1.8.5"),
	/** Smalltalk */
	SMALLTALK(23, "Smalltalk", "gst 3.0.3"),
	/** Whitespace */
	WHITESPACE(6, "Whitespace", "wspace 0.3");
	
	private int id;
	private String name;
	private String versionName;
	private String[] extensions;
	
	private ProgrammingLanguage(int id, String name, String versionName, String... extensions) {
		this.id = id;
		this.name = name;
		this.versionName = versionName;
		this.extensions = extensions;
	}
	
	/**
	 * Get the language id.
	 * 
	 * @return the language id.
	 */
	public int languageId() {
		return id;
	}
	
	/**
	 * Get the language name.
	 * 
	 * @return the language name.
	 */
	public String languageName() {
		return name;
	}
	
	/**
	 * Get the language version.
	 * 
	 * @return the language version.
	 */
	public String languageVersion() {
		return versionName;
	}
	
	/**
	 * Get the language extensions.
	 * 
	 * @return the language extensions.
	 */
	public String[] extensions() { 
		return Arrays.copyOf(extensions, extensions.length);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return String.format("%s (%s)", languageName(), languageVersion());
	}

	/**
	 * Seek from the registered programming languages, for a language which has an extension equal to the on informed. <code>null</code> will be returned if none is found.
	 * 
	 * @param ext the extension of the source file.
	 * @return the programming languange with the informed extension.
	 */
	public static ProgrammingLanguage getLanguageFromExtension(String ext) {
		for (ProgrammingLanguage pl : values()) {
			if (Arrays.binarySearch(pl.extensions, ext) > -1) {
				return pl;
			}
		}
		return null;
	}

	/**
	 * Seek from the registered programming languages, for a language with the given name.
	 * 
	 * @param plName the name of the language (not case sensitive).
	 * @return the programming languange with the given name.
	 */
	public static ProgrammingLanguage getByName(String plName) {
		plName = plName.toLowerCase();
		
		for (ProgrammingLanguage pl : values()) {
			String thisPlName = pl.languageName().toLowerCase();
			if (plName.equals(thisPlName)) {
				return pl;
			}
		}
		return null;
	}
	
}
