package com.talmadge.bwt.core.client.app.router;

/**
 * 
 *
 */
public class SubRouter extends Router 
{
	/**
	 * 
	 * @param baseUrl String
	 */
	public SubRouter (String baseUrl) 
	{
		super(baseUrl);
	}

	
	/**
	 * 
	 * @throws RouterException
	 */
	protected void onDefaultEndpointNotSet () throws RouterException
	{
		// do nothing		
	}
}
