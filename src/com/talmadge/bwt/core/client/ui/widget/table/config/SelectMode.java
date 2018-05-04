package com.talmadge.bwt.core.client.ui.widget.table.config;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/**
 * 
 *
 */
public enum SelectMode
{
    /**
     */
    MULTI(new JSONString("multi")),
    
    /**
     */
    NONE(JSONBoolean.getInstance(false)),
    
    /**
     */
    OS(new JSONString("os")),
    
    /**
     */
    SINGLE(new JSONString("single"));
    
    //-------------------------------------------------
    
    /**
     */
    private JSONValue value;
    
    
    /**
     * Hidden Constructor
     *  
     * @param value JSONValue
     */
    SelectMode (JSONValue value)
    {
        this.value = value;
    }
    
    
    /**
     * 
     * @return JSONValue
     */
    public JSONValue getValue ()
    {
        return this.value;
    }
}
