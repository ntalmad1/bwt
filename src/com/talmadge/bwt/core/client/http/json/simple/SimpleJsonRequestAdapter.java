package com.talmadge.bwt.core.client.http.json.simple;

import com.talmadge.bwt.core.client.http.json.JsonRequestCallback;
import com.talmadge.bwt.core.client.http.json.JsonResponse;
import com.talmadge.bwt.core.client.json.JsonObject;


/**
 * 
 *
 */
public abstract class SimpleJsonRequestAdapter implements JsonRequestCallback<JsonObject>
{
	/**
	 * 
	 */
	@Override
	public void onAfter () {}


	/**
	 * 
	 */
	@Override
	public void onBefore () {}


	/**
	 * 
	 * @param response JsonObjectResponse
	 */
	abstract public void onSuccess (SimpleJsonResponse response);

	
	/**
	 * 
	 */
	@Override
	public void onSuccess (JsonResponse<JsonObject> response)
	{
		this.onSuccess(new SimpleJsonResponse(response));		
	}
}
