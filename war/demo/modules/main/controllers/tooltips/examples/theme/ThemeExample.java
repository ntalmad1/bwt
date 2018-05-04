package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.theme;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class ThemeExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ThemeExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new ThemeView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public ThemeView getView ()
	{
		return (ThemeView) super.getView();
	}
}
