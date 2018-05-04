package com.talmadge.bwt.demo.client.controllers.notfound;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.Bwt;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

public class NotFoundView extends BwtView
{
	/**
	 * Constructor
	 * 
	 * @param controller
	 */
	public NotFoundView (NotFoundController controller)
	{
		super(controller);
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void init ()
	{
		
		
	}


	/**
	 * 
	 */
	@Override
	public void go ()
	{
		try
		{
			BwtWidgetContainer mainContainer = Bwt.getRootContainer();
			mainContainer.clear();
			mainContainer.add(new Html("Page Not Found"));
		}
		catch (Exception e)
		{
			this.onException(e);
		}
		
	}
}
