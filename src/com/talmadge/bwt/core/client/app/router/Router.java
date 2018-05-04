package com.talmadge.bwt.core.client.app.router;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.endpoint.Endpoint;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.ui.Bwt;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;


/**
 * 
 * @author Noah
 *
 */
public class Router
{
	/**
	 */
	public enum MatchMethod
	{
		/**
		 */
		BEGINS_WITH,
		
		/**
		 */
		ENDS_WITH,
		
		/**
		 */
		EQUALS;
	}
	
	
	/**
	 */
	private String baseUrl;
	
	/**
	 */
	private MatchMethod defaultMatchMethod = MatchMethod.EQUALS;
	
	/**
	 */
	private Route defaultRoute;
	
	/**
	 */
	private List<Route> routes;
	
	/**
	 */
	private List<SubRouter> subRouters;
	
	
	/**
	 */
	private BwtWidgetContainer target;
	
	
	/**
	 * Constructor
	 * 
	 */
	public Router ()
	{
		this.subRouters = new ArrayList<SubRouter>();
		this.routes = new ArrayList<Route>();
	}
	
	
	/**
	 * 
	 * @param baseUrl
	 */
	public Router (String baseUrl)
	{
		this();
		
		
		
		this.setBaseUrl(baseUrl);
	}


	/**
	 * 
	 * @param route Route
	 * @return Route
	 */
	public Route add (Route route)
	{
		this.routes.add(route);
		
		return route;
	}


	/**
	 * 
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 * @return Route 
	 */
	public Route add (String path, EndpointProvider endpointProvider)
	{
		return this.add(new Route(path, endpointProvider));	
	}
	
	
	/**
	 * 
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 * @return Route
	 */
	public Route add (MatchMethod matchMethod, String path, EndpointProvider endpointProvider)
	{
		Route route = new Route(path, endpointProvider);
		route.setMatchMethod(matchMethod);
		
		return this.add(route);	
	}
	
	
	
	/**
	 * 
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 * @return Route
	 */
	public Route addSubRoute (String path, EndpointProvider endpointProvider) 
	{
		if (this.subRouters.isEmpty())
		{
			this.subRouters.add(new SubRouter(this.baseUrl)); 
		}
		
		return this.subRouters.get(0).add(path, endpointProvider);
	}


	/**
	 * 
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 * @param targetId String
	 * @return Route
	 */
	public Route addSubRoute (String path, EndpointProvider endpointProvider, String targetId)
	{
		Route route = this.addSubRoute(path, endpointProvider);
		route.setTargetId(targetId);
		
		return route;
	}


	/**
     * @return String
     */
    public String getBaseUrl ()
    {
    	if (this.baseUrl == null)
    	{
    		this.setBaseUrl("/");
    	}
    	
        return this.baseUrl;
    }


    /**
	 * 
	 * @return Endpoint
	 */
	public Endpoint getDefaultEndpoint ()
	{
		if (this.getDefaultRoute() != null)
		{
			return this.getDefaultRoute().getEndpoint();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @return Route
	 */
	public Route getDefaultRoute ()
	{
		return this.defaultRoute;
	}
	
	
	/**
	 * 
	 * @return MatchMethod
	 */
	public MatchMethod getDefaultMatchMethod ()
	{
		return this.defaultMatchMethod;
	}

	/**
	 * 
	 * @return List<Route>
	 */
	public List<Route> getRoutes ()
	{
		return this.routes;
	}


	/**
	 * 
	 * @param path String
	 * @throws Exception 
	 */
	public void route (BwtApplication app, String path) throws Exception
	{
		Bwt.debug("Router.route():" + path);
		
		if (this.getBaseUrl().equals("/") && path.contains(Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/"))
		{
			path = "/" + path.substring((Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/").length());
			
			Bwt.debug("Path adjusted to: " + path);
		}
		else if (path.startsWith(this.getBaseUrl()))
	    {
	        path = "/" + path.substring(this.getBaseUrl().length());
	        
	        Bwt.debug("Path adjusted to: " + path);
	    }
		
		
		Route selectedRoute = null;
	    	    
		for (Route route : this.getRoutes())
		{
			MatchMethod matchMethod = route.getMatchMethod();
			
			if (matchMethod == null)
			{
				matchMethod = this.getDefaultMatchMethod();
			}
			
			if (matchMethod == null)
			{
				matchMethod = MatchMethod.ENDS_WITH;
			}
			
			
			if (matchMethod.equals(MatchMethod.BEGINS_WITH))
			{
				if (path.startsWith(route.getPath()))
				{
					selectedRoute = route;
					break;
				}
			}	
			else if (matchMethod.equals(MatchMethod.ENDS_WITH))
			{
				if (path.endsWith(route.getPath()))
				{
					selectedRoute = route;
					break;
				}
			}			
			else if (matchMethod.equals(MatchMethod.EQUALS))
			{
				if (route.getPath().equals(path))
				{
					selectedRoute = route;
					break;
				}
			}
		}
		
		
		if (selectedRoute == null)
		{
			selectedRoute = this.getDefaultRoute();
		}
				
		if (selectedRoute == null)
		{
			selectedRoute = app.get404Route();
		}
		
		if (selectedRoute == null)
		{
			try
			{
				this.onDefaultEndpointNotSet();
			}
			catch (RouterException e)
			{
				throw e;
			}
		}
		else
		{
			selectedRoute.go(this.target, app, path, this.subRouters);
		}
	}
	
	
	/**
	 * 
	 * @param app BwtApplication
	 * @param path String
	 * @throws Exception 
	 */ 
	public void routeSubRoutes (BwtApplication app, String path) throws Exception 
	{
		for (SubRouter subRouter : this.subRouters)
		{
			subRouter.route(app, path);
		}		
	}


	/**
     * @param baseUrl String
     */
    public void setBaseUrl (String baseUrl)
    {
        this.baseUrl = baseUrl;
        
        for (SubRouter subRouter : this.subRouters)
		{
        	subRouter.setBaseUrl(baseUrl);
        } 
    }


    /**
	 * 
	 * @param matchMethod MatchMethod
	 */
	public void setDefualutMatchMethod (MatchMethod matchMethod)
	{
		this.defaultMatchMethod = matchMethod;
	}
	
	
	/**
	 * 
	 * @param defaultEndpointProvider EndpointProvider
	 */
	public void setDefaultEnpointProvider (EndpointProvider defaultEndpointProvider)
	{
		this.defaultRoute = new Route(defaultEndpointProvider);
	}

	
	/**
	 * 
	 * @param target BwtWidgetContainer
	 */
	public void setTarget (BwtWidgetContainer target)
	{
		this.target = target;
	}


	/**
	 * 
	 * @param panel Panel
	 * @throws Exception 
	 */
	public void setTarget (Panel panel) throws Exception
	{
		this.target = BwtWidgetContainer.wrap(panel);
	}

	
	/**
	 * 
	 * @throws RouterException
	 */
	protected void onDefaultEndpointNotSet () throws RouterException
	{
		throw new RouterException("Default endpoint not set.");		
	}
}
