package com.talmadge.bwt.core.client.app.router.handler;

import java.util.List;

import com.google.gwt.user.client.ui.RootPanel;
import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.app.endpoint.Endpoint;
import com.talmadge.bwt.core.client.app.router.Route;
import com.talmadge.bwt.core.client.app.router.SubRouter;
import com.talmadge.bwt.core.client.ui.Bwt;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class EndpointRouteHandler extends RouteHandlerImpl
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
	@Override
	public void handle (Route route, BwtWidgetContainer defaultTarget, BwtApplication app, String path, List<SubRouter> subRoutes) throws Exception
	{
		Endpoint endpoint = route.getEndpoint();
		
		if (Bwt.isDebugMode())
		{
			Bwt.debug("Router - route fond: path: " + path + " endpoint: " + endpoint.getClass());
		}
		
		if ((defaultTarget == null) && (route.getTargetId() != null))
		{
			endpoint.setTarget(RootPanel.get(route.getTargetId()));				
		}
		else if (defaultTarget == null)
		{
			endpoint.setTarget(RootPanel.get());
		}
		else
		{
			endpoint.setTarget(defaultTarget);
		}
	
		endpoint.setApp(app);
		endpoint.setPath(path);         	
		endpoint.go();
		
		for (SubRouter subRouter : subRoutes)
		{
			subRouter.route(app, path);
		}
	}
}
