package com.talmadge.bwt.core.client.ui.widget.menu.event.hide;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;
import com.talmadge.bwt.core.client.ui.widget.menu.event.AbstractMenuEvent;

/**
 * 
 * @author Noah
 *
 */
public class MenuHideEvent extends AbstractMenuEvent<MenuHideHandler>
{
	/**
	 */
	private static final GwtEvent.Type<MenuHideHandler> TYPE = new GwtEvent.Type<MenuHideHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<MenuHideHandler>
	 */
	public static GwtEvent.Type<MenuHideHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 * Constructor 
	 *  
	 * @param menu Menu
	 */
	public MenuHideEvent (Menu menu)
	{
		super(menu);
	}

	
	/**
	 * 
	 * @return GwtEvent.Type<MenuHideHandler> 
	 */
	public GwtEvent.Type<MenuHideHandler> getAssociatedType ()
	{
		return TYPE;
	}

	
	/**
	 * 
	 * @param handler MenuHideHandler
	 */
	protected void dispatch (MenuHideHandler handler)
	{
		handler.onMenuHide(this);
	}
}
