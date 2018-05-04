package com.talmadge.bwt.core.client.app.router;

/**
 * 
 *
 */
@SuppressWarnings("serial")
public class RouterException extends Exception
{
	/**
	 * 
	 * @param e Exception
	 */
	public RouterException (Exception e)
	{
		super(e);
	}

	
	/**
	 * 
	 * @param message String
	 */
	public RouterException (String message)
	{
		super(message);
	}
}
