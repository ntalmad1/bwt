package com.talmadge.bwt.core.client.http.json;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.Response;

/**
 * 
 *
 */
@SuppressWarnings("serial")
public class JsonRequestException extends Exception
{
	/**
	 */
	private Request request;

	/**
	 */
	private Response response;

	
	/**
	 */
	private String rawResponseText;
	
	
	/**
	 * Constrcutor
	 * 
	 * @param e Exception
	 */
	public JsonRequestException (Exception e)
	{
		super(e);
	}


	/**
	 * Constrcutor
	 * 
	 * @param request Request
	 * @param response Response
	 * @param e Exception
	 */
	public JsonRequestException (Request request, Response response, Exception e)
	{
		this(e);
		
		this.request = request;
		this.response = response;
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param request Request
	 * @param e Exception
	 * @param rawResponseText String
	 */
	public JsonRequestException (String message, Request request, Response response, String rawResponseText)
	{
		super(message);
		
		this.request = request;
		this.response = response;
		this.rawResponseText = rawResponseText;
	}


	/**
	 * Constructor
	 * 
	 * @param request Request
	 * @param e Exception
	 * @param rawResponseText String
	 */
	public JsonRequestException (Request request, Response response, Exception e, String rawResponseText)
	{
		this(request, response, e);
		
		this.rawResponseText = rawResponseText;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getRawResponseText ()
	{
		return this.rawResponseText;
	}


	public Request getRequest ()
	{
		return request;
	}


	public Response getResponse ()
	{
		return response;
	}

}
