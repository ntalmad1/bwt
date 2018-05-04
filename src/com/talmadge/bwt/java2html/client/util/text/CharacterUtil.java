package com.talmadge.bwt.java2html.client.util.text;

/**
 * 
 *
 */
public final class CharacterUtil
{
	/**
	 */
	static final short[] CHARACTER_TYPES = new short[65536];

	/**
	 */
	private static final short IS_DIGIT = 0x0001;

	/**
	 */
	private static final short IS_JAVA_IDENTIFIER_PART = 0x0002;

	/**
	 */
	private static final short IS_JAVA_IDENTIFIER_START = 0x0004;

	/**
	 */
	private static final short IS_LETTER = 0x0008;

	/**
	 */
	private static final short IS_LETTER_OR_DIGIT = IS_LETTER | IS_DIGIT;

	/**
	 */
	private static final short IS_LOWER_CASE = 0x0010;

	/**
	 */
	private static final short IS_SPACE_CHAR = 0x0020;

	/**
	 */
	private static final short IS_TITLE_CASE = 0x0040;

	/**
	 */
	private static final short IS_UNICODE_IDENTIFIER_PART = 0x0080;

	/**
	 */
	private static final short IS_UNICODE_IDENTIFIER_START = 0x0100;

	/**
	 */
	private static final short IS_UPPER_CASE = 0x0200;

	/**
	 */
	private static final short IS_WHITESPACE = 0x0400;

	/**
	 */
	private static final short IS_HEX_LETTER = 0x0800;

	/**
	 */
	private static final short IS_HEX_DIGIT = IS_DIGIT | 0x0800;

	static
	{
		for (char ch = 0; ch < 65535; ch++)
		{
			short properties = 0x0;

			if (Character.isDigit(ch))
			{
				properties |= IS_DIGIT;
			}

			if (CharacterUtil.isJavaIdentifierPart(ch))
			{
				properties |= IS_JAVA_IDENTIFIER_PART;
			}

			if (CharacterUtil.isJavaIdentifierStart(ch))
			{
				properties |= IS_JAVA_IDENTIFIER_START;
			}

			if (CharacterUtil.isLetter(ch))
			{
				properties |= IS_LETTER;
			}
			if (CharacterUtil.isLowerCase(ch))
			{
				properties |= IS_LOWER_CASE;
			}
			if (CharacterUtil.isSpaceChar(ch))
			{
				properties |= IS_SPACE_CHAR;
			}
			if (CharacterUtil.isTitleCase(ch))
			{
				properties |= IS_TITLE_CASE;
			}
			if (CharacterUtil.isUnicodeIdentifierPart(ch))
			{
				properties |= IS_UNICODE_IDENTIFIER_PART;
			}
			if (CharacterUtil.isUnicodeIdentifierStart(ch))
			{
				properties |= IS_UNICODE_IDENTIFIER_START;
			}
			if (CharacterUtil.isUpperCase(ch))
			{
				properties |= IS_UPPER_CASE;
			}
			if (CharacterUtil.isWhitespace(ch))
			{
				properties |= IS_WHITESPACE;
			}

			CHARACTER_TYPES[ch] = properties;
		}

		CHARACTER_TYPES['A'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['a'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['B'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['b'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['C'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['c'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['D'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['d'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['E'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['e'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['F'] |= IS_HEX_LETTER;
		CHARACTER_TYPES['f'] |= IS_HEX_LETTER;

	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isDigit(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isDigit (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_DIGIT) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isJavaIdentifierPart(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isJavaIdentifierPart (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_JAVA_IDENTIFIER_PART) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isJavaIdentifierStart(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isJavaIdentifierStart (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_JAVA_IDENTIFIER_START) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isLetter(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isLetter (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_LETTER) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isLetterOrDigit(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isLetterOrDigit (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_LETTER_OR_DIGIT) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isLowerCase(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isLowerCase (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_LOWER_CASE) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isSpaceChar(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isSpaceChar (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_SPACE_CHAR) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isSpaceChar(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isTitleCase (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_TITLE_CASE) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isUnicodeIdentifierPart(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isUnicodeIdentifierPart (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_UNICODE_IDENTIFIER_PART) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isUnicodeIdentifierStart(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isUnicodeIdentifierStart (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_UNICODE_IDENTIFIER_START) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isUpperCase(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isUpperCase (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_UPPER_CASE) > 0;
	}


	/**
	 * Provides a high performance implementation of the Character method
	 * 
	 * @see Character#isWhitespace(char)
	 * 
	 * @param ch char
	 * @return boolean
	 */
	public static boolean isWhitespace (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_WHITESPACE) > 0;
	}


	/**
	 * Checks if the character is a hexadecimal digit (i.e. a digit, a-f, or
	 * A-F)
	 * 
	 * @param ch the character to check
	 * @return true if the character is a hex digit, false otherwise.
	 */
	public static boolean isHexDigit (char ch)
	{
		return (CHARACTER_TYPES[ch] & IS_HEX_DIGIT) > 0;
	}

	
	/**
	 * Hidden Constructor 
	 *
	 */
	private CharacterUtil ()
	{
		
	}
}
