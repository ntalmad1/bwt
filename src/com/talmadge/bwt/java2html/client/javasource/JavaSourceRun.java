package com.talmadge.bwt.java2html.client.javasource;

import com.google.gwt.core.client.GWT;

/**
 * A connected piece of Java source code having the same type (
 * {@link de.java2html.javasource.JavaSourceType}). JavaSourceRun objects are
 * created by {@link de.java2html.javasource.JavaSourceIterator} provided from a
 * {@link de.java2html.javasource.JavaSource} object.
 */
public class JavaSourceRun
{
	/**
	 */
	private final int endIndex;


	/**
	 */
	private final JavaSource javaSource;

	
	/**
	 */
	private final int startIndex;
	
	
	/**
	 * Constructor
	 * 
	 * @param javaSource JavaSource
	 * @param startIndex int
	 * @param endIndex int
	 */
	public JavaSourceRun (JavaSource javaSource, int startIndex, int endIndex)
	{
		this.javaSource = javaSource;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	
	/**
	 * 
	 */
	public void dump ()
	{
		GWT.log(isAtStartOfLine() ? "[" : "(");
		GWT.log(startIndex + ".." + endIndex);
		GWT.log(isAtEndOfLine() ? "]" : ")");
		GWT.log(" '" + getCode() + "'");
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getCode ()
	{
		return javaSource.getCode().substring(startIndex, endIndex);
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getEndIndex ()
	{
		return endIndex;
	}

	
	/**
	 * 
	 * @return JavaSource
	 */
	public JavaSource getJavaSource ()
	{
		return javaSource;
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getStartIndex ()
	{
		return startIndex;
	}

	
	/**
	 * 
	 * @return JavaSourceType
	 */
	public JavaSourceType getType ()
	{
		return javaSource.getClassification()[startIndex];
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isAtEndOfLine ()
	{
		return endIndex == javaSource.getCode().length()
				|| javaSource.getCode().charAt(endIndex) == '\r';
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isAtStartOfLine ()
	{
		return (startIndex == 0 || javaSource.getCode().charAt(startIndex - 1) == '\n');
	}
}