package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;


/**
 * 
 */
@SuppressWarnings("serial")
public class SBString extends SBValue
{
	/**
	 */
	public SBString ()
	{
		this(null);
	}


	/**
	 * @param rawValue String
	 */
	public SBString (String rawValue)
	{
		super(rawValue);
	}


	/**
	 * @return String
	 */
	public String stringValue ()
	{
		return this.toString();
	}


	/**
     * @return JSONValue
     */
    public JSONValue toJson ()
    {
        return new JSONString(this.toString());
    }


    /**
	 * @return String
	 */
	public String toString ()
	{
		return this.getRawValue();
	}
}
