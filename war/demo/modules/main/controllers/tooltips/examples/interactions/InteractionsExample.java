package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.interactions;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class InteractionsExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public InteractionsExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new InteractionsView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public InteractionsView getView ()
	{
		return (InteractionsView) super.getView();
	}
}
