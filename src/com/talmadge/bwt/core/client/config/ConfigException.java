package com.talmadge.bwt.core.client.config;

/**
 * @author Noah Talmadge
 */
@SuppressWarnings("serial")
public class ConfigException extends Exception
{
	/**
	 */
	public static final String MISSING_EQUALS = "missing equals";



	/**
	 * @param message String
	 */
	public ConfigException (String message)
	{
		super(message);
	}


	/**
	 * @param message String
	 * @param type String
	 */
	public ConfigException (String message, String type)
	{
		this("[" + type + "] - " + message);
	}
}
