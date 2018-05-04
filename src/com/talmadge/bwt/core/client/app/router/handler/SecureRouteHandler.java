package com.talmadge.bwt.core.client.app.router.handler;

import java.util.ArrayList;
import java.util.List;

import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.app.router.Route;
import com.talmadge.bwt.core.client.app.router.SubRouter;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class SecureRouteHandler extends RouteHandlerImpl
{	
	/**
	 */
	private Route loginRoute;
	

	/**
	 * Constructor
	 * 
	 */
	public SecureRouteHandler (EndpointProvider loginEndpointProvider)
	{
		super();
		
		this.loginRoute = new Route(loginEndpointProvider);
	}
	
	
	/**
	 * 
	 * @param route Route
	 * @param defaultTarget BwtWidgetContainer
	 * @param app BwtApplication
	 * @param path String
	 * @param subRoutes List<SubRouter>
	 * @throws Exception 
	 */
	public void handle (Route route, BwtWidgetContainer defaultTarget, BwtApplication app, String path, List<SubRouter> subRoutes) throws Exception
	{
		this.loginRoute.go(defaultTarget, app, path, new ArrayList<SubRouter>());
	}
}
