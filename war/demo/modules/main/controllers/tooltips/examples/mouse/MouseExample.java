package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.mouse;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class MouseExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public MouseExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new MouseView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public MouseView getView ()
	{
		return (MouseView) super.getView();
	}
}
