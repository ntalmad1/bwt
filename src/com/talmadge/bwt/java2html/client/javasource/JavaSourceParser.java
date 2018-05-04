package com.talmadge.bwt.java2html.client.javasource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.talmadge.bwt.java2html.client.options.JavaSourceConversionOptions;
import com.talmadge.bwt.java2html.client.util.proxy.StringTokenizerProxy;
import com.talmadge.bwt.java2html.client.util.text.CharacterUtil;

/**
 * Parses raw text to a {@link de.java2html.javasource.JavaSource} object. The
 * parser can not only handle grammatically correct Java source files but also
 * code snippets.
 * 
 * <p>
 * (Parsing is done in multiple steps starting with raw text where every
 * character is classified as UNDEFINED and trying to find out more about it
 * step by step. There are some state machines used for parsing. They are hand
 * coded and quite complicated. The parser seems to be very stable, as I have
 * not been reported a single bug now for about two years.)
 * 
 * <p>
 * For questions, suggestions, bug-reports, enhancement-requests etc. I may be
 * contacted at: <a href="mailto:markus@jave.de">markus@jave.de</a>
 * 
 * The Java2html home page is located at: <a href="http://www.java2html.de">
 * http://www.java2html.de</a>
 * 
 * @author <a href="mailto:markus@jave.de">Markus Gebhard</a>
 * 
 *         <code>Copyright (C) Markus Gebhard 2000-2003
 * 
 * This program is free software; you can redistribute it and/or
 *  * modify it under the terms of the GNU General Public License
 *  * as published by the Free Software Foundation; either version 2
 *  * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 *  * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.</code>
 */
public class JavaSourceParser
{
	/** Delimiters for numeric values. */
	private static final String NUM_DELIMITERS = " \t\n\r()[]{};:+-/\\*!?#%&|<>=^,";

	/** Delimiters for finding data types and keywords. */
	private static final String DELIMITERS = " \t\n\r()[]{};:.+-/\\*!?#%&|<>=^";

	/** Characters automatically classified as being empty (type==BACKGROUND) */
	private static final String EMPTY_STR = " \t\n\r\f";
	
	/**
	 */
	private static final String[] PRIMITIVE_DATATYPES = { "boolean", "byte",
			"char", "double", "float", "int", "long", "short", "void" };

	/**
	 * As defined by Java Language Specification SE �3,
	 */
	private static final String[] JAVA_KEYWORDS = { "assert", "abstract",
			"default", "if", "private", "this", "do", "implements",
			"protected", "throw", "break", "import", "public", "throws",
			"else", "instanceof", "return", "transient", "case", "extends",
			"try", "catch", "final", "interface", "static", "finally",
			"strictfp", "volatile", "class", "native", "super", "while",
			"const", "for", "new", "strictfp", "switch", "continue", "goto",
			"package", "synchronized", "threadsafe", "null", "true", "false",
			// Enum keyword from JDK1.5 (TypeSafe Enums)
			"enum", "@interface" };
	
	/**
	 */
	private static final String[] JAVADOC_KEYWORDS = { "@author", "@beaninfo",
			"@docRoot", "@deprecated", "@exception", "@link", "@param",
			"@return", "@see", "@serial", "@serialData", "@serialField",
			"@since", "@throws", "@version",
			// new in JDK1.4
			"@linkplain", "@inheritDoc", "@value",
			// from iDoclet
			"@pre", "@post", "@inv",
			// from disy
			"@published" };

	/**
	 */
	private static List<String> tableJavaDocKeywords;

	/**
	 */
	private static List<String> tableJavaKeywords;

	/** States for the first state machine */
	private static final short PARSESTATE_FINISHED = -1;
	
	/**
	 */
	private static final short COD = 0; // CODE

	/**
	 */
	private static final short CAC = 1; // CODE AWAIT COMMENT

	/**
	 */
	private static final short CL = 2; // COMMENT LINE

	/**
	 */
	private static final short CBJ1 = 3; // COMMENT BLOCK or COMMENT JAVADOC 1

	/**
	 */
	private static final short CBJ2 = 4; // COMMENT BLOCK or COMMENT JAVADOC 1

	/**
	 */
	private static final short CB = 5; // COMMENT BLOCK

	/**
	 */
	private static final short CBA = 6; // COMMENT BLOCK AWAIT END

	/**
	 */
	private static final short CJ = 7; // COMMENT JAVADOC

	/**
	 */
	private static final short CJA = 8; // COMMENT JAVADOC AWAIT END

	/**
	 */
	private static final short QU = 9; // QUOTE

	/**
	 */
	private static final short QUA = 10; // QUOTE AWAIT \"

	/**
	 */
	private static final short CH1 = 11; //

