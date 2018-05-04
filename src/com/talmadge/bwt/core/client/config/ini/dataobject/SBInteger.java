package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONValue;


/**
 * 
 */
@SuppressWarnings("serial")
public class SBInteger extends SBValue
{
	/**
	 */
	public SBInteger ()
	{
		this(null);
	}


	/**
	 * @param rawValue int
	 */
	public SBInteger (int rawValue)
	{
		this(rawValue + "");
	}


	/**
	 * @param rawValue String
	 */
	public SBInteger (String rawValue)
	{
		super(rawValue);
	}


	/**
	 * @return int
	 */
	public int intValue ()
	{
		return Integer.parseInt(this.getRawValue());
	}


	/**
     * @return JSONValue
     */
    public JSONValue toJson ()
    {
        return new JSONNumber(this.intValue());
    }
}
