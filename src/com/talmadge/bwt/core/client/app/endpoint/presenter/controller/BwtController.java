package com.talmadge.bwt.core.client.app.endpoint.presenter.controller;

import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.app.endpoint.presenter.BwtPresenter;
import com.talmadge.bwt.core.client.app.router.Route;
import com.talmadge.bwt.core.client.app.router.Router;

/**
 * 
 *
 */
public abstract class BwtController extends BwtPresenter
{
	/**
	 */
	private Router router;
	
	
    /**
     * Constructor
     *  
     */
    public BwtController ()
    {
    	super();
    	
    	this.router = new Router();
    	
    	this.setup();
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
		return this.router.addSubRoute(path, endpointProvider, targetId);
	}
    
	
	/**
     * 
     */
    @Override
	public void go () throws Exception
	{
		super.go();
		
		
		this.router.routeSubRoutes(this.getApp(), this.getPath());
	}
	
	
	/**
	 * 
	 * @param appBwtApplication BwtApplication
	 */
	@Override
	public void setApp (BwtApplication app)
	{
		super.setApp(app);
		
		if (this.router.getBaseUrl() == null || this.router.getBaseUrl().isEmpty())
		{
			this.router.setBaseUrl(BwtApplication.getAppUrl());
		}
	}
	
    
    /**
     * 
     */
	protected  void setup ()
	{
		
	}
}
