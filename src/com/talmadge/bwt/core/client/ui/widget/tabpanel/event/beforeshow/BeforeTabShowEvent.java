package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforeshow;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.AbstractTabEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;

/**
 * 
 * @author Noah
 *
 */
public class BeforeTabShowEvent extends AbstractTabEvent<BeforeTabShowHandler>
{
	/**
	 */
	private static GwtEvent.Type<BeforeTabShowHandler> type = new GwtEvent.Type<BeforeTabShowHandler>();
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeTabShowHandler>
	 */
	public static GwtEvent.Type<BeforeTabShowHandler> getType ()
	{
		return BeforeTabShowEvent.type;
	}
	
	
	
	/**
	 * Constructor
	 *  
	 * @param tab Tab
	 */
	public BeforeTabShowEvent (Tab tab)
	{
		super(tab);
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeTabShowHandler>
	 */
	public GwtEvent.Type<BeforeTabShowHandler> getAssociatedType ()
	{
		return BeforeTabShowEvent.type;
	}


	/**
	 * 
	 * @param handler BeforeTabShowHandler
	 */
	protected void dispatch (BeforeTabShowHandler handler)
	{
		handler.onBeforeTabShow(this);
	}
}
