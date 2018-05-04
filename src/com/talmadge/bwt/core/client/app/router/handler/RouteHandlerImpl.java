package com.talmadge.bwt.core.client.app.router.handler;

/**
 * 
 *
 */
public abstract class RouteHandlerImpl implements RouteHandler
{
	/**
	 */
	private RouteHandler prevRouteHandler;
	
	/**
	 */
	private RouteHandler nextRouteHandler;
	
	
	/**
	 * @param routeHandler RouteHandler
	 */
	public void setNext (RouteHandler routeHandler)
	{
		if (this.nextRouteHandler != null)
		{
			this.nextRouteHandler.setPrev(routeHandler);
			routeHandler.setNext(this.nextRouteHandler);
			routeHandler.setPrev(this);
		}
		
		this.nextRouteHandler = routeHandler;
	}

	
	/**
	 * @param routeHandler RouteHandler
	 */
	public void setPrev (RouteHandler routeHandler)
	{
		if (this.prevRouteHandler != null)
		{
			this.prevRouteHandler.setNext(routeHandler);
			routeHandler.setPrev(this.prevRouteHandler);
			routeHandler.setNext(this);
		}
		
		this.prevRouteHandler = routeHandler;
	}
}
