package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.html;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class HtmlExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public HtmlExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new HtmlView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public HtmlView getView ()
	{
		return (HtmlView) super.getView();
	}
}
