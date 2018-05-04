package com.talmadge.bwt.core.client.ui.widget.event.resize;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.BwtDimension;

/**
 * 
 *
 */
/**
 * @author noaht
 *
 */
public class BwtResizeEvent extends GwtEvent<BwtResizeHandler>
{
    /**
     */
    private static GwtEvent.Type<BwtResizeHandler> TYPE = new GwtEvent.Type<BwtResizeHandler>();
    
    
    /**
     * 
     * @return GwtEvent.Type<BwtResizeHandler>
     */
    public static GwtEvent.Type<BwtResizeHandler> getType ()
    {
        return TYPE;
    }
    
    
    /**
     * 
     * @return GwtEvent.Type<BwtResizeHandler>
     */
    @Override
    public GwtEvent.Type<BwtResizeHandler> getAssociatedType ()
    {
        return TYPE;
    }

    
    /**
     */
    private BwtDimension absoluteDimension;
    
    /**
     */
    private BwtDimension dimension;
    
    
    
    /**
     * Constructor
     * 
     * @param dimension BwtDimension
     * @param absoluteDimension BwtDimension
     */
    public BwtResizeEvent (BwtDimension dimension, BwtDimension absoluteDimension)
    {
        super();
        
        this.dimension = dimension;
        this.absoluteDimension = absoluteDimension;
    }
    
    
    /**
     * @return the absoluteDimension
     */
    public BwtDimension getAbsoluteDimension ()
    {
        return absoluteDimension;
    }


    /**
     * @return the dimension
     */
    public BwtDimension getDimension ()
    {
        return dimension;
    }


    /**
     * 
     * @param handler BwtResizeHandler
     */
    @Override
    protected void dispatch (BwtResizeHandler handler)
    {
        handler.onResize(this);        
    }

}
