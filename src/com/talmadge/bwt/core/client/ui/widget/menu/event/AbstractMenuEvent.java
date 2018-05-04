package com.talmadge.bwt.core.client.ui.widget.menu.event;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;

/**
 * 
 * @author Noah
 * 
 * @param <H> extends EventHandler
 */
public abstract class AbstractMenuEvent<H extends EventHandler> extends GwtEvent<H>
{
	/**
	 */
	private Menu menu;

	
	
	/**
	 * Constructor
	 *
	 * @param menu Menu
	 */
	public AbstractMenuEvent (Menu menu)
	{
		super();
		
		this.menu = menu;
	}
	
	
	/**
	 * 
	 * @return Menu
	 */
	public Menu getMenu ()
	{
		return this.menu;
	}
}
