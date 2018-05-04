package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.multiple;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class MultipleExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public MultipleExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new MultipleView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public MultipleView getView ()
	{
		return (MultipleView) super.getView();
	}
}