	/**
	 */
	private static final short CH2 = 12; //

	/**
	 */
	private static final short CH3 = 13; //

	/**
	 */
	private static final short CH4 = 14; //

	/**
	 */
	private static final short CH5 = 15; //

	/**
	 */
	private static final short CH6 = 16; //

	/** EOT=End of text */
	private static final char EOT = (char) -1;

	/** Additional states for the second state machine */
	private static final short PARSESTATE_START = 0;

	/**
	 */
	private static final short PARSESTATE_NEUTRAL = 1;

	/**
	 */
	private static final short PARSESTATE_DA = 2;

	/**
	 */
	private static final short PARSESTATE_NA = 3;

	/**
	 */
	private static final short PARSESTATE_EXP = 4;

	/**
	 */
	private static final short PARSESTATE_HEX = 5;

	/**
	 */
	private static final short PARSESTATE_HIA = 6;

	/**
	 * 
	 * @param ch char
	 * @param s String
	 * @param start int
	 * @param end int
	 * @return int
	 */
	private static int indexOf (char ch, String s, int start, int end)
	{
		if (end < start)
		{
			return -1;
		}
		
		for (int i = start; i <= end; ++i)
		{
			if (s.charAt(i) == ch)
			{
				return i;
			}
		}
	
		return -1;
	}


	/**
	 * 
	 * @param ch char
	 * @return boolean
	 */
	private static boolean isEmpty (char ch)
	{
		return (EMPTY_STR.indexOf(ch) != -1);
	}


	/**
	 * 
	 * @param sourceTypes JavaSourceType[]
	 * @param startIndex int
	 * @param endIndex int 
	 * @param javaSourceType JavaSourceType
	 * @return boolean
	 */
	private static boolean hasTypeOrEmpty (
			  JavaSourceType[] sourceTypes
			, int startIndex
			, int endIndex
			, JavaSourceType javaSourceType)
	{
	
		for (int i = startIndex; i <= endIndex; ++i)
		{
			if (!sourceTypes[i].equals(javaSourceType)
					&& !sourceTypes[i].equals(JavaSourceType.BACKGROUND))
			{
				return false;
			}
		}
		return true;
	}


	/** Counter for this and that (parseThree()?) */
	private int counter;

	/**
	 */
	private JavaSourceConversionOptions options;

	/** State informations for state machine one */
	private short parseState;

	/**
	 */
	private int parseSourcePos;

	/**
	 */
	private int parseTypePos;

	/** 
	 * The source code being converted 
	 */
	private JavaSource source;

	/** For faster access to source.getCode() */
	private String sourceCode;

	/** For faster access to source.getClassification() */
	private JavaSourceType[] sourceTypes;

	/**
	 * Constructor
	 * 
	 */
	public JavaSourceParser ()
	{
		this(JavaSourceConversionOptions.getDefault());
	}

	
	/**
	 * Constructor
	 * 
	 * @param options JavaSourceConversionOptions
	 */
	public JavaSourceParser (JavaSourceConversionOptions options)
	{
		buildTables();
		this.options = options;
	}


