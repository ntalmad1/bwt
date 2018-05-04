package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.show;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.AbstractTabEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;

/**
 * 
 * @author Noah
 *
 */
public class TabShowEvent extends AbstractTabEvent<TabShowHandler>
{
	/**
	 */
	private static GwtEvent.Type<TabShowHandler> type = new GwtEvent.Type<TabShowHandler>();
	
	/**
	 * 
	 * @return GwtEvent.Type<TabShowHandler>
	 */
	public static GwtEvent.Type<TabShowHandler> getType ()
	{
		return TabShowEvent.type;
	}
	
	
	
	/**
	 * Constructor
	 *  
	 * @param tab Tab
	 */
	public TabShowEvent (Tab tab)
	{
		super(tab);
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type<TabShowHandler>
	 */
	public GwtEvent.Type<TabShowHandler> getAssociatedType ()
	{
		return TabShowEvent.type;
	}


	/**
	 * 
	 * @param handler TabShowHandler
	 */
	protected void dispatch (TabShowHandler handler)
	{
		handler.onTabShow(this);
	}
}
