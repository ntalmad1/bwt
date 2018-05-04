package com.talmadge.bwt.core.client.http.json.simple;

import com.talmadge.bwt.core.client.http.json.JsonResponse;
import com.talmadge.bwt.core.client.json.JsonObject;

/**
 * 
 *
 */
public class SimpleJsonResponse extends JsonResponse<JsonObject>
{
	/**
	 * 
	 * @param response JsonResponse<JsonObject>
	 */
	public SimpleJsonResponse (JsonResponse<JsonObject> response)
	{
		this.setRawText(response.getRawText());
		this.set(response.get());
	}
	
	
	/**
	 * 
	 * @return JsonObject
	 */
	public JsonObject json ()
	{
		return super.get();
	}
}