	/**
	 * 
	 * @param rawText String
	 * @return JavaSource 
	 * @throws IOException e
	 */
	public JavaSource parse (String rawText) throws IOException
	{
		//sourceCode = readPlainSource(reader);
		this.sourceCode = rawText;

		this.replaceTabs();
	
		this.sourceTypes = new JavaSourceType[sourceCode.length()];
		this.source = new JavaSource(sourceCode);
		this.source.setClassification(sourceTypes);
	
		this.parseOne();
		this.parseTwo();
		this.parseThree();
		this.parseFour();
		
		return source;
	}
	
	
	/**
	 * Baut aus den statischen String-Arrays die Hashtabellen auf, mit denen die
	 * Keywords im Quelltext gesucht werden.
	 */
	private synchronized void buildTables ()
	{
		if (tableJavaDocKeywords != null && tableJavaKeywords != null)
		{
			return;
		}
	
		tableJavaDocKeywords = new ArrayList<String>();
		for (int i = 0; i < JAVADOC_KEYWORDS.length; ++i)
		{
			tableJavaDocKeywords.add(JAVADOC_KEYWORDS[i]);
		}
	
		tableJavaKeywords = new ArrayList<String>();
		for (int i = 0; i < JAVA_KEYWORDS.length; ++i)
		{
			tableJavaKeywords.add(JAVA_KEYWORDS[i]);
		}
	}

	
	/**
	 * 
	 * @param start int
	 * @param end int
	 * @param checker IJavaSourceTypeChecker
	 * @return boolean
	 */
	private boolean checkRegion (int start, int end, IJavaSourceTypeChecker checker)
	{
		for (int i = start; i <= end; ++i)
		{
			if (!checker.isValid(sourceTypes[i]))
			{
				return false;
			}
		}
		return true;
	}


//	/**
//	 * Gathers statistical information from the source code. After parsing this
//	 * is quite easy and maybe it is useful for others. lineCount is needed for
//	 * the html converter.
//	 */
//	private void doStatistics ()
//	{
//		int index = 0;
//		source.getStatistic().clear();
//		source.getStatistic().setCharacterCount(sourceCode.length());
//		int linesContainingAnything = 0;
//	
//		if (sourceCode.length() == 0)
//		{
//			source.getStatistic().setLineCount(0);
//		}
//		else
//		{
//			StringTokenizer st = new StringTokenizer(sourceCode, "\n\r", true);
//			while (st.hasMoreTokens())
//			{
//				String line = st.nextToken();
//	
//				if (line.charAt(0) == '\r')
//				{
//					++index;
//				}
//				else if (line.charAt(0) == '\n')
//				{
//					++index;
//					source.getStatistic().setLineCount(
//							source.getStatistic().getLineCount() + 1);
//				}
//				else
//				{
//					++linesContainingAnything;
//					statistics(line, index);
//					index += line.length();
//				}
//			}
//			source.getStatistic().setLineCount(
//					source.getStatistic().getLineCount() + 1);
//		}
//	
//		// some empty lines without any were not counted
//		source.getStatistic().setEmptyLineCount(
//				source.getStatistic().getLineCount() - linesContainingAnything);
//	}

	
	/**
	 * 
	 */
	private void expandJavaDocLinks ()
	{
		expandEmbracedJavaDocTag("@link", JavaSourceType.JAVADOC_LINKS);
		expandEmbracedJavaDocTag("@linkplain", JavaSourceType.JAVADOC_LINKS);
	}

	
	/**
	 * 
	 * @param tag String
	 * @param type JavaSourceType
	 */
	private void expandEmbracedJavaDocTag (String tag, JavaSourceType type)
	{
		String pattern = "{" + tag;
	
		for (int index = 0; index < sourceTypes.length; ++index)
		{
			int start = sourceCode.indexOf(pattern, index);
			if (start == -1)
			{
				break;
			}
	
			char ch = sourceCode.charAt(start + pattern.length());
			if (Character.isLetterOrDigit(ch))
			{
				break;
			}
	
			if (!checkRegion(start + 1, start + 1 + tag.length() - 1,
					new IJavaSourceTypeChecker()
					{
						public boolean isValid (JavaSourceType type)
						{
							return type.equals(JavaSourceType.JAVADOC_KEYWORD);
						}
					}))
			{
				break;
			}
	
			int end = sourceCode.indexOf('}', start + pattern.length());
			if (end == -1)
			{
				break;
			}
	
			// Check region, can only be JavaDoc and Background
			if (checkRegion(start + 1 + tag.length(), end,
					new IJavaSourceTypeChecker()
					{
						public boolean isValid (JavaSourceType type)
						{
							return type.equals(JavaSourceType.BACKGROUND)
									|| type.equals(JavaSourceType.JAVADOC);
						}
					}))
			{
				markWithoutBackground(start, end, type);
			}
			index = end;
		}
	
	}


	/**
	 * 
	 * @param ch char
	 * @return boolean
	 */
	private boolean isNumberDelimiter (char ch)
	{
		return (NUM_DELIMITERS.indexOf(ch) != -1);
	}


	/**
	 * 
	 * @param ch char
	 * @return boolean
	 */
	private boolean isParenthesis (char ch)
	{
		return ch == '{' || ch == '}' || ch == '[' || ch == ']' || ch == '('
				|| ch == ')';
	}


	/**
	 * Marks the specified region int the source code to the given type.
	 * 
	 * @param start int
	 * @param endPlusOne int
	 * @param type JavaSourceType
	 */
	private void mark (int start, int endPlusOne, JavaSourceType type)
	{
		for (int i = start; i < endPlusOne; ++i)
		{
			sourceTypes[i] = type;
		}
	}


	/**
	 * Marks the character at the specified index to the given type.
	 * 
	 * @param index int 
	 * @param type JavaSourceType  
	 */
	private void mark (int index, JavaSourceType type)
	{
		sourceTypes[index] = type;
	}

	
	/**
	 * 
	 * @param start int
	 * @param end int
	 * @param type JavaSourceType
	 */
	private void markWithoutBackground (int start, int end, JavaSourceType type)
	{
		for (int i = start; i <= end; ++i)
		{
			if (!sourceTypes[i].equals(JavaSourceType.BACKGROUND))
			{
				sourceTypes[i] = type;
			}
		}
	}


