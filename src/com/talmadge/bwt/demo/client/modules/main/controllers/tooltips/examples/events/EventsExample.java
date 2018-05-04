package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.examples.events;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;
import com.talmadge.bwt.demo.client.modules.main.controllers.main.components.BwtDemoSidebar;

/**
 * 
 *
 */
public class EventsExample extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public EventsExample (BwtDemoSidebar sidebar)
	{
		super();
		
		this.setView(new EventsView(this));
	
		this.populateSideNav(sidebar);
	}


	/**
	 * 
	 * @return ButtonBlockView
	 */
	public EventsView getView ()
	{
		return (EventsView) super.getView();
	}
}
