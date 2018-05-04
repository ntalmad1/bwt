package com.talmadge.bwt.core.client.config.javascriptobject;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

/**
 * 
 *
 */
public abstract class AbstractJavaScriptObjectConfig implements JavaScriptObjectConfig
{
    /**
     */
    private JavaScriptObject overlay;
    
    
    
    /**
     * Constructor
     * 
     * @param overlay JavaScriptObject
     */
    public AbstractJavaScriptObjectConfig (JavaScriptObject overlay)
    {
        this.overlay = overlay;
    }
    
    
    /**
     * 
     * @return JSONObject
     */
    public JSONObject asJson ()
    {
        return new JSONObject(this.getOverlay());
    }
    
    
    /**
     * 
     * @return JavaScriptObject
     */
    public JavaScriptObject getJavaScriptObject ()
    {
        return this.overlay;
    }
    
    
    /**
     * 
     * @return JavaScriptObject
     */
    public JavaScriptObject getOverlay ()
    {
        return this.overlay;
    }
    
    
    /**
     * 
     * @param key String 
     * @param value boolean
     */
    public void put (String key, boolean value)
    {
    	this._put(this.overlay, key, value);
    }
    
    
    /**
     * 
     * @param key String 
     * @param value int
     */
    public void put (String key, int value)
    {
    	this._put(this.overlay, key, value);
    }
    
    
    /**
     * 
     * @param key String
     * @param javaScriptObject JavaScriptObject
     */
    public void put (String key, JavaScriptObject javaScriptObject)
    {
        this._put(this.overlay, key, javaScriptObject);
    }
    
    
    /**
     * 
     * @param key String
     * @param javaScriptObjectParameter JavaScriptObjectParameter
     */
	public void put (String key, JavaScriptObjectParameter javaScriptObjectParameter)
	{
		this.put(key, javaScriptObjectParameter.getValue());
	}



    /**
     * 
     * @param key String
     * @param jsonArray JSONArray 
     */
    public  void put (String key, JSONArray jsonArray)
    {
        this._put(this.overlay, key, jsonArray.getJavaScriptObject());
    }
    
    
    
    /**
     * 
     * @param key String
     * @param value String 
     */
    public  void put (String key, String value)
    {
        this._put(this.overlay, key, value);
    }
    
    
    /**
     * 
     * @param key String
     * @param value JSONValue 
     */
    public  void put (String key, JSONValue value)
    {
    	if (value.isString() != null)
    	{
    		this._put(this.overlay, key, value.isString().stringValue());
    	}
    	else if (value.isBoolean() != null)
    	{
    		this._put(this.overlay, key, value.isBoolean().booleanValue());
    	}
    	else
    	{
    		this._put(this.overlay, key, value.toString());
    	}
    }

    
    /**
     * 
     * @return String
     */
    public String toString ()
    {
    	return this.asJson().toString();
    }
    
    
    /**
     * 
     * @param overlay JavaScriptObject
     * @param key String
     * @param jsObject JavaScriptObject
     */
    protected native void _put (JavaScriptObject overlay, String key, JavaScriptObject jsObject) /*-{
        
        overlay[key] = jsObject;
        
    }-*/;
    
    
    /**
     * 
     * @param overlay JavaScriptObject
     * @param key String
     * @param value String
     */
    protected native void _put (JavaScriptObject overlay, String key, String value) /*-{
        
        overlay[key] = value;
        
    }-*/;
    
    
    /**
     * 
     * @param overlay JavaScriptObject
     * @param key String
     * @param value String
     */
    protected native void _put (JavaScriptObject overlay, String key, boolean value) /*-{
        
        overlay[key] = value;
        
    }-*/;
    
    
    /**
     * 
     * @param overlay JavaScriptObject
     * @param key String
     * @param value int
     */
    protected native void _put (JavaScriptObject overlay, String key, int value) /*-{
        
        overlay[key] = value;
        
    }-*/;
}

