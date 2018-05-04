package com.talmadge.bwt.demo.client.modules.main.controllers.about;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public class AboutView extends BwtView
{
	/**
	 * Constructor
	 * 
	 * @param controller AboutController
	 */
	public AboutView (AboutController controller)
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
		this.clear();
		this.add(new Html("About"));
		
	}
}
