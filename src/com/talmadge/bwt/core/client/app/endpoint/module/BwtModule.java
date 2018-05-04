package com.talmadge.bwt.core.client.app.endpoint.module;

import com.talmadge.bwt.core.client.app.endpoint.AbstractEndpoint;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.app.router.Route;
import com.talmadge.bwt.core.client.app.router.Router;
import com.talmadge.bwt.core.client.app.router.RouterException;
import com.talmadge.bwt.core.client.app.router.Router.MatchMethod;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public abstract class BwtModule extends AbstractEndpoint
{
	/**
	 */
	private Router router;
		
    /**
     * Constructor
     * 
     */
    public BwtModule ()
    {
    	super();
        
    	this.router = new Router();
    	
        this.setup(); 	
    }
    
    
    /**
	 * 
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 * @return Route
	 */
	public Route addRoute (String path, EndpointProvider endpointProvider)
	{
		return this.router.add(path, endpointProvider);
	}

    
    /**
	 * 
	 * @param matchMethod MatchMethod
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 * @return Route
	 */
	public Route addRoute (MatchMethod matchMethod, String path, EndpointProvider endpointProvider)
	{
		return this.router.add(matchMethod, path, endpointProvider);
	}
    
    
    /**
     * 
     * @return Router
     */
    public Router getRouter ()
    {
    	return this.router;
    }
    
    
	/**
	 * 
	 */
	@Override
	public void go () throws Exception
	{
		try
 		{
    		this.getRouter().route(this.getApp(), this.getPath());
 		}
		catch (RouterException e)
    	{
    		throw e;
    	}
    	catch (Exception e)
		{
			throw new RouterException(e);
		}
	}
    
	
	/**
	 * 
	 * @param target BwtWidgetContainer 
	 */
	@Override
	public void setTarget (BwtWidgetContainer target)
	{
		super.setTarget(target);
		this.getRouter().setTarget(target);
	}
	

	/**
     * 
     */
    protected abstract void setup ();
}
