package com.talmadge.bwt.core.client.ui.widget.gallery.event.left;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 *
 */
public class LeftEvent extends GwtEvent<LeftHandler>
{
    /**
     */
    private static GwtEvent.Type<LeftHandler> TYPE = new GwtEvent.Type<LeftHandler>();
    
    
    /**
     * 
     * @return GwtEvent.Type<LeftHandler>
     */
    public static GwtEvent.Type<LeftHandler> getType ()
    {
        return TYPE;
    }
    
    
    /**
     * 
     * @return HandlerRegistration
     */
    @Override
    public GwtEvent.Type<LeftHandler> getAssociatedType ()
    {
        return TYPE;
    }
    
    
    /**
     * 
     * @param handler LeftHandler
     */
    @Override
    protected void dispatch (LeftHandler handler)
    {
        handler.onLeft(this);        
    }
    
}
