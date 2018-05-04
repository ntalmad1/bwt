package com.talmadge.bwt.core.client.http.json;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestBuilder.Method;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.http.HttpStatusCode;
import com.talmadge.bwt.core.client.http.json.simple.SimpleJsonRequestCallback;
import com.talmadge.bwt.core.client.json.JsonObject;

/**
 * 
 *
 */
public class JsonRequest
{
    /**
     */
    private RequestBuilder requestBuilder;
    
    /**
     */
    private JsonObject parameters;



    /**
     * Constructor
     * 
     * @param url String
     */
    public JsonRequest (String url)
    {
        this(RequestBuilder.GET, url);
    }

    
    
    /**
     * 
     * @param method Method
     * @param url String
     */
    public JsonRequest (Method method, String url)
    {
    	this.parameters = JsonObject.create();
        this.requestBuilder = new RequestBuilder(method, url);
    }



	/**
     * 
     * @param key String
     * @param value String
     */
    public void put (String key, String value)
	{
		this.parameters.add(key, value);		
	}


    /**
     * 
     * @param data  JSONObject
     */
	public void setData (JSONObject data)
	{
		this.parameters = JsonObject.create(data);		
	}



	/**
     * 
     * @param jsonRequestCallback JsonRequestCallback<T>
     * @param <T> extends JavaScriptObject
     */
    public <T extends JavaScriptObject> void send (final JsonRequestCallback<T> jsonRequestCallback)
    {
        this.getRequestBuilder().setCallback(new RequestCallback()
        {
            @SuppressWarnings("unchecked")
            @Override
            public void onResponseReceived (Request request, Response response)
            {
            	String rawText = null;
            	
                try
                {
                    rawText = response.getText();
                	JSONValue json = JSONParser.parseLenient(rawText);
                   
                    
                    JsonResponse<T> jsonResponse = new JsonResponse<T>();
                    jsonResponse.setRawText(rawText);
                    if (json.isObject() != null)
                    {
                    	if (jsonRequestCallback instanceof SimpleJsonRequestCallback)
                    	{
                    		jsonResponse.set((T) JsonObject.create(json.isObject())); 
                    	}
                    	else
                    	{
                    		jsonResponse.set((T) (json.isObject().getJavaScriptObject()));
                    	}
                    }
                    else if (json.isArray() != null)
                    {
                        jsonResponse.set((T) (json.isArray().getJavaScriptObject()));
                    }
                    else
                    {
                        jsonResponse.set(null);
                    }
                    
                    if (response.getStatusCode() != HttpStatusCode._200_SUCCESS_OK.getInt()
                     && response.getStatusCode() != HttpStatusCode._201_SUCCESS_CREATED.getInt()
                     && response.getStatusCode() != HttpStatusCode._204_SUCCESS_NO_CONTENT.getInt())
                    {
                    	jsonRequestCallback.onFailure(JsonRequest.this, new JsonRequestException("Server returned status other than SUCCESS.", request, response, rawText));
                    	jsonRequestCallback.onAfter();
                    }
                    else
                    {
                    	jsonRequestCallback.onSuccess(jsonResponse);
                    	jsonRequestCallback.onAfter();
                    }
                }
                catch (Exception e)
                {
                	JsonRequestException exception = new JsonRequestException(request, response, e, rawText);
                    jsonRequestCallback.onFailure(JsonRequest.this, exception);
                    jsonRequestCallback.onAfter();
                }
            }

            @Override
            public void onError (Request request, Throwable exception)
            {
                Window.alert("Error occurred" + exception.getMessage());
                jsonRequestCallback.onAfter();
            }
        });

        try
        {
        	jsonRequestCallback.onBefore();
        	
        	this.getRequestBuilder().setRequestData(this.parameters.toJson());
            this.getRequestBuilder().send();
        }
        catch (RequestException e)
        {
            jsonRequestCallback.onFailure(this, new JsonRequestException(e));
        }
    }

    
    /**
     * 
     * @return RequestBuilder
     */
    protected RequestBuilder getRequestBuilder ()
    {
        return this.requestBuilder;
    }
}
