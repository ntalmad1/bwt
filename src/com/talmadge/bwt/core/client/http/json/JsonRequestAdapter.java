package com.talmadge.bwt.core.client.http.json;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public abstract class JsonRequestAdapter<T extends JavaScriptObject> implements JsonRequestCallback<T> 
{
	
	/**
	 * 
	 */
	@Override
	public void onBefore() 
	{
		
	}

	
	/**
	 * 
	 */
	@Override
	public void onFailure(JsonRequest request, JsonRequestException e) 
	{
		
	}

	
	/**
	 * 
	 */
	@Override
	public void onSuccess(JsonResponse<T> response) 
	{
		
	}

	
	/**
	 * 
	 */
	@Override
	public void onAfter() 
	{
		
	}
}
