package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.customtriggers;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class CustomTriggersExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public CustomTriggersExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new CustomTriggersView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public CustomTriggersView getView ()
	{
		return (CustomTriggersView) super.getView();
	}
}
