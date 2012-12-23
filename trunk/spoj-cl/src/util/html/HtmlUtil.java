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
package util.html;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * A class to help translate useful things from HTML to common unicode Strings.
 * 
 * @author Anderson Dorow
 */
public final class HtmlUtil {

	/**
	 * Translates a HTML String to a common <code>java.lang.String</code> representation. i.e. changes
	 * special HTML characters, such as <code>&amp;nbsp;</code> to the corresponding Strings they mean.
	 * 
	 * @param html
	 *            the HTML to be translated.
	 * @return the translated HTML.
	 */
	public static String translateSpecialCharacters(String html) {
		return StringEscapeUtils.unescapeHtml(html);
	}

	/**
	 * Remove tags from a HTML string.
	 * 
	 * @param html
	 *            the html string.
	 * @return the html, with all tags removed.
	 */
	public static String removeTags(String html) {
		return html.replaceAll("<[^>]*>", "");
	}

}
