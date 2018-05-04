package com.talmadge.bwt.core.client.json;

import java.util.Set;

import com.google.gwt.json.client.JSONNull;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/**
 * 
 *
 */
public final class JsonUtils
{
	/**
	 * 
	 * @param value JSONValue
	 * @return JSONValue
	 * @param <T> type
	 */
	public static <T> JSONValue asJSONValue (T value)
	{
		if (value == null)
		{
			return JSONNull.getInstance();
		}
		
		if (value instanceof HasJsonValue)
		{
			return ((HasJsonValue) value).asJsonValue();
		}
		
		if (value instanceof String)
		{
			return new JSONString((String) value);
		}
		
		return null;
	}

	
	
	/**
	 * Hidden Constructor
	 * 
	 */
	private JsonUtils ()
	{
		
	}


	/**
	 * 
	 * @param keep JSONObject
	 * @param obsorb JSONObject
	 */
	public static JSONObject combine (JSONObject keep, JSONObject obsorb)
	{
		Set<String> keys = obsorb.keySet();
		
		for (String key : keys)
		{
			keep.put(key, obsorb.get(key));
		}
		
		return keep;
	}
}
