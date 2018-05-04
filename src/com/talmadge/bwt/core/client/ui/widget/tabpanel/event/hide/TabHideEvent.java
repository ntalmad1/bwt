package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.hide;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.AbstractTabEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;

/**
 * 
 * @author Noah
 *
 */
public class TabHideEvent extends AbstractTabEvent<TabHideHandler>
{
	/**
	 */
	private static GwtEvent.Type<TabHideHandler> type = new GwtEvent.Type<TabHideHandler>();
	
	/**
	 * 
	 * @return GwtEvent.Type<TabHideHandler>
	 */
	public static GwtEvent.Type<TabHideHandler> getType ()
	{
		return TabHideEvent.type;
	}
	
	
	
	/**
	 * Constructor
	 *  
	 * @param tab Tab
	 */
	public TabHideEvent (Tab tab)
	{
		super(tab);
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type<TabHideHandler>
	 */
	public GwtEvent.Type<TabHideHandler> getAssociatedType ()
	{
		return TabHideEvent.type;
	}


	/**
	 * 
	 * @param handler TabHideHandler
	 */
	protected void dispatch (TabHideHandler handler)
	{
		handler.onTabHide(this);
	}
}
