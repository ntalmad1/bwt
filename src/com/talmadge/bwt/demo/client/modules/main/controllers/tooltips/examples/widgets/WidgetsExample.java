package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.widgets;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class WidgetsExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public WidgetsExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new WidgetsView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public WidgetsView getView ()
	{
		return (WidgetsView) super.getView();
	}
}
