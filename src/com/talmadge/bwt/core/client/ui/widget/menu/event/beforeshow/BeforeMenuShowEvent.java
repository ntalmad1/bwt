package com.talmadge.bwt.core.client.ui.widget.menu.event.beforeshow;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;
import com.talmadge.bwt.core.client.ui.widget.menu.event.AbstractMenuEvent;

/**
 * 
 * @author Noah
 *
 */
public class BeforeMenuShowEvent extends AbstractMenuEvent<BeforeMenuShowHandler>
{
	/**
	 */
	private static final GwtEvent.Type<BeforeMenuShowHandler> TYPE = new GwtEvent.Type<BeforeMenuShowHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeMenuShowHandler>
	 */
	public static GwtEvent.Type<BeforeMenuShowHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 * Constructor 
	 *  
	 * @param menu Menu
	 */
	public BeforeMenuShowEvent (Menu menu)
	{
		super(menu);
	}

	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeMenuShowHandler> 
	 */
	public GwtEvent.Type<BeforeMenuShowHandler> getAssociatedType ()
	{
		return TYPE;
	}

	
	/**
	 * 
	 * @param handler BeforeMenuShowHandler
	 */
	protected void dispatch (BeforeMenuShowHandler handler)
	{
		handler.onBeforeMenuShow(this);
	}
}
