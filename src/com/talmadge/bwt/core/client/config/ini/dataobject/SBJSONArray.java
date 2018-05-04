package com.talmadge.bwt.core.client.config.ini.dataobject;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONValue;


/**
 * 
 */
@SuppressWarnings("serial")
public class SBJSONArray extends SBValue
{
    /**
     */
    private JSONArray array;



	/**
	 * Constructor
	 *
	 * @param array JSONArray
	 */
	public SBJSONArray (JSONArray array)
	{
        super(array.toString());

        this.setArray(array);
	}


	/**
	 *
	 * @return JSONArray
	 */
    public JSONArray getArray ()
    {
        return this.array;
    }


    /**
     *
     * @param array JSONArray
     */
    public void setArray (JSONArray array)
    {
        this.array = array;
    }


    /**
     * @return JSONValue
     */
    public JSONValue toJson ()
    {
        return this.array;
    }
}
