package com.talmadge.bwt.core.client.app;

/**
 * 
 * @author Noah
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception
{
	/**
	 * 
	 * @param e Exception
	 */
	public ApplicationException (Exception e)
	{
		super(e);
	}
	
	/**
	 * 
	 * @param message String
	 */
	public ApplicationException (String message)
	{
		super(message);
	}
}
