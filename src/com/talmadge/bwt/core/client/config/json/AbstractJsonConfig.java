package com.talmadge.bwt.core.client.config.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/**
 * 
 *
 */
public abstract class AbstractJsonConfig
{
    /**
     */
    private JSONObject json;
    
    
    
    /**
     * Constructor
     * 
     */
    public AbstractJsonConfig ()
    {
        this.json = new JSONObject();
    }
    
    
    /**
     * 
     * @return JavaScriptObject
     */
    public JavaScriptObject getJavaScriptObject ()
    {
        return this.getJson().getJavaScriptObject();
    }


    /**
     * 
     * @return JSONObject
     */
    public JSONObject getJson ()
    {
        return this.json;
    }
    
    
    /**
     * 
     * @param key String
     * @param jsonArray JSONArray 
     */
    protected  void put (String key, JSONArray jsonArray)
    {
        this.getJson().put(key, jsonArray);
    }
    
    
    
    /**
     * 
     * @param key String
     * @param value String 
     */
    protected  void put (String key, String value)
    {
        this.getJson().put(key, new JSONString(value));
    }
    
    
    /**
     * 
     * @param key String
     * @param value JSONValue 
     */
    protected  void put (String key, JSONValue value)
    {
        this.getJson().put(key, value);
    }
}

