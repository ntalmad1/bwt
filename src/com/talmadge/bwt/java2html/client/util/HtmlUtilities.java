package com.talmadge.bwt.java2html.client.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Some methods for converting text to valid HTML.
 *
 * For questions, suggestions, bug-reports, enhancement-requests etc. I may be
 * contacted at: <a href="mailto:markus@jave.de">markus@jave.de</a>
 *
 * The Java2html home page is located at: <a
 * href="http://www.java2html.de">http://www.java2html.de</a>
 *
 * @author <a href="mailto:markus@jave.de">Markus Gebhard</a>
 * @version 2.0, 05/07/02
 *
 *          Copyright (C) Markus Gebhard 2000-2002
 *
 *          This program is free software; you can redistribute it and/or modify
 *          it under the terms of the GNU General Public License as published by
 *          the Free Software Foundation; either version 2 of the License, or
 *          (at your option) any later version.
 *
 *          This program is distributed in the hope that it will be useful, but
 *          WITHOUT ANY WARRANTY; without even the implied warranty of
 *          MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *          General Public License for more details.
 * 
 *          You should have received a copy of the GNU General Public License
 *          along with this program; if not, write to the Free Software
 *          Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *          02111-1307, USA.
 */
public final class HtmlUtilities
{
	/**
	 */
	private static Map<String, String> entityTableEncode;
	
	/**
	 */
	private static final String[] ENTITIES = 
	{
      // IGNORE (during encoding!!)
			" ", //$NON-NLS-1$
			" ", //$NON-NLS-1$
			"-", //$NON-NLS-1$
			"-", //$NON-NLS-1$
			"'", //$NON-NLS-1$
			"'", //$NON-NLS-1$
			"`", //$NON-NLS-1$
			"`", //$NON-NLS-1$

			// UPPERCASE
			"&Uuml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&Auml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&Ouml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&Euml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&Ccedil;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&AElig;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&Aring;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&Oslash;", //$NON-NLS-1$
			"�", //$NON-NLS-1$

			// OTHERS -> ignorecase!
			"&uuml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&auml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ouml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&euml;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ccedil;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&aring;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&oslash;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&grave;", //$NON-NLS-1$
			"`", //$NON-NLS-1$
			"&agrave;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&egrave;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&igrave;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ograve;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ugrave;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&amp;", //$NON-NLS-1$
			"&", //$NON-NLS-1$
			"&#34;", //$NON-NLS-1$
			"\"", //$NON-NLS-1$
			// same as &quot; - but &quot; is not part of HTML3.2!!!
			"&szlig;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&nbsp;", //$NON-NLS-1$
			" ", //$NON-NLS-1$
			"&gt;", //$NON-NLS-1$
			">", //$NON-NLS-1$
			"&lt;", //$NON-NLS-1$
			"<", //$NON-NLS-1$
			"&copy;", //$NON-NLS-1$
			"(C)", //$NON-NLS-1$
			"&cent;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&pound;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&laquo;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&raquo;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&reg;", //$NON-NLS-1$
			"(R)", //$NON-NLS-1$
			"&middot;", //$NON-NLS-1$
			" - ", //$NON-NLS-1$
			"&times;", //$NON-NLS-1$
			" x ", //$NON-NLS-1$
			"&acute;", //$NON-NLS-1$
			"'", //$NON-NLS-1$ //$NON-NLS-1$
			"&aacute;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&uacute;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&oacute;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&eacute;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&iacute;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ntilde;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&sect;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&egrave;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&icirc;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ocirc;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&acirc;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ucirc;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&ecirc;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&aelig;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&iexcl;", //$NON-NLS-1$
			"�", //$NON-NLS-1$
			"&#151;", //$NON-NLS-1$
			"-", //$NON-NLS-1$
			"&#0151;", //$NON-NLS-1$
			"-", //$NON-NLS-1$
			"&#0146;", //$NON-NLS-1$
			"'", //$NON-NLS-1$
			"&#146;", //$NON-NLS-1$
			"'", //$NON-NLS-1$
			"&#0145;", //$NON-NLS-1$
			"'", //$NON-NLS-1$
			"&#145;", //$NON-NLS-1$
			"'", //$NON-NLS-1$
			"&quot;", //$NON-NLS-1$
			"\"", }; //$NON-NLS-1$

	
	/**
	 * Converts a String to HTML by converting all special characters to
	 * HTML-entities.
	 * 
	 * @param s String
	 * @param ignore String
	 * @return String
	 */
	public static String encode (String s, String ignore)
	{
		return encode(s, 0, s.length(), ignore);
	}


	/**
	 * Converts a String to HTML by converting all special characters to
	 * HTML-entities. Only s,substring(start,end) will be encoded.
	 * 
	 * @param s String
	 * @param start int 
	 * @param end int
	 * @param ignore String
	 * @return String
	 */
	public static String encode (String s, int start, int end, String ignore)
	{
		if (entityTableEncode == null)
		{
			buildEntityTables();
		}

		StringBuffer sb = new StringBuffer((end - start) * 2);
		char ch;
		for (int i = start; i < end; ++i)
		{
			ch = s.charAt(i);
			if ((ch >= 63 && ch <= 90) || (ch >= 97 && ch <= 122) || ignore.indexOf(ch) != -1)
			{
				sb.append(ch);
			}
			else
			{
				sb.append(encodeSingleChar(String.valueOf(ch)));
			}
		}
		return sb.toString();
	}


	/**
	 * Converts the given Color object to a String contaning the html
	 * description of the color. E.g.: #FF8080.
	 * 
	 * @param color RGB
	 * @return String
	 */
	public static String toHTML (RGB color)
	{
		String red = Integer.toHexString(color.getRed());
		String green = Integer.toHexString(color.getGreen());
		String blue = Integer.toHexString(color.getBlue());

		if (red.length() == 1)
		{
			red = "0" + red; //$NON-NLS-1$
		}
		if (green.length() == 1)
		{
			green = "0" + green; //$NON-NLS-1$
		}
		if (blue.length() == 1)
		{
			blue = "0" + blue; //$NON-NLS-1$
		}

		return "#" + red + green + blue; //$NON-NLS-1$
	}


	/**
	 * 
	 */
	protected static void buildEntityTables ()
	{
		entityTableEncode = new HashMap<String, String>(ENTITIES.length);
	
		for (int i = 0; i < ENTITIES.length; i += 2)
		{
			if (!entityTableEncode.containsKey(ENTITIES[i + 1]))
			{
				entityTableEncode.put(ENTITIES[i + 1], ENTITIES[i]);
			}
		}
	}


	/**
	 * Converts a single character to HTML
	 * 
	 * @param ch String
	 * @return String
	 */
	protected static String encodeSingleChar (String ch)
	{
		String s = (String) entityTableEncode.get(ch);
		return (s == null) ? ch : s;
	}

	
	/**
	 * Hidden Constructor 
	 *
	 */
	private HtmlUtilities ()
	{
		// No instance available
	}
}