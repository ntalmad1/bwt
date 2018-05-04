package com.talmadge.bwt.core.client.ui.widget.gallery.event.right;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 *
 */
public class RightEvent extends GwtEvent<RightHandler>
{
    /**
     */
    private static GwtEvent.Type<RightHandler> TYPE = new GwtEvent.Type<RightHandler>();
    
    
    /**
     * 
     * @return GwtEvent.Type<RightHandler>
     */
    public static GwtEvent.Type<RightHandler> getType ()
    {
        return TYPE;
    }
    
    
    /**
     * 
     * @return HandlerRegistration
     */
    @Override
    public GwtEvent.Type<RightHandler> getAssociatedType ()
    {
        return TYPE;
    }
    
    
    /**
     * 
     * @param handler RightHandler
     */
    @Override
    protected void dispatch (RightHandler handler)
    {
        handler.onRight(this);        
    }
    
}
