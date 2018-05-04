package com.talmadge.bwt.java2html.client.util.proxy;

/**
 * 
 * @author Noah
 *
 */
public class BufferedWriterProxy 
{
	/**
	 */
	private StringBuilder stringBuilder;
	
	
	/**
	 * Constructor
	 * 
	 */
	public BufferedWriterProxy ()
	{
		this.stringBuilder = new StringBuilder();
	}
	
	
	/**
	 * 
	 * @return StringBuilder
	 */
	public StringBuilder getStringBuilder ()
	{
		return this.stringBuilder;
	}
	
	
	/**
	 * 
	 */
	public void newLine ()
	{
		this.getStringBuilder().append("\n\r");		
	}

	
	/**
	 * 
	 * @param ch char
	 */
	public void write (char ch)
	{
		this.getStringBuilder().append(ch);
	}


	/**
	 * 
	 * @param string String
	 */
	public void write (String string)
	{
		this.getStringBuilder().append(string);
	}

}