	/**
	 * First step of parsing. All characters are classified 'UNDEFINED' and we
	 * try to divide this into: CODE, CHAR_CONSTANT, COMMENT_LINE,
	 * COMMENT_BLOCK, COMMENT_JAVADOC, BACKGROUND and QUOTE This is done by a
	 * quite complicate state machine.
	 */
	private void parseOne ()
	{
		parseState = COD;
		parseSourcePos = 0;
		parseTypePos = 0;

		while (parseState != PARSESTATE_FINISHED)
		{
			parseOneDo();
		}
	}


	/**
	 * State-machine for classifying the code to: CODE, CHAR_CONSTANT,
	 * COMMENT_LINE, COMMENT_BLOCK, COMMENT_JAVADOC, BACKGROUND and QUOTE
	 * 
	 * Note: It works - don't ask me how! If you want to know more about it all
	 * you can do is taking a sheet of paper (or more) and a pencil and try to
	 * draw the state machine :-)
	 */
	private void parseOneDo ()
	{
		char ch = EOT;
		if (sourceCode.length() > parseSourcePos)
		{
			ch = sourceCode.charAt(parseSourcePos++);
		}

		switch (parseState)
		{
			case COD:
				cod(ch);
				return;
			case CAC:
				cac(ch);
				return;
			case CL:
				cl(ch);
				return;
			case CB:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch == '*')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					parseState = CBA;
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					return;
				}
				sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
				return;
			case CBA:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch == '/')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					parseState = COD;
					return;
				}
				if (ch == '*')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					parseState = CBA;
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					parseState = CB;
					return;
				}
				sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
				parseState = CB;
				return;
			case CJ:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch == '*')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
					parseState = CJA;
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					return;
				}
				sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
				return;
			case CJA:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch == '/')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
					parseState = COD;
					return;
				}
				if (ch == '*')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
					parseState = CJA;
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					parseState = CJ;
					return;
				}
				sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
				parseState = CJ;
				return;
			case QU:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch == '"')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.STRING;
					parseState = COD;
					return;
				}
				if (ch == '\\')
				{
					parseState = QUA;
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					return;
				}

				sourceTypes[parseTypePos++] = JavaSourceType.STRING;
				return;
			case QUA:
				if (ch == EOT)
				{
					sourceTypes[parseTypePos++] = JavaSourceType.STRING;
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch == '\\')
				{
					sourceTypes[parseTypePos++] = JavaSourceType.STRING;
					sourceTypes[parseTypePos++] = JavaSourceType.STRING;
					parseState = QU; // This one has been changed from QUA to QU
										// in 2.0
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.STRING;
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					parseState = QU;
					return;
				}
				sourceTypes[parseTypePos++] = JavaSourceType.STRING;
				sourceTypes[parseTypePos++] = JavaSourceType.STRING;
				parseState = QU;
				return;
			case CBJ1:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
					sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
					return;
				}
				if (ch == '*')
				{
					parseState = CBJ2;
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					parseState = CB;
					return;
				}
				sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
				sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
				sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
				parseState = CB;
				return;
			case CBJ2:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
					sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
					sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
					return;
				}
				if (ch == '/')
				{
					parseState = COD;
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_BLOCK;
					return;
				}
				if (isEmpty(ch))
				{
					sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
					sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
					sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
					sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
					parseState = CJ;
					return;
				}
				sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
				sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
				sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
				sourceTypes[parseTypePos++] = JavaSourceType.JAVADOC;
				parseState = CJ;
				return;
			case CH1:
				ch1(ch);
				return;
			case CH2:
				ch2(ch);
				return;
			case CH3:
				ch3(ch);
				return;
			case CH4:
				ch4(ch);
				return;
			case CH6:
				ch6(ch);
				return;
			case CH5:
				ch5(ch);
				return;
			default:
				break;
		}
	}


	/**
	 * 
	 * @param ch char
	 */
	private void cl (char ch)
	{
		if (ch == EOT)
		{
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == '\n' || ch == '\r')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
			// ggf. durch COMMENT_LINE ersetzen
			parseState = COD;
			return;
		}
		if (isEmpty(ch))
		{
			sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
			return;
		}
		sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_LINE;
		return;
	}


	/**
	 * 
	 * @param ch char
	 */
	private void cac (char ch)
	{
		if (ch == EOT)
		{
			parseState = PARSESTATE_FINISHED;
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			return;
		}
		if (ch == '/')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_LINE;
			sourceTypes[parseTypePos++] = JavaSourceType.COMMENT_LINE;
			parseState = CL;
			return;
		}
		if (ch == '*')
		{
			parseState = CBJ1;
			return;
		}
		if (isEmpty(ch))
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
			parseState = COD;
			return;
		}

		sourceTypes[parseTypePos++] = JavaSourceType.CODE;
		sourceTypes[parseTypePos++] = JavaSourceType.CODE;
		parseState = COD;
	}


	/**
	 * 
	 * @param ch char
	 */
	private void cod (char ch)
	{
		if (ch == EOT)
		{
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == '/')
		{
			parseState = CAC;
			return;
		}
		if (ch == '"')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.STRING;
			parseState = QU;
			return;
		}
		if (ch == '\'')
		{
			parseState = CH1;
			return;
		}
		if (isEmpty(ch))
		{
			sourceTypes[parseTypePos++] = JavaSourceType.BACKGROUND;
			return;
		}

		sourceTypes[parseTypePos++] = JavaSourceType.CODE;
	}


	/**
	 * 
	 * @param ch char
	 */
	private void ch4 (char ch)
	{
		if (ch == EOT)
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == '\'')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			parseState = COD;
			return;
		}
		sourceTypes[parseTypePos++] = JavaSourceType.CODE;
		sourceTypes[parseTypePos++] = JavaSourceType.CODE;
		sourceTypes[parseTypePos++] = JavaSourceType.CODE;
		sourceTypes[parseTypePos++] = JavaSourceType.CODE;
		parseState = COD;
	}


	/**
	 * 
	 * @param ch char
	 */
	private void ch3 (char ch)
	{
		if (ch == EOT)
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == 'u')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			parseState = CH5;
			return;
		}
		if (ch >= '1' && ch <= '9')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			parseState = CH6;
			return;
		}
		parseState = CH4;
	}


	/**
	 * 
	 * @param ch char
	 */
	private void ch2 (char ch)
	{
		if (ch == EOT)
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == '\'')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			parseState = COD;
			return;
		}
		sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
		sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
		sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
		parseState = COD;
	}


	/**
	 * 
	 * @param ch char
	 */
	private void ch1 (char ch)
	{
		if (ch == EOT)
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CODE;
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == '\\')
		{
			parseState = CH3;
			return;
		}
		parseState = CH2;
	}


	/**
	 * 
	 * @param ch char
	 */
	private void ch6 (char ch)
	{
		if (ch == EOT)
		{
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == '\'')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			parseState = COD;
			return;
		}
		if (ch >= '0' && ch <= '9')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			return;
		}
		sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
		parseState = COD;
	}

	
	/**
	 * 
	 * @param ch char
	 */
	private void ch5 (char ch)
	{
		if (ch == EOT)
		{
			parseState = PARSESTATE_FINISHED;
			return;
		}
		if (ch == '\'')
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			parseState = COD;
			return;
		}
		if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f')
				|| (ch >= 'A' && ch <= 'F'))
		{
			sourceTypes[parseTypePos++] = JavaSourceType.CHAR_CONSTANT;
			return;
		}
		sourceTypes[parseTypePos++] = JavaSourceType.UNDEFINED;
		parseState = COD;
	}


	/**
	 * Second step for parsing. The categories from the first step are further
	 * divided: COMMENT_JAVADOC to COMMENT_JAVADOC and COMMENT_KEYWORD CODE to
	 * CODE, CODE_TYPE and CODE_KEYWORD
	 */
	private void parseTwo ()
	{
		for (int index = 0; index < sourceTypes.length; ++index)
		{
			if (sourceTypes[index] == JavaSourceType.CODE)
			{
				if (isParenthesis(sourceCode.charAt(index)))
				{
					mark(index, JavaSourceType.PARENTHESIS);
				}
			}
		}

		int start = 0;
		int end = 0;

		while (end < sourceTypes.length - 1)
		{
			while (end < sourceTypes.length - 1
					&& sourceTypes[end + 1] == sourceTypes[start])
			{
				++end;
			}
			
			parseTwo(start, end);

			start = end + 1;
			end = start;
		}
	}


	/**
	 * 
	 * @param start int
	 * @param end int
	 */
	private void parseTwo (int start, int end)
	{
		if (sourceTypes[start] == JavaSourceType.JAVADOC)
		{
			parseTwoCommentBlock(start, end);
			return;
		}
		else if (sourceTypes[start] == JavaSourceType.CODE)
		{
			parseTwoCode(start, end);
			return;
		}

		// Keine weitere Unterteilung m�glich
		return;
	}


	/**
	 * Looks for primitive datatyes and keywords in the given region.
	 * 
	 * @param start int
	 * @param end int 
	 */
	private void parseTwoCode (int start, int end)
	{
		String code = sourceCode.substring(start, end + 1);

		int index = start;
		StringTokenizerProxy st = new StringTokenizerProxy(code, DELIMITERS, true);
		while (st.hasMoreTokens())
		{
			String s = st.nextToken();
			
			if (tableJavaKeywords.contains(s))
			{
				mark(index, index + s.length(), JavaSourceType.KEYWORD);
				if (s.equals("package"))
				{
					int i1 = sourceCode.indexOf(';', index + 1);
					if (i1 != -1)
					{
						source.getStatistic().setPackageName(
								sourceCode.substring(index + s.length(), i1)
										.trim());
					}
				}
			}
			else
			{
				for (int i = 0; i < PRIMITIVE_DATATYPES.length; ++i)
				{
					if (s.equals(PRIMITIVE_DATATYPES[i]))
					{
						mark(index, index + s.length(),
								JavaSourceType.CODE_TYPE);
						break;
					}
				}
			}
			index += s.length();
		}
	}


	/**
	 * Tries to find JavaDoc comment keywords and html tags @l
	 * 
	 * @param start int 
	 * @param end int
	 */
	private void parseTwoCommentBlock (int start, int end)
	{
		int i1 = indexOf('@', sourceCode, start, end);

		while (i1 != -1 && i1 + 1 < end)
		{
			int i2 = i1 + 1;

			char ch = sourceCode.charAt(i2 + 1);
			while (i2 < end
					&& ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')))
			{
				ch = sourceCode.charAt(++i2 + 1);
			}

			String s = sourceCode.substring(i1, i2 + 1);
			// s is likely to be a valid JavaDoc-Tag

			// if ((s.equals("@link") || s.equals("@linkplain"))
			// && sourceCode.charAt(i1 - 1) == '{'
			// && start > 0) {
			// mark(i1 - 1, i1 + 5, JavaSourceType.JAVADOC_LINKS);
			// }
			// else
			if (tableJavaDocKeywords.contains(s))
			{
				mark(i1, i2 + 1, JavaSourceType.JAVADOC_KEYWORD);
			}

			i1 = indexOf('@', sourceCode, i2, end);
		}

		// find html tags
		i1 = indexOf('<', sourceCode, start, end);
		while (i1 != -1 && i1 + 1 < end)
		{
			int i2 = sourceCode.indexOf('>', i1 + 1);

			// char ch=sourceCode.charAt(i2+1);
			// while(i2<end && ch!='>'){
			// ch=sourceCode.charAt(++i2+1);
			// }
			if (i2 == -1)
			{
				i1 = -1;
				break;
			}
			if (hasTypeOrEmpty(sourceTypes, i1, i2 + 1, JavaSourceType.JAVADOC))
			{
				mark(i1, i2 + 1, JavaSourceType.JAVADOC_HTML_TAG);
			}
			i1 = indexOf('<', sourceCode, i2, end);
		}
	}

	
	/**
	 * Third step for parsing: Finding number constants. CODE is further divided
	 * to CODE and NUM_CONSTANT
	 */
	private void parseThree ()
	{
		int start = 0;
		int end = 0;

		while (end < sourceTypes.length - 1)
		{
			while (end < sourceTypes.length - 1
					&& sourceTypes[end + 1] == sourceTypes[start])
			{
				++end;
			}

			if (sourceTypes[start] == JavaSourceType.CODE)
			{
				parseThree(start, end);
			}

			start = end + 1;
			end = start;
		}

		expandJavaDocLinks();
	}


	/**
	 * Looks for number constants (NUM_CONSTANT) in the selected region.
	 * 
	 * @param start int
	 * @param end int
	 */
	private void parseThree (int start, int end)
	{
		parseState = PARSESTATE_START;
		parseSourcePos = start;
		parseTypePos = start - 1;
		counter = 0;
	
		while (parseState != PARSESTATE_FINISHED)
		{
			parseThreeDo(end);
		}
	}


	/**
	 * State-machine for NUM_CONSTANTs
	 * 
	 * @param end int
	 */
	private void parseThreeDo (int end)
	{
		char ch = EOT;
	
		if (parseSourcePos <= end)
		{
			ch = sourceCode.charAt(parseSourcePos);
		}
	
		++parseSourcePos;
		++parseTypePos;
	
		switch (parseState)
		{
			case PARSESTATE_START:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch == '.')
				{
					++counter;
					parseState = PARSESTATE_DA;
					return;
				}
				if (ch == '0')
				{
					++counter;
					parseState = PARSESTATE_HIA;
					return;
				}
				if (ch >= '1' && ch <= '9')
				{
					++counter;
					parseState = PARSESTATE_NA;
					return;
				}
				if (isNumberDelimiter(ch))
				{
					// stay in this parse state
					return;
				}
				parseState = PARSESTATE_NEUTRAL;
				return;
			case PARSESTATE_NEUTRAL:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (isNumberDelimiter(ch))
				{
					parseState = PARSESTATE_START;
					return;
				}
				return;
			case PARSESTATE_DA:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					return;
				}
				if (ch >= '0' && ch <= '9')
				{
					++counter;
					parseState = PARSESTATE_NA;
					return;
				}
				if (isNumberDelimiter(ch))
				{
					parseState = PARSESTATE_START;
					counter = 0;
					return;
				}
				parseState = PARSESTATE_NEUTRAL;
				counter = 0;
				return;
			case PARSESTATE_NA:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					mark(parseTypePos - counter, parseTypePos,
							JavaSourceType.NUM_CONSTANT);
					return;
				}
				if (ch == '.' || (ch >= '0' && ch <= '9'))
				{
					++counter;
					return;
				}
				if (ch == 'e')
				{
					parseState = PARSESTATE_EXP;
					++counter;
					return;
				}
				if (ch == 'f' || ch == 'F' || ch == 'd' || ch == 'D'
						|| ch == 'l' || ch == 'L')
				{
					++counter;
					mark(parseTypePos - counter + 1, parseTypePos + 1,
							JavaSourceType.NUM_CONSTANT);
					parseState = PARSESTATE_NEUTRAL;
					counter = 0;
					return;
				}
				if (isNumberDelimiter(ch))
				{
					parseState = PARSESTATE_START;
					mark(parseTypePos - counter, parseTypePos,
							JavaSourceType.NUM_CONSTANT);
					counter = 0;
					return;
				}
				mark(parseTypePos - counter, parseTypePos,
						JavaSourceType.NUM_CONSTANT);
				parseState = PARSESTATE_NEUTRAL;
				counter = 0;
				return;
			case PARSESTATE_HIA:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					mark(parseTypePos - counter, parseTypePos,
							JavaSourceType.NUM_CONSTANT);
					return;
				}
				if (ch == 'x' || ch == 'X')
				{
					parseState = PARSESTATE_HEX;
					++counter;
					return;
				}
				if (ch == '.' || (ch >= '0' && ch <= '9'))
				{
					++counter;
					parseState = PARSESTATE_NA;
					return;
				}
				if (ch == 'f' || ch == 'F' || ch == 'd' || ch == 'D'
						|| ch == 'l' || ch == 'L')
				{
					++counter;
					mark(parseTypePos - counter + 1, parseTypePos + 1,
							JavaSourceType.NUM_CONSTANT);
					parseState = PARSESTATE_NEUTRAL;
					counter = 0;
					return;
				}
				if (isNumberDelimiter(ch))
				{
					parseState = PARSESTATE_START;
					mark(parseTypePos - counter, parseTypePos,
							JavaSourceType.NUM_CONSTANT);
					counter = 0;
					return;
				}
				mark(parseTypePos - counter, parseTypePos,
						JavaSourceType.NUM_CONSTANT);
				parseState = PARSESTATE_NEUTRAL;
				counter = 0;
				return;
			case PARSESTATE_HEX:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					mark(parseTypePos - counter, parseTypePos,
							JavaSourceType.NUM_CONSTANT);
					return;
				}
				if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f')
						|| (ch >= 'A' && ch <= 'F'))
				{
					++counter;
					parseState = PARSESTATE_HEX;
					return;
				}
				if (ch == 'l' || ch == 'L')
				{
					++counter;
					mark(parseTypePos - counter + 1, parseTypePos + 1,
							JavaSourceType.NUM_CONSTANT);
					parseState = PARSESTATE_NEUTRAL;
					counter = 0;
					return;
				}
				if (isNumberDelimiter(ch))
				{
					parseState = PARSESTATE_START;
					mark(parseTypePos - counter, parseTypePos,
							JavaSourceType.NUM_CONSTANT);
					counter = 0;
					return;
				}
				mark(parseTypePos - counter, parseTypePos,
						JavaSourceType.NUM_CONSTANT);
				parseState = PARSESTATE_NEUTRAL;
				counter = 0;
				return;
			case PARSESTATE_EXP:
				if (ch == EOT)
				{
					parseState = PARSESTATE_FINISHED;
					mark(parseTypePos - counter, parseTypePos - 1,
							JavaSourceType.NUM_CONSTANT);
					return;
				}
				if ((ch >= '0' && ch <= '9') || ch == '+' || ch == '-')
				{
					++counter;
					parseState = PARSESTATE_NA;
					return;
				}
				if (isNumberDelimiter(ch))
				{
					parseState = PARSESTATE_START;
					mark(parseTypePos - counter, parseTypePos - 1,
							JavaSourceType.NUM_CONSTANT);
					counter = 0;
					return;
				}
				mark(parseTypePos - counter, parseTypePos - 1,
						JavaSourceType.NUM_CONSTANT);
				parseState = PARSESTATE_NEUTRAL;
				counter = 0;
				return;
			default:
				break;
		}
	}


	/**
	 * 
	 */
	private void parseFour ()
	{
		boolean isInsideAnnotation = false;
		for (int i = 0; i < sourceTypes.length; ++i)
		{
			if (!isInsideAnnotation && sourceTypes[i] == JavaSourceType.CODE
					&& sourceCode.charAt(i) == '@')
			{
				isInsideAnnotation = true;
				sourceTypes[i] = JavaSourceType.ANNOTATION;
			}
			else if (isInsideAnnotation
					&& sourceTypes[i] == JavaSourceType.CODE
					&& (CharacterUtil.isJavaIdentifierPart(sourceCode.charAt(i)) || sourceCode
							.charAt(i) == '.'))
			{
				sourceTypes[i] = JavaSourceType.ANNOTATION;
			}
			else
			{
				isInsideAnnotation = false;
			}
		}
	}


