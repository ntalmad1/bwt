package com.talmadge.bwt.core.client.ui.widget.menu.item;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.event.select.HasSelectHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;
import com.talmadge.bwt.core.client.ui.widget.menu.header.MenuHeader;
import com.talmadge.bwt.core.client.ui.widget.menu.separator.MenuSeparator;

/**
 * 
 * @author Noah
 *
 */
public class MenuItem extends BwtWidgetContainer implements HasSelectHandlers<MenuItem>
{
	/**
	 */
	private Menu menu;
	
	
	/**
	 * Constructor
	 * 
	 */
	public MenuItem ()
	{
		this((MenuItemAppearance) GWT.create(DefaultMenuItemAppearance.class));
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public MenuItem (String text)
	{
		this();
		
		this.setText(text);
	}


	/**
	 * Constructor
	 * 
	 * @param icon Glyphicon
	 * @param text String
	 */
	public MenuItem (Glyphicon icon, String text)
	{
		this();
		
		this.setText(text);
		this.setIcon(icon);
	}


	/**
	 * Constructor
	 * 
	 * @param appearance MenuItemAppearance
	 */
	protected MenuItem (MenuItemAppearance appearance)
	{
		super(appearance);
		
		this.bind();
		
	}

	
	/**
	 *  
	 * @param header MenuHeader
	 */
	public void add (MenuHeader header)
	{
		this.ensureMenu().add(header);
	}
	
	
	/**
	 *  
	 * @param item MenuItem
	 */
	public void add (MenuItem item)
	{
		this.ensureMenu().add(item);
	}
	
	
	/**
	 *  
	 * @param separator MenuSeparator
	 */
	public void add (MenuSeparator separator)
	{
		this.ensureMenu().add(separator);
	}
	

	/**
	 * 
	 * @param handler SelectHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSelectHandler (SelectHandler<MenuItem> handler)
	{
		return this.addHandler(handler, SelectEvent.getType());
	}


	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.getAppearance().setIcon(icon);		
	}


	/**
	 * 
	 * @param iconAlign IconAlign
	 */
	public void setIconAlign (IconAlign iconAlign)
	{
		this.getAppearance().setIconAlign(iconAlign);		
	}


	/**
	 * 
	 * @param menu Menu
	 */
	public void setMenu (Menu menu)
	{
		this.menu = menu;
		
		this.getChildren().add(menu);
		
		this.getAppearance().setMenu(menu);
		
		if (this.isAttached())
		{
			this.attachChild(menu);
		}
		
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.getAppearance().setText(text);
	}


	/**
	 * 
	 */
	protected void bind ()
	{
		this.getChildren().add(this.getAppearance().getAnchor());
		
		this.getAppearance().getAnchor().addDomHandler(new ClickHandler()
		{
			public void onClick (ClickEvent event)
			{
				MenuItem.this._onClick(event);				
			}
		}, ClickEvent.getType());		
	}

	
	/**
	 * 
	 * @return Menu
	 */
	protected Menu ensureMenu ()
	{	
		if (this.menu == null)
		{
			this.setMenu(new Menu());
		}
		
		return this.menu;
	}


	/**
	 * 
	 * @param event ClickEvent
	 */
	protected void onClick (ClickEvent event)
	{
				
	}


	/**
	 * 
	 * @return MenuItemAppearance
	 */
	protected MenuItemAppearance getAppearance ()
	{
		return (MenuItemAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 * @param event SelectEvent
	 */
	protected void onSelect (SelectEvent<MenuItem> event)
	{
		
	}

	/**
	 * 
	 * @param event ClickEvent
	 */
	protected void _onClick (ClickEvent event)
	{
		SelectEvent<MenuItem> selectEvent = new SelectEvent<MenuItem>(this);
		this.fireEvent(selectEvent);
		this.onSelect(selectEvent);
		
		this.onClick(event);
	}
}
