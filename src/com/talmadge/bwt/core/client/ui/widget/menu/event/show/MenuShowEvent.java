package com.talmadge.bwt.core.client.ui.widget.menu.event.show;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;
import com.talmadge.bwt.core.client.ui.widget.menu.event.AbstractMenuEvent;

/**
 * 
 * @author Noah
 *
 */
public class MenuShowEvent extends AbstractMenuEvent<MenuShowHandler>
{
	/**
	 */
	private static final GwtEvent.Type<MenuShowHandler> TYPE = new GwtEvent.Type<MenuShowHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<MenuShowHandler>
	 */
	public static GwtEvent.Type<MenuShowHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 * Constructor 
	 *  
	 * @param menu Menu
	 */
	public MenuShowEvent (Menu menu)
	{
		super(menu);
	}

	
	/**
	 * 
	 * @return GwtEvent.Type<MenuShowHandler> 
	 */
	public GwtEvent.Type<MenuShowHandler> getAssociatedType ()
	{
		return TYPE;
	}

	
	/**
	 * 
	 * @param handler MenuShowHandler
	 */
	protected void dispatch (MenuShowHandler handler)
	{
		handler.onMenuShow(this);
	}
}
