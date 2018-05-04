package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.dropdowns;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 * @author Noah
 *
 */
public class DropdownsExample extends BwtExamplePresenter
{

	
	/**
	 * Constructor
	 * 
	 */
	public DropdownsExample (BwtDemoSidebar sidebar)
	{
		super();
		this.setView(new DropdownsView(this)); 

		this.populateSideNav(sidebar);
	}
}
