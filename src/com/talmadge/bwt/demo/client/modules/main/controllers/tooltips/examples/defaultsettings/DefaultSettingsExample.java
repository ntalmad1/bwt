package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.defaultsettings;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class DefaultSettingsExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultSettingsExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new DefaultSettingsView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public DefaultSettingsView getView ()
	{
		return (DefaultSettingsView) super.getView();
	}
}