//	/**
//	 * 
//	 * @param reader BufferedReader
//	 * @return String
//	 * @throws IOException e
//	 */
//	private String readPlainSource (StringReaderProxy reader) throws IOException
//	{
//		StringBuffer sb = new StringBuffer();
//		String line;
//		while ((line = reader.readLine()) != null)
//		{
//			sb.append(line);
//			sb.append("\r\n");
//		}
//		if (sb.length() > 0)
//		{
//			sb.setLength(sb.length() - 2);
//		}
//		return sb.toString();
//		// while (true){
//		// char[] buffer = new char[256];
//		// int length = reader.read(buffer, 0 , 256);
//		// if (length<=0){
//		// break;
//		// }
//		// sb.append(buffer, 0, length);
//		// }
//		// //Newlines are converted to "\r\n" for compatibility with eclipse
//		// styledtext!!!
//		// return NewLineNormalizer.normalize(sb.toString(), "\r\n");
//	}


	/**
	 * Preprocessing: Replaces all tabs (\t) by 'tabs' space characters.
	 */
	private void replaceTabs ()
	{
		char[] t = new char[options.getTabSize()];
		for (int i = 0; i < options.getTabSize(); ++i)
		{
			t[i] = ' ';
		}
	
		StringBuffer sb = new StringBuffer((int) (sourceCode.length() * 1.3));
		for (int i = 0; i < sourceCode.length(); ++i)
		{
			char ch = sourceCode.charAt(i);
			if (ch == '\t')
			{
				sb.append(t);
			}
			else
			{
				sb.append(ch);
			}
		}
	
		sourceCode = sb.toString();
	}


