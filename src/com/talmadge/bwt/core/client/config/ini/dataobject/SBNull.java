package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONValue;


/**
 * 
 */
@SuppressWarnings("serial")
public class SBNull extends SBValue
{
	/**
	 */
	public SBNull ()
	{
		this(null);
	}


	/**
     * @return JSONValue
     */
    public JSONValue toJson ()
    {
        return JSONNull.getInstance();
    }


	/**
	 * @param rawValue String
	 */
	public SBNull (String rawValue)
	{
		super(rawValue);
	}
}
