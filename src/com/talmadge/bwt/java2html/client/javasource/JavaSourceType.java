package com.talmadge.bwt.java2html.client.javasource;

import java.util.ArrayList;
import java.util.List;

/**
 * Different types of source code for classifying characters in the raw text.
 * 
 * @author Markus Gebhard
 */
public final class JavaSourceType
{
	/**
	 */
	private static final List<JavaSourceType> ALL = new ArrayList<JavaSourceType>();

	/**
	 */
	private static int idCounter = 0;

	/**
	 */
	public static final JavaSourceType BACKGROUND = new JavaSourceType(
			"Background", false);

	/**
	 */
	// Not really a Javasource type, but useful for conversion output options
	private static JavaSourceType LINE_NUMBERS = new JavaSourceType(
			"Line numbers", true);
	
	/**
	 * 
	 * @return JavaSourceType
	 */
	public static JavaSourceType getLineNumbers ()
	{
		return JavaSourceType.LINE_NUMBERS;
	}

	/**
	 */
	public static final JavaSourceType COMMENT_BLOCK = new JavaSourceType(
			"Multi-line comments", true); // green

	/**
	 */
	public static final JavaSourceType COMMENT_LINE = new JavaSourceType(
			"Single-line comments", true); // green

	/**
	 */
	public static final JavaSourceType KEYWORD = new JavaSourceType("Keywords",
			true);

	/**
	 */
	public static final JavaSourceType STRING = new JavaSourceType("Strings",
			true); // darker red

	/**
	 */
	public static final JavaSourceType CHAR_CONSTANT = new JavaSourceType(
			"Character constants", true); // dark red

	/**
	 */
	public static final JavaSourceType NUM_CONSTANT = new JavaSourceType(
			"Numeric constants", true); // dark red

	/**
	 */
	public static final JavaSourceType PARENTHESIS = new JavaSourceType(
			"Parenthesis", true);

	/**
	 */
	public static final JavaSourceType CODE_TYPE = new JavaSourceType(
			"Primitive Types", true);

	/**
	 */
	public static final JavaSourceType CODE = new JavaSourceType("Others", true);

	/**
	 */
	public static final JavaSourceType JAVADOC_KEYWORD = new JavaSourceType(
			"Javadoc keywords", true); // dark green

	/**
	 */
	public static final JavaSourceType JAVADOC_HTML_TAG = new JavaSourceType(
			"Javadoc HTML tags", true);

	/**
	 */
	public static final JavaSourceType JAVADOC_LINKS = new JavaSourceType(
			"Javadoc links", true);

	/**
	 */
	public static final JavaSourceType JAVADOC = new JavaSourceType(
			"Javadoc others", true); // green

	/**
	 */
	public static final JavaSourceType UNDEFINED = new JavaSourceType(
			"Undefined", false);

	/**
	 */
	public static final JavaSourceType ANNOTATION = new JavaSourceType(
			"Annotation", true);

	
	/**
	 * 
	 * @return JavaSourceType[]
	 */
	public static JavaSourceType[] getAll ()
	{
		return (JavaSourceType[]) ALL.toArray(new JavaSourceType[ALL.size()]);
	}
	
	
	/**
	 */
	private String name;
	
	/**
	 */
	private int id;
	
	/**
	 */
	private boolean displayRelevant;


	/**
	 * @param name The name of the type
	 * @param displayRelevant false if this type does not really matter for
	 *            display (e.g. because type means empty or illegal code).
	 */
	private JavaSourceType (String name, boolean displayRelevant)
	{
		this.id = idCounter++;
		this.name = name;
		this.displayRelevant = displayRelevant;
		ALL.add(this);
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getName ()
	{
		return toString();
	}

	/**
	 * 
	 * @return int
	 */
	public int getID ()
	{
		return id;
	}


	/**
     * 
     * @return String
     */
	public String toString ()
	{
		return name;
	}


	/**
	 * 
	 * @return boolean
	 */
	public boolean isDisplayRelevant ()
	{
		return displayRelevant;
	}
}