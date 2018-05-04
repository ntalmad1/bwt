package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforehide;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.AbstractTabEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;

/**
 * 
 * @author Noah
 *
 */
public class BeforeTabHideEvent extends AbstractTabEvent<BeforeTabHideHandler>
{
	/**
	 */
	private static GwtEvent.Type<BeforeTabHideHandler> type = new GwtEvent.Type<BeforeTabHideHandler>();
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeTabHideHandler>
	 */
	public static GwtEvent.Type<BeforeTabHideHandler> getType ()
	{
		return BeforeTabHideEvent.type;
	}
	
	
	
	/**
	 * Constructor
	 *  
	 * @param tab Tab
	 */
	public BeforeTabHideEvent (Tab tab)
	{
		super(tab);
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeTabHideHandler>
	 */
	public GwtEvent.Type<BeforeTabHideHandler> getAssociatedType ()
	{
		return BeforeTabHideEvent.type;
	}


	/**
	 * 
	 * @param handler TabShowHandler
	 */
	protected void dispatch (BeforeTabHideHandler handler)
	{
		handler.onBeforeTabHide(this);
	}
}
