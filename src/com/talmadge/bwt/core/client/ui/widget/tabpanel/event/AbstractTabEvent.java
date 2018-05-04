package com.talmadge.bwt.core.client.ui.widget.tabpanel.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;

/**
 * 
 * @author Noah
 * 
 * @param <H> handler
 */
public abstract class AbstractTabEvent<H extends EventHandler> extends GwtEvent<H>
{
	/**
	 */
	private Tab tab;
	
	
	
	/**
	 * Constructor 
	 * 
	 * @param tab Tab
	 */ 
	public AbstractTabEvent (Tab tab)
	{
		super();
		
		this.tab = tab;
	}
	
	
	/**
	 * 
	 * @return Tab
	 */
	public Tab getTab ()
	{
		return this.tab;
	}
}
