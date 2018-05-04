package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONArray;



/**
 * 
 */
@SuppressWarnings("serial")
public class SBValue extends SBDataObject
{
	/**
	 */
	private String rawValue;



	/**
	 * @param rawValue String
	 */
	public SBValue (String rawValue)
	{
		this.rawValue = rawValue;
	}


	/**
	 * @return String
	 */
	public String getRawValue ()
	{
		return this.rawValue;
	}


	/**
     * @param rawValue boolean
     * @return SBValue
     */
	public static SBValue newINIValue (boolean rawValue)
	{
        return new SBBoolean(rawValue);
    }


	/**
     * @param rawValue double
     * @return SBValue
     */
    public static SBValue newINIValue (double rawValue)
    {
        return new SBDouble(rawValue);
    }


    /**
	 * @param rawValue int
	 * @return SBValue
	 */
	public static SBValue newINIValue (int rawValue)
	{
		return new SBInteger(rawValue);
	}


	/**
	 *
	 * @param array JSONArray
	 * @return SBValue
	 */
	public static SBValue newINIValue (JSONArray array)
	{
	    return new SBJSONArray(array);
	}


	/**
	 * @param rawValue String
	 * @return SBValue
	 */
	public static SBValue newINIValue (String rawValue)
	{
		SBValue value = null;

		if (SBValue.isNULL(rawValue))
		{
			value = new SBNull();
		}
		else if (SBValue.isInteger(rawValue))
		{
			value = new SBInteger(rawValue);
		}
		else if (SBValue.isDouble(rawValue))
		{
			value = new SBDouble(rawValue);
		}
		else if (SBValue.isBoolean(rawValue))
		{
		    value = new SBBoolean(rawValue);
		}
		else
		{
			value = new SBString(rawValue);
		}

		return value;
	}


	/**
	 *
	 * @param value String
	 * @return boolean
	 */
	public static boolean isBoolean (String value)
	{
	    return (value.trim().toLowerCase().equals("true")
           ||   value.trim().toLowerCase().equals("false"));
    }


    /**
	 * @param value String
	 * @return boolean
	 */
	public static boolean isDouble (String value)
	{
		return value.matches("^(-?)((0)|([123456789][0-9]+)).([0-9]+)$");
	}


	/**
	 * @param value String
	 * @return boolean
	 */
	public static boolean isInteger (String value)
	{
		return value.matches("^(-?)([123456789])([0-9]+)$");
	}


	/**
	 * @param value String
	 * @return boolean
	 */
	public static boolean isNULL (String value)
	{
		return  ((value == null) || (value.trim().length() == 0));
	}
}
