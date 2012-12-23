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

import org.apache.commons.lang.StringUtils;

/**
 * Describes possible submission results. 
 * 
 * @author Anderson Dorow
 */
public enum SubmissionResult {
	
	//RUNNING//3
	//RUNNING JUDGE//5
	
	//2.5 (threshold: 3)//16
	//1 (limit: 2)//16
	
	
	// exemplo de resultado
	// <td class="statusres" id="statusres_5242606" status="13" manual="0">
	
	/** AC - Accepted */
	ACCEPTED("AC"),//15
	/** WA - Wrong Answer */
	WRONG_ANSWER("WA"),//14
	/** TLE - Time Limit Exceeded */
	TIME_LIMIT_EXCEEDED("TLE"),//13
	/** RE - Runtime Error */
	RUNTIME_ERROR("RE"),//12
	/** CE - Compilation Error */
	COMPILATION_ERROR("CE");//11
	
	private String abbreviation;
	
	/**
	 * Creates a submission result.
	 * 
	 * @param abbreviation the abbreviation of the submission result.
	 */
	private SubmissionResult(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	/**
	 * Get the abbreviation of the result.
	 * 
	 * @return the abbreviation of the result.
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return getAbbreviation() +  " - " + StringUtils.capitalize(name().replaceAll("_", " "));
	}
	
}
