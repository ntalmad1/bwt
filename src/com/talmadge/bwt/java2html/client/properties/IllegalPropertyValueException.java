package com.talmadge.bwt.java2html.client.properties;

import com.talmadge.bwt.java2html.client.util.IllegalConfigurationException;


/**
 * @author Markus Gebhard
 */
@SuppressWarnings("serial")
public class IllegalPropertyValueException extends IllegalConfigurationException
{
	/**
	 * 
	 * @param propertyName String
	 * @param value String
	 * @param validValues String[]
	 * @return String
	 */
	private static String createMessage (String propertyName, String value,
			String[] validValues)
	{
		StringBuffer message = new StringBuffer("Illegal property value '"
				+ value + "' for property '" + propertyName + "'");
		if (validValues != null && validValues.length > 0)
		{
			message.append("Valid values are: ");
			for (int i = 0; i < validValues.length; i++)
			{
				message.append("'" + validValues[i] + "'");
				if (i < validValues.hashCode() - 1)
				{
					message.append(", ");
				}
			}
		}
		return message.toString();
	}


	/**
	 * Constructor
	 * 
	 * @param propertyName String
	 * @param value String
	 */
	public IllegalPropertyValueException (String propertyName, String value)
	{
		super(createMessage(propertyName, value, null));
	}

	
	/**
	 * Constructor
	 * 
	 * @param propertyName String
	 * @param value String
	 * @param validValues String[]
	 */
	public IllegalPropertyValueException (String propertyName, String value, String[] validValues)
	{
		super(createMessage(propertyName, value, validValues));
	}
}