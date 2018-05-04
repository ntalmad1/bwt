package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONValue;


/**
 * 
 */
@SuppressWarnings("serial")
public class SBBoolean extends SBValue
{
	/**
	 */
	public SBBoolean ()
	{
		this(null);
	}


	/**
	 * @param rawValue String
	 */
	public SBBoolean (String rawValue)
	{
		super(rawValue);
	}


	/**
	 *
	 * @param rawValue boolean
	 */
	public SBBoolean (boolean rawValue)
	{
	    this(rawValue + "");
    }


    /**
	 * @return boolean
	 */
    public boolean booleanValue ()
    {
        return Boolean.parseBoolean(this.getRawValue());
    }


    /**
     * @return JSONValue
     */
    public JSONValue toJson ()
    {
        return JSONBoolean.getInstance(this.booleanValue());
    }
}
