package com.talmadge.bwt.core.client.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

/**
 * @author Noah
 *
 */
public class JsonObject extends JavaScriptObject
{	
	/**
	 * 
	 * @return JsonObject
	 */
    public static JsonObject create ()
	{
    	JsonObject jsonObject = (JsonObject) JavaScriptObject.createObject(); 
    	jsonObject.setJSONObject(new JSONObject());
    	
    	return jsonObject;
	}

    
    /**
     * 
     * @param object JSONObject
     * @return JsonObject
     */
    public static JsonObject create (JSONObject object)
	{
    	JsonObject jsonObject = (JsonObject) JavaScriptObject.createObject(); 
    	jsonObject.setJSONObject(object);
    	
		return jsonObject;
	}


	/**
     * Constructor
     *
     */
    protected JsonObject ()
    {
    	
    }
    

	/**
     *
     * @param key String
     * @param value String
     */
    public final void add (String key, String value)
    {
        this.getJSONObject().put(key, new JSONString(value));
    }

    
    /**
     * 
     * @param key String
     * @param value int
     */
    public final void add (String key, int value)
    {
        this.getJSONObject().put(key, new JSONNumber(value));        
    }


    /**
     * @return JavaScriptObject
     */
    public final JavaScriptObject getJavaScriptObject ()
    {
        return this.getJSONObject().getJavaScriptObject();
    }

    
    /**
     * 
     * @param key String
     * @return boolean
     */
    public final boolean getBoolean (String key)
	{
    	return this.getJSONObject().get(key).isBoolean().booleanValue();
	}


	/**
     * 
     * @return String
     */
    public final String toJson ()
    {
    	return this.getJSONObject().toString();
    }
    

    /**
     *
     * @return JSONObject
     */
    protected native final JSONObject getJSONObject () /*-{
    	return this.jsonObject;        
    }-*/;


    /**
     *
     * @param jsonObject JSONObject
     */
    protected native final void setJSONObject (JSONObject jsonObject) /*-{
    	this.jsonObject = jsonObject;
    }-*/;
}

