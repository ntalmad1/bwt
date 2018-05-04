package com.talmadge.bwt.core.client.app.router.handler;

import java.util.List;

import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.router.Route;
import com.talmadge.bwt.core.client.app.router.SubRouter;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public interface RouteHandler
{
	/**
	 * 
	 * @param route Route
	 * @param defaultTarget BwtWidgetContainer
	 * @param app BwtApplication
	 * @param path String
	 * @param subRoutes List<SubRouter>
	 * @throws Exception 
	 */
	void handle (Route route, BwtWidgetContainer defaultTarget, BwtApplication app, String path, List<SubRouter> subRoutes) throws Exception;
	
	/**
	 * @param routeHandler RouteHandler
	 */
	void setNext (RouteHandler routeHandler);

	/**
	 * @param routeHandler RouteHandler
	 */
	void setPrev (RouteHandler routeHandler);
}
