package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.smart;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class SmartExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public SmartExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new SmartView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public SmartView getView ()
	{
		return (SmartView) super.getView();
	}
}
