package com.talmadge.bwt.core.client.ui.widget.nav.event;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class ItemAddEvent extends GwtEvent<ItemAddHandler>
{
    /**
     */
    private static GwtEvent.Type<ItemAddHandler> TYPE = new GwtEvent.Type<ItemAddHandler>();
    
    
    
    /**
     * 
     * @return GwtEvent.Type<ItemAddHandler>
     */
    public static GwtEvent.Type<ItemAddHandler> getType ()
    {
        return TYPE;
    }

    
    
    /**
     */
    private NavItem item;
    
    

    /**
     * Constructor
     * 
     * @param navItem NavItem
     */
    public ItemAddEvent (NavItem navItem)
    {
        this.item = navItem;
    }



    /**
     * 
     * @return GwtEvent.Type<ItemAddHandler>
     */
    public GwtEvent.Type<ItemAddHandler> getAssociatedType ()
    {
        return TYPE;
    }

    
    /**
     * 
     * @return NavItem
     */
    public NavItem getItem ()
    {
        return this.item;
    }
    

    /**
     * 
     * @param handler ItemAddHandler
     */
    protected void dispatch (ItemAddHandler handler)
    {
        handler.onItemAdd(this);
    }
}
