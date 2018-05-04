package com.talmadge.bwt.core.client.http.json;

import com.google.gwt.http.client.RequestBuilder;

/**
 * 
 *
 */
public class JsonPostRequest extends JsonRequest
{
    /**
     * Constructor
     * 
     * @param url String
     */
    public JsonPostRequest (String url)
    {
        super(RequestBuilder.POST, url);
    }
}
