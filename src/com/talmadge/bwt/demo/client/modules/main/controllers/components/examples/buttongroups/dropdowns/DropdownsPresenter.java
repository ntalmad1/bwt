package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.dropdowns;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class DropdownsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 *
	 * @param sidebar BwtDemoSidebar
	 */
	public DropdownsPresenter ()
	{
		super();
		
		this.setView(new DropdownsView(this));
	}
}
