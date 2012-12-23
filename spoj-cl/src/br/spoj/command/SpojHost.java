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
 * Definition of available Hosts for SPOJ.
 * 
 * @author Anderson Dorow
 */
public enum SpojHost {

	/** Armenian problem set - am.spoj.com */
	ARMENIAN("am", "am.spoj.com", "լուծված է", "սխալ պատասխան", "ժամանակի սահմանափակումը գերազանցված է", "սխալ կատարման ընթացքում  \\([A-Z]+\\)", "կոմպիլյացիայի սխալ"),
	/** English problem set - www.spoj.com */
	ENGLISH("en", "www.spoj.com", "(accepted)|([0-9]+)", "wrong answer.*", "time limit exceeded", "runtime error \\([A-Z]+\\)", "compilation error"),
	/** Polish problem set - pl.spoj.com */
	POLISH("pl","pl.spoj.com", "(zaakceptowano)|([0-9]+)", "(błędna odpowiedź)|([0-9]+ \\(limit: [0-9]+\\))|([0-9]+(\\.[0-9]+)? \\(threshold: [0-9]+\\))", "przekroczono limit czasu", "błąd wykonania \\([A-Z]+\\)", "błąd kompilacji"),
	/** Portuguese-BR problem set - br.spoj.com */
	PORTUGUESE_BR("br","br.spoj.com", "aceito", "resposta errada", "tempo limite excedido", "erro em tempo de execução \\([A-Z]+\\)", "erro de compilação"),
	/** Vietnamese problem set - vn.spoj.com */
	VIETNAMESE("vn", "vn.spoj.com", "(Đạt yêu cầu)|([0-9]+)(\\.[0-9]+)?", "kết quả sai.*", "chạy quá lâu", "chạy bị lỗi \\([A-Z]+\\)", "biên dịch gặp lỗi");
	
	private String abbreviation;
	private String address;
	
	private String ac_regex;
	private String wa_regex;
	private String tle_regex;
	private String re_regex;
	private String ce_regex;

	/**
	 * Creates a SpojHost.
	 * 
	 * @param abbreviation the abbreviation of the language.
	 * @param address the IP address of the host. 
	 * @param ac_regex the regular expression to identify an accepted answer in this host.
	 * @param wa_regex the regular expression to identify a wrong answer in this host.
	 * @param tle_regex the regular expression to identify a time limit exceeded answer in this host.
	 * @param re_regex the regular expression to identify a runtime error in this host.
	 * @param ce_regex the regular expression to identify a compilation error in this host.
	 */
	private SpojHost(String abbreviation, String address, String ac_regex, String wa_regex, String tle_regex, String re_regex, String ce_regex) {
		this.abbreviation = abbreviation;
		this.address = address;
		this.ac_regex = ac_regex;
		this.wa_regex = wa_regex;
		this.tle_regex = tle_regex;
		this.re_regex = re_regex;
		this.ce_regex = ce_regex;
	}
	
	/**
	 * Gets the abbreviation used to locate this host.
	 * 
	 * @return the abbreviation of the host.
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	
	/**
	 * Gets the host address.
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Obtains the corresponding result for a string describing it, in the language of this host.
	 * 
	 * @param word the word.
	 * @return the submission corresponding to this string, or <code>null</code> if it isn't a valid string of submission result for this host.
	 */
	public SubmissionResult getSubmissionResult(String string) {
		if (string.matches(ac_regex)) {
			return SubmissionResult.ACCEPTED;
		}
		if (string.matches(wa_regex)) {
			return SubmissionResult.WRONG_ANSWER;
		}
		if (string.matches(tle_regex)) {
			return SubmissionResult.TIME_LIMIT_EXCEEDED;
		}
		if (string.matches(re_regex)) {
			return SubmissionResult.RUNTIME_ERROR;
		}
		if (string.matches(ce_regex)) {
			return SubmissionResult.COMPILATION_ERROR;
		}
		return null;
	}
	
	/**
	 * Gets the host by its abbreviation (not case-sensitive).
	 * 
	 * @param abbreviation the abbreviation of the host.
	 * @return the host with the given abbreviation, or <code>null</code> if there isn't a host with the given abbreviation.
	 */
	public static SpojHost getByAbbreviation(String abbreviation) {
		for (SpojHost host : values()) {
			if (host.abbreviation.equalsIgnoreCase(abbreviation)) {
				return host;
			}
		}
		return null;
	}
	
}

