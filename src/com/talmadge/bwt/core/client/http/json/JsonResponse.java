package com.talmadge.bwt.core.client.http.json;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 *
 * @param <T> type 
 */
public class JsonResponse<T extends JavaScriptObject>
{
	/**
	 */
	private String rawText;
	
    /**
     */
    private T response;
 
    
    
    /**
     * Constructor
     * 
     */
    public JsonResponse ()
    {
        
    }
    
    
    /**
     * 
     * @return T
     */
    public T get ()
    {
        return this.response;
    }
    
    
    /**
     * 
     * @return String
     */
    public String getRawText () 
    {
    	return this.rawText;
    }


    /**
     * 
     * @param js T
     */
    public void set (T js)
    {
        this.response = js;
    }

    
    /**
     * 
     * @param rawText String
     */
	public void setRawText (String rawText) 
	{
		this.rawText = rawText;
	}
}
