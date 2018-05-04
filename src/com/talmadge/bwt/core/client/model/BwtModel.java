package com.talmadge.bwt.core.client.model;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * 
 */
public abstract class BwtModel extends JavaScriptObject
{
    /**
     * Hidden Constructor
     * 
     */
    protected BwtModel ()
    {
        
    }
    

    /**
     * 
     * @param key String 
     * @return T
     * @param <T> type
     */
    protected final <T> T get (String key)
    {
        T value = this._get(key);
        return value;
    }


    /**
     * 
     * @param key String
     * @return String
     */
    protected final String getString (String key)
    {
        String value = this.get(key);
        return value;
    }
    
    
    /**
     * 
     * @param key String
     * @param value String
     */
    protected final void put (String key, String value)
    {
        this._put(key, value);
    }
    
    
    /**
     * 
     * @param key String
     * @param value String
     */
    protected final void set (String key, String value)
    {
        this._put(key, value);
    }
    

    /**
     * 
     * @param key String
     * @return String
     * @param <T> type
     */
    private native <T> T _get (String key) /*-{ 
        return this[key];
    }-*/;


    /**
     * 
     * @param key String
     * @param value String
     * @return String
     */
    private native String _put (String key, String value) /*-{
        return this[key] = value;
    }-*/;
}
