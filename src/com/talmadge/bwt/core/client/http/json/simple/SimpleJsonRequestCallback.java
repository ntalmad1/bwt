package com.talmadge.bwt.core.client.http.json.simple;

import com.talmadge.bwt.core.client.http.json.JsonRequestCallback;
import com.talmadge.bwt.core.client.http.json.JsonResponse;
import com.talmadge.bwt.core.client.json.JsonObject;


/**
 * 
 *
 */
public abstract class SimpleJsonRequestCallback implements JsonRequestCallback<JsonObject>
{
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
