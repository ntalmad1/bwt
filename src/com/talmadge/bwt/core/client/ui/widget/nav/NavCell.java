package com.talmadge.bwt.core.client.ui.widget.nav;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.nav.event.HasItemAddHandlers;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddEvent;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class NavCell extends BwtWidgetContainer implements HasItemAddHandlers
{
	/**
	 * Constructor
	 * 
	 * @param appearance Appearance
	 */
	protected NavCell (BwtWidgetAppearance appearance)
	{
		super(appearance);		
	}

	
	/**
	 * 
	 * @return SidebarAppearance
	 */
	protected NavAppearance getAppearance ()
	{
		return (NavAppearance) super.getAppearance();
	}

	
	/**
	 * 
	 * @param handler ItemAddHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addItemAddHandler (ItemAddHandler handler)
    {
        return this.addHandler(handler, ItemAddEvent.getType());
    }


    /**
	 * 
	 * @return NavItem
	 */
    public NavItem getFirstItem ()
    {
        return (NavItem) this.getChildren().get(0);
    }
}
