package com.talmadge.bwt.core.client.http.json;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 * @param <T> extends JavaScriptObject
 */
public interface JsonRequestCallback<T extends JavaScriptObject>
{
	/**
	 * 
	 */
	void onBefore ();
	
    /**
     * 
     * @param request JsonRequest
     * @param e Throwable
     */
    void onFailure (JsonRequest request, JsonRequestException e);
    
    /**
     * 
     * @param response JsonResponse<T>
     */
    void onSuccess (JsonResponse<T> response);
    
    /**
     * 
     */
    void onAfter ();
}