//	/**
//	 * 
//	 * @param line String
//	 * @param start int
//	 */
//	private void statistics (String line, int start)
//	{
//		if (line.length() > source.getStatistic().getMaxLineLength())
//		{
//			source.getStatistic().setMaxLineLength(line.length());
//		}
//	
//		int end = start + line.length();
//	
//		boolean containsCode = false;
//		boolean containsComment = false;
//	
//		for (int i = start; i < end; ++i)
//		{
//			if (sourceTypes[i] == JavaSourceType.CODE
//					|| sourceTypes[i] == JavaSourceType.KEYWORD
//					|| sourceTypes[i] == JavaSourceType.CODE_TYPE
//					|| sourceTypes[i] == JavaSourceType.CHAR_CONSTANT
//					|| sourceTypes[i] == JavaSourceType.NUM_CONSTANT)
//			{
//				containsCode = true;
//				
//				if (containsComment)
//				{
//					break;
//				}
//			}
//			else if (sourceTypes[i] == JavaSourceType.COMMENT_BLOCK
//					|| sourceTypes[i] == JavaSourceType.COMMENT_LINE
//					|| sourceTypes[i] == JavaSourceType.JAVADOC
//					|| sourceTypes[i] == JavaSourceType.JAVADOC_KEYWORD)
//			{
//				containsComment = true;
//				if (containsCode)
//				{
//					break;
//				}
//			}
//		}
//	
//		if (containsCode)
//		{
//			source.getStatistic().setCodeLineCount(
//					source.getStatistic().getCodeLineCount() + 1);
//		}
//		
//		if (containsComment)
//		{
//			source.getStatistic().setCommentLineCount(
//					source.getStatistic().getCommentLineCount() + 1);
//		}
//		
//		if (!containsCode && !containsComment)
//		{
//			source.getStatistic().setEmptyLineCount(
//					source.getStatistic().getEmptyLineCount() + 1);
//		}
//	}
}