package com.talmadge.bwt.core.client.ui.widget.menu.event.beforehide;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;
import com.talmadge.bwt.core.client.ui.widget.menu.event.AbstractMenuEvent;

/**
 * 
 * @author Noah
 *
 */
public class BeforeMenuHideEvent extends AbstractMenuEvent<BeforeMenuHideHandler>
{
	/**
	 */
	private static final GwtEvent.Type<BeforeMenuHideHandler> TYPE = new GwtEvent.Type<BeforeMenuHideHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeMenuHideHandler>
	 */
	public static GwtEvent.Type<BeforeMenuHideHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 * Constructor 
	 *  
	 * @param menu Menu
	 */
	public BeforeMenuHideEvent (Menu menu)
	{
		super(menu);
	}

	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeMenuHideHandler> 
	 */
	public GwtEvent.Type<BeforeMenuHideHandler> getAssociatedType ()
	{
		return TYPE;
	}

	
	/**
	 * 
	 * @param handler BeforeMenuHideHandler
	 */
	protected void dispatch (BeforeMenuHideHandler handler)
	{
		handler.onBeforeMenuHide(this);
	}
}
