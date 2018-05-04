package com.talmadge.bwt.core.client.app.endpoint;

import com.google.gwt.user.client.ui.Panel;
import com.talmadge.bwt.core.client.app.BwtApplication;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public abstract class AbstractEndpoint implements Endpoint
{
	/**
	 */
	private BwtApplication app;
	
	/**
	 */
	private String path;

	/**
	 */
	private BwtWidgetContainer target;
	
	
	
	/**
	 * 
	 * @return BwtApplication
	 */
	public BwtApplication getApp ()
	{
		return this.app;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public String getAppUrl ()
	{
		return BwtApplication.getAppUrl();
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getPath ()
	{
		return this.path;
	}


	/**
	 * 
	 * @return BwtWidgetContainer
	 */
	public BwtWidgetContainer getTarget ()
	{
		return this.target;
	}
	
	
	/**
	 * 
	 * @param appBwtApplication BwtApplication
	 */
	@Override
	public void setApp (BwtApplication app)
	{
		this.app = app;
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
	 * @param target BwtWidgetContainer 
	 */
	@Override
	public void setTarget (BwtWidgetContainer target)
	{
		this.target = target;
	}
	
	
	/**
	 * 
	 * @param panel Panel
	 * @throws Exception 
	 */
	@Override
	public void setTarget (Panel panel) throws Exception
	{
		BwtWidgetContainer container = BwtWidgetContainer.wrap(panel);
		this.setTarget(container);
	}
}
