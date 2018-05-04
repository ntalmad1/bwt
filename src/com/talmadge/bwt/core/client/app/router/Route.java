package com.talmadge.bwt.core.client.app.router;

import java.util.List;

import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.endpoint.Endpoint;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.app.router.Router.MatchMethod;
import com.talmadge.bwt.core.client.app.router.handler.EndpointRouteHandler;
import com.talmadge.bwt.core.client.app.router.handler.RouteHandler;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;



/**
 * 
 * @author Noah
 *
 */
public class Route
{
	/**
	 */
	private boolean cacheEndpoint = true;

	/**
	 */
	private Endpoint endpoint;
	
	/**
	 */
	private EndpointProvider endpointProvider;

	/**
	 */
	private MatchMethod matchMethod;
	
	/**
	 */
	private String path;
	
	/**
	 */
	private String targetId;
	
	
	/**
	 */
	private RouteHandler routeHandler;
	
	
	
	/**
	 * Constructor
	 * 
	 * @param endpointProvider EndpointProvider
	 */
	public Route (EndpointProvider endpointProvider)
	{
		this.routeHandler = new EndpointRouteHandler();
		
		this.setEndpointProvider(endpointProvider);
	}


	/**
	 * Constructor
	 * 
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 */
	public Route (String path, EndpointProvider endpointProvider)
	{
		this(endpointProvider);
		this.setPath(path);
		
	}
	
	
	/**
	 * 
	 * @param routeHandler RouteHandler
	 */
	public void addRouteHandler (RouteHandler routeHandler)
	{
		if (this.routeHandler == null)
		{
			this.routeHandler = routeHandler;
		}
		else
		{
			this.routeHandler.setPrev(routeHandler);
			this.routeHandler = routeHandler;
		}
	
	}


	/**
	 * 
	 * @return Endpoint
	 */
	public Endpoint getEndpoint ()
	{
		if (!this.cacheEndpoint || (this.endpoint == null))
		{
			this.endpoint = this.getEndpointProvider().getEndpoint();
		}
		
		return this.endpoint;
	}
	
	
	/**
	 * 
	 * @return EndpointProvider
	 */
	public EndpointProvider getEndpointProvider ()
	{
		return endpointProvider;
	}
	
	
	/**
	 * 
	 * @return MatchMethod
	 */
	public MatchMethod getMatchMethod ()
	{
		return this.matchMethod;
	}


	/**
	 * 
	 * @return String
	 */
	public String getPath ()
	{
		return path;
	}

	
	/**
	 * 
	 * @return RouteHandler
	 */
	public RouteHandler getRouteHandler ()
	{
		return this.routeHandler;
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getTargetId ()
	{
		return this.targetId;
	}
	
	
	/**
	 * 
	 * @param endpointProvider EndpointProvider
	 */
	public void setEndpointProvider (EndpointProvider endpointProvider)
	{
		this.endpointProvider = endpointProvider;
	}

	
	/**
	 * 
	 * @param matchMethod MatchMethod
	 */
	public void setMatchMethod (MatchMethod matchMethod)
	{
		this.matchMethod = matchMethod;
	}


	/**
	 * 
	 * @param path String
	 */
	public void setPath (String path)
	{
		this.path = path;
	}


	/**
	 * 
	 * @param routeHandler RouteHandler
	 */
	public void setRouteHandler (RouteHandler routeHandler)
	{
		this.routeHandler = routeHandler;
	}


	/**
	 * 
	 * @param targetId String
	 */
	public void setTargetId (String targetId)
	{
		this.targetId = targetId;
	}

	
	/**
	 * 
	 * @param defaultTarget BwtWidgetContainer
	 * @param app BwtApplication
	 * @param path String
	 * @param subRoutes List<SubRouter>
	 * @throws Exception 
	 */
	public void go (BwtWidgetContainer defaultTarget, BwtApplication app, String path, List<SubRouter> subRoutes) throws Exception
	{
		this.getRouteHandler().handle(this, defaultTarget, app, path, subRoutes);
	}
}
