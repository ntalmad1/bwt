package com.talmadge.bwt.java2html.client.util;

/**
 * @author Markus Gebhard
 */
@SuppressWarnings("serial")
public class IllegalConfigurationException extends RuntimeException
{
	/**
	 * Constructor
	 * 
	 * @param message String
	 */
	public IllegalConfigurationException (String message)
	{
		super(message);
	}

	
	/**
	 * Constructor
	 * 
	 * @param message String
	 * @param cause Throwable
	 */
	public IllegalConfigurationException (String message, Throwable cause)
	{
		super(message, cause);
	}
}