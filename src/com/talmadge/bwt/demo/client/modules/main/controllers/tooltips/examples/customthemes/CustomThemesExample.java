package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.customthemes;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class CustomThemesExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public CustomThemesExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new CustomThemesView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public CustomThemesView getView ()
	{
		return (CustomThemesView) super.getView();
	}
}
