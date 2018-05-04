package com.talmadge.bwt.java2html.client.util.text;

/**
 * 
 *
 */
public final class CharSequenceUtil
{
	/**
	 */
	private static final long DAY_MILLIS = 86400000L;

	/**
	 */
	private static final long HOUR_MILLIS = 3600000L;

	/**
	 */
	private static final long MINUTE_MILLIS = 60000L;

	/**
	 */
	private static final long SECOND_MILLIS = 1000L;


	/**
	 * Checks if all characters in the string are digits
	 * 
	 * @param str the string to check
	 * @return true if all chars are digits, false otherwise
	 * @see CharacterUtil#isDigit(char)
	 */
	public static boolean isDigits (CharSequence str)
	{
		if (str == null)
		{
			return false;
		}
		int length = str.length();
		int pos = 0;
		while (pos < length)
		{
			if (!CharacterUtil.isDigit(str.charAt(pos++)))
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * Checks if all characters in the string are letters
	 * 
	 * @param str the string to check
	 * @return true if all chars are letters, false otherwise
	 * @see CharacterUtil#isLetter(char)
	 */
	public static boolean isLetters (CharSequence str)
	{
		if (str == null)
		{
			return false;
		}
		int length = str.length();
		int pos = 0;
		while (pos < length)
		{
			if (!CharacterUtil.isLetter(str.charAt(pos++)))
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * Checks if all characters in the string are letters or digits
	 * 
	 * @param str the string to check
	 * @return true if all chars are letters or digits, false otherwise
	 * @see CharacterUtil#isLetterOrDigit(char)
	 */
	public static boolean isLettersOrDigits (CharSequence str)
	{
		if (str == null)
		{
			return false;
		}
		int length = str.length();
		int pos = 0;
		while (pos < length)
		{
			if (!CharacterUtil.isLetterOrDigit(str.charAt(pos++)))
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * Checks if a char sequence contains only characters between 0x0020 (space)
	 * and 0x007E (~) as well as characters between 0x00A0 and 0x00FF
	 * 
	 * @param seq the sequence to check
	 * @return true if the sequence contains only characters between 0x0020
	 *         (space) and 0x007E (~) as well as characters between 0x00A0 and
	 *         0x00FF. false otherwise.
	 */
	public static boolean isLatin (CharSequence seq)
	{
		if (seq == null)
		{
			return false;
		}
		int length = seq.length();
		int pos = 0;
		while (pos < length)
		{
			char ch = seq.charAt(pos++);
			if (ch < 0x0020 || ch > 0x00FF || ch > 0x007E && ch < 0x00A0)
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * Checks if a char sequence contains only characters between 0x0020 (space)
	 * and 0x007E (~)
	 * 
	 * @param seq the sequence to check
	 * @return true if the sequence contains only characters between 0x0020
	 *         (space) and 0x007E (~). false otherwise.
	 */
	public static boolean isBasicLatinUppercase (CharSequence seq)
	{
		if (seq == null)
		{
			return false;
		}
		int length = seq.length();
		int pos = 0;
		while (pos < length)
		{
			char ch = seq.charAt(pos++);
			if (ch < 0x0020 || ch > 0x007E)
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * Checks if all characters in the string may represent a hexadecimal
	 * literal
	 * 
	 * @param str the string to check
	 * @return true if all chars are a-f, A-F, or digits, false otherwise
	 * @see CharacterUtil#isHexDigit(char)
	 */
	public static boolean isHex (CharSequence str)
	{
		if (str == null)
		{
			return false;
		}
		int length = str.length();
		if (length == 0)
		{
			return false;
		}
		int pos = 0;
		while (pos < length)
		{
			if (!CharacterUtil.isHexDigit(str.charAt(pos++)))
			{
				return false;
			}
		}
		return true;
	}


	/**
	 * Replaces java style escape characters in the string
	 * 
	 * @param str the string which may contain escaped characters
	 * @return the string with the replaced characters
	 */
	public static CharSequence replaceJavaEscapeChars (CharSequence str)
	{
		int length = str.length();

		StringBuilder bld = null;
		int pos = 0;
		boolean escape = false;
		while (pos < length)
		{
			char ch = str.charAt(pos);
			if (escape)
			{
				switch (ch)
				{
					case '0':
						bld.append('\0');
						break;
					case 'b':
						bld.append('\b');
						break;
					case 'f':
						bld.append('\f');
						break;
					case 'n':
						bld.append('\n');
						break;
					case 'r':
						bld.append('\r');
						break;
					case 't':
						bld.append('\t');
						break;
					case '\\':
						bld.append('\\');
						break;
					case '\"':
						bld.append('\"');
						break;
					case '\'':
						bld.append('\'');
						break;
					case 'u':
						if (length > pos + 4)
						{
							try
							{
								CharSequence hex = str.subSequence(pos + 1, pos + 5);
								if (isHex(hex))
								{
									bld.append((char) Integer.parseInt(hex.toString(), 0x10));
									pos += 4;
								}
								else
								{
									bld.append("\\u");
								}
							}
							catch (NumberFormatException ex)
							{
								bld.append("\\u");
							}
							break;
						}
						else
						{
							bld.append("\\u");
						}
					default:
						bld.append('\\');
						bld.append(ch);
				}
				escape = false;
			}
			else
			{
				if (ch == '\\')
				{
					escape = true;
					if (bld == null)
					{
						bld = new StringBuilder(length);
						bld.append(str.subSequence(0, pos));
					}
				}
				else if (bld != null)
				{
					bld.append(ch);
				}
			}
			pos++;
		}

		if (bld == null)
		{
			return str;
		}

		return bld;
	}


	/**
	 * This method maps all characters which are not between 0x0020 (space) and
	 * 0x007E or between 0x00A0 and 0x00FF to values between 0x0020 and 0x007E
	 * by crude and/or bit operations.
	 * <p>
	 * Only exceptions are Greek characters, which are converted using something
	 * similar to the <a href="http://en.wikipedia.org/wiki/Beta_code">Beta
	 * Code</a> (using upper and lower case characters instead of upper case
	 * characters with optional stars and numbers...).
	 * 
	 * @param seq the character sequence to make latin
	 * @return a character sequence containing only latin characters
	 */
	public static CharSequence makeLatin (CharSequence seq)
	{
		if (seq == null)
		{
			return null;
		}
		StringBuilder result = null;
		int length = seq.length();
		int pos = 0;
		while (pos < length)
		{
			char ch = seq.charAt(pos++);
			if (ch < 0x0020 || ch > 0x00FF || ch > 0x007E && ch < 0x00A0)
			{
				if (result == null)
				{
					result = new StringBuilder(length);
					result.append(seq.subSequence(0, pos - 1));
				}
				if (ch >= 0x0390 && ch < 0x410)
				{
					char beta = CharSequenceUtil.PSEUDO_BETA_CODE[ch - 0x0390];
					if (beta > 0x0000)
					{
						ch = beta;
					}
					else
					{
						ch = (char) (ch & 0x007F);
						if (ch < 0x0020)
						{
							ch = (char) (ch | 0x0020);
						}
						else if (ch == 0x007F)
						{
							ch = 0x0020;
						}
					}
				}
				else
				{
					ch = (char) (ch & 0x007F);
					if (ch < 0x0020)
					{
						ch = (char) (ch | 0x0020);
					}
					else if (ch == 0x007F)
					{
						ch = 0x0020;
					}
				}
				result.append(ch);
			}
			else if (result != null)
			{
				result.append(ch);
			}
		}
		return (result == null ? seq : result);
	}


	/**
	 * This method converts the given CharSequence to upper case and replaces
	 * supplement characters by their corresponding base characters. It is
	 * defined for CharSequences containing characters between 0x0020 (space)
	 * and 0x007E (~) as well as characters between 0x00A0 and 0x00FF.
	 * <p>
	 * The method converts the characters in the given CharSequence by
	 * 
	 * <ul>
	 * <li>replacing <a href="http://unicode.org/charts/PDF/U0080.pdf">Latin
	 * Supplement Characters</a> with their corresponding base characters.</li>
	 * <li>replacing all lower case with upper case characters</li>
	 * <li>replacing punctuations and special characters beyond 0x005F with
	 * similar characters.</li>
	 * </ul>
	 * <p>
	 * All characters in the returned CharSequence are in the range 0x0020 to
	 * 0x005F.
	 * 
	 * @param seq the string to be converted. Characters must be from 0x0020 to
	 *            0x007E and/or 0x00A0 to 0x00FF
	 * @return a CharSequence containing only characters from 0x0020 to 0x005F.
	 *         If no conversion is necessary, the original String is returned
	 */
	public static CharSequence toBasicLatinUpperCase (CharSequence seq)
	{
		int len = seq.length();
		StringBuilder result = null;
		for (int i = 0; i < len; i++)
		{
			char ch = seq.charAt(i);
			if (ch > 0x005F)
			{
				if (ch > 0x00FF)
				{
					throw new IllegalArgumentException(STRING_CONTAINS_UNCONVERTIBLE_CHARACTER_0X + Integer.toHexString(seq.charAt(i)) + "!");
				}

				ch = CONVERT_TO_BASIC_LATIN_UPPER[ch];
				if (ch == 0x0000)
				{
					throw new IllegalArgumentException(STRING_CONTAINS_UNCONVERTIBLE_CHARACTER_0X + Integer.toHexString(seq.charAt(i)) + "!");
				}
				if (result == null)
				{
					result = new StringBuilder(len);
					if (i > 1)
					{
						result.append(seq.subSequence(0, i));
					}
					else if (i == 1)
					{
						result.append(seq.charAt(0));
					}
				}
				result.append(ch);
			}
			else if (ch < 0x0020)
			{
				throw new IllegalArgumentException(STRING_CONTAINS_UNCONVERTIBLE_CHARACTER_0X + Integer.toHexString(ch) + "!");
			}
			else if (result != null)
			{
				result.append(ch);
			}
		}

		return (result == null ? seq : result);
	}

	/**
	 */
	private static final String STRING_CONTAINS_UNCONVERTIBLE_CHARACTER_0X = "String contains unconvertible character 0x";

	/**
	 */
	static final int LOWER_TO_UPPER = 'A' - 'a';

	/**
	 */
	static final char[] CONVERT_TO_BASIC_LATIN_UPPER = new char[0x100];

	static
	{
		for (char ch = 0x0020; ch < 0x100; ch++)
		{
			if (ch > 0x005F)
			{
				char replace = 0x0000;
				if (ch >= 0x0061 && ch <= 0x007F)
				{
					replace = (char) (ch + LOWER_TO_UPPER);
				}
				else if (ch == 0x00F7)
				{
					replace = '/';
				}
				else if (ch == 0x0060)
				{
					replace = '\'';
				}
				else
				{
					if (ch >= 0x00E0 && ch <= 0x00FE)
					{
						replace = (char) (ch + LOWER_TO_UPPER);
					}
					else
					{
						replace = ch;
					}
					if (replace >= 0x00C0 && replace <= 0x00DF)
					{
						if (replace >= 0x00C0 && replace <= 0x00C6)
						{
							replace = 'A';
						}
						else if (replace == 0x00C7)
						{
							replace = 'C';
						}
						else if (replace >= 0x00C8 && replace <= 0x00CB)
						{
							replace = 'E';
						}
						else if (replace >= 0x00CC && replace <= 0x00CF)
						{
							replace = 'I';
						}
						else if (replace == 0x00D0)
						{
							replace = 'D';
						}
						else if (replace == 0x00D1)
						{
							replace = 'N';
						}
						else if (replace == 0x00D7)
						{
							replace = '*';
						}
						else if (replace >= 0x00D2 && replace <= 0x00D8)
						{
							replace = 'O';
						}
						else if (replace >= 0x00D9 && replace <= 0x00DC)
						{
							replace = 'U';
						}
						else if (replace == 0x00DD)
						{
							replace = 'Y';
						}
						else if (replace == 0x00DE)
						{
							replace = 'B';
						}
						else if (replace == 0x00DF)
						{
							replace = 'S';
						}
					}
					else if (ch == 0x00FF)
					{
						replace = 'Y';
					}
					else if (ch >= 0x00A0 && ch <= 0x00BF)
					{
						switch (ch)
						{
							case 0x00A0:
							case 0x00B8:
								replace = ' ';
								break;
							case 0x00A1:
								replace = '!';
								break;
							case 0x00A2:
							case 0x00A9:
								replace = 'C';
								break;
							case 0x00A3:
								replace = '$';
								break;
							case 0x00A4:
							case 0x00B7:
								replace = '*';
								break;
							case 0x00A5:
								replace = 'Y';
								break;
							case 0x00A6:
								replace = '\\';
								break;
							case 0x00A7:
								replace = '$';
								break;
							case 0x00A8:
							case 0x00AB:
							case 0x00BB:
								replace = '\"';
								break;
							case 0x00AA:
								replace = 'A';
								break;
							case 0x00AC:
							case 0x00B0:
							case 0x00BA:
								replace = '^';
								break;
							case 0x00AD:
								replace = '-';
								break;
							case 0x00AE:
								replace = 'R';
								break;
							case 0x00AF:
								replace = '_';
								break;
							case 0x00B1:
								replace = '+';
								break;
							case 0x00B2:
							case 0x00BD:
								replace = '2';
								break;
							case 0x00B3:
							case 0x00BE:
								replace = '3';
								break;
							case 0x00B4:
								replace = '\'';
								break;
							case 0x00B5:
								replace = 'M';
								break;
							case 0x00B6:
								replace = 'P';
								break;
							case 0x00B9:
								replace = '1';
								break;
							case 0x00BC:
								replace = '4';
								break;
							case 0x00BF:
								replace = '?';
								break;
							default:
								break;
						}
					}
				}
				CONVERT_TO_BASIC_LATIN_UPPER[ch] = replace;
			}
			else
			{
				CONVERT_TO_BASIC_LATIN_UPPER[ch] = ch;
			}

		}
	}
	
	/**
	 */
	public static final char[] PSEUDO_BETA_CODE;

	static
	{
		PSEUDO_BETA_CODE = new char[0x80];
		PSEUDO_BETA_CODE[1] = 'A';
		PSEUDO_BETA_CODE[2] = 'B';
		PSEUDO_BETA_CODE[3] = 'G';
		PSEUDO_BETA_CODE[4] = 'D';
		PSEUDO_BETA_CODE[5] = 'E';
		PSEUDO_BETA_CODE[6] = 'Z';
		PSEUDO_BETA_CODE[7] = 'H';
		PSEUDO_BETA_CODE[8] = 'Q';
		PSEUDO_BETA_CODE[9] = 'I';
		PSEUDO_BETA_CODE[10] = 'K';
		PSEUDO_BETA_CODE[11] = 'L';
		PSEUDO_BETA_CODE[12] = 'M';
		PSEUDO_BETA_CODE[13] = 'N';
		PSEUDO_BETA_CODE[14] = 'C';
		PSEUDO_BETA_CODE[15] = 'O';
		PSEUDO_BETA_CODE[16] = 'P';
		PSEUDO_BETA_CODE[17] = 'R';
		PSEUDO_BETA_CODE[19] = 'S';
		PSEUDO_BETA_CODE[20] = 'T';
		PSEUDO_BETA_CODE[21] = 'U';
		PSEUDO_BETA_CODE[22] = 'F';
		PSEUDO_BETA_CODE[23] = 'X';
		PSEUDO_BETA_CODE[24] = 'Y';
		PSEUDO_BETA_CODE[25] = 'W';
		PSEUDO_BETA_CODE[33] = 'a';
		PSEUDO_BETA_CODE[34] = 'b';
		PSEUDO_BETA_CODE[35] = 'g';
		PSEUDO_BETA_CODE[36] = 'd';
		PSEUDO_BETA_CODE[37] = 'e';
		PSEUDO_BETA_CODE[38] = 'z';
		PSEUDO_BETA_CODE[39] = 'h';
		PSEUDO_BETA_CODE[40] = 'q';
		PSEUDO_BETA_CODE[41] = 'i';
		PSEUDO_BETA_CODE[42] = 'k';
		PSEUDO_BETA_CODE[43] = 'l';
		PSEUDO_BETA_CODE[44] = 'm';
		PSEUDO_BETA_CODE[45] = 'n';
		PSEUDO_BETA_CODE[46] = 'c';
		PSEUDO_BETA_CODE[47] = 'o';
		PSEUDO_BETA_CODE[48] = 'p';
		PSEUDO_BETA_CODE[49] = 'r';
		PSEUDO_BETA_CODE[50] = 's';
		PSEUDO_BETA_CODE[51] = 's';
		PSEUDO_BETA_CODE[52] = 't';
		PSEUDO_BETA_CODE[53] = 'u';
		PSEUDO_BETA_CODE[54] = 'f';
		PSEUDO_BETA_CODE[55] = 'x';
		PSEUDO_BETA_CODE[56] = 'y';
		PSEUDO_BETA_CODE[57] = 'w';
		PSEUDO_BETA_CODE[98] = 's';
		PSEUDO_BETA_CODE[105] = 'S';
	}

	/**
	 * 
	 * @param millis long
	 * @param writeMillis boolean
	 * @return CharSequence
	 */
	public static CharSequence duration (long millis, boolean writeMillis)
	{
		StringBuilder bld = new StringBuilder();
		long calc = millis;
		if (calc > DAY_MILLIS)
		{
			long days = calc / DAY_MILLIS;
			if (days == 1)
			{
				bld.append("1 day");
			}
			else
			{
				bld.append(days);
				bld.append(" days");
			}
			calc %= DAY_MILLIS;
		}
		if (calc > HOUR_MILLIS || bld.length() > 0)
		{
			if (bld.length() > 0)
			{
				bld.append("; ");
			}
			long hours = calc / HOUR_MILLIS;
			if (hours == 1)
			{
				bld.append("1 hour");
			}
			else
			{
				bld.append(hours);
				bld.append(" hours");
			}
			calc %= HOUR_MILLIS;
		}
		if (calc > MINUTE_MILLIS || bld.length() > 0)
		{
			if (bld.length() > 0)
			{
				bld.append("; ");
			}
			long minutes = calc / MINUTE_MILLIS;
			if (minutes == 1)
			{
				bld.append("1 minute");
			}
			else
			{
				bld.append(minutes);
				bld.append(" minutes");
			}
			calc %= MINUTE_MILLIS;
		}

		if (bld.length() > 0)
		{
			bld.append("; ");
		}
		long seconds = calc / SECOND_MILLIS;
		if (seconds == 1)
		{
			bld.append("1 seconds");
		}
		else
		{
			bld.append(seconds);
			bld.append(" seconds");
		}
		calc %= SECOND_MILLIS;

		if (writeMillis)
		{

			if (bld.length() > 0)
			{
				bld.append("; ");
			}

			if (calc == 1)
			{
				bld.append("1 milliseconds");
			}
			else
			{
				bld.append(calc);
				bld.append(" milliseconds");
			}

		}
		return bld;
	}

	
	/**
	 * Hidden Constructor 
	 *
	 */
	private CharSequenceUtil ()
	{
		
	}

}
