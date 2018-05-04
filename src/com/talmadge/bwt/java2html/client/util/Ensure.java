package com.talmadge.bwt.java2html.client.util;

/**
 * Provides convenient methods for checking contract parameters.
 */
public final class Ensure
{
	/**
	 * 
	 * @param message String
	 * @param object Object
	 * @throws IllegalArgumentException e
	 */
	public static void ensureArgumentNotNull (String message, Object object)
			throws IllegalArgumentException
	{
		ensureTrue(message, object != null);
	}

	
	/**
	 *  
	 * @param object Object
	 * @throws IllegalArgumentException e
	 */
	public static void ensureArgumentNotNull (Object object)
			throws IllegalArgumentException
	{
		ensureArgumentNotNull("Object must not be null", object); //$NON-NLS-1$
	}

	
	/**
	 * 
	 * @param state boolean
	 * @throws IllegalArgumentException e
	 */ 
	public static void ensureArgumentFalse (boolean state)
			throws IllegalArgumentException
	{
		ensureTrue("boolean must be false", !state); //$NON-NLS-1$
	}

	
	/**
	 * 
	 * @param message String
	 * @param state boolean
	 * @throws IllegalArgumentException e
	 */
	public static void ensureArgumentFalse (String message, boolean state)
			throws IllegalArgumentException
	{
		ensureTrue(message, !state);
	}

	
	/**
	 *  
	 * @param state boolean
	 * @throws IllegalArgumentException e
	 */
	public static void ensureArgumentTrue (boolean state)
			throws IllegalArgumentException
	{
		ensureTrue("boolean must be true", state); //$NON-NLS-1$
	}

	
	/**
	 * 
	 * @param message String
	 * @param state boolean
	 * @throws IllegalArgumentException w
	 */
	public static void ensureTrue (String message, boolean state)
			throws IllegalArgumentException
	{
		if (!state)
		{
			throw new IllegalArgumentException(message);
		}
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 */
	private Ensure ()
	{
		
	}
}