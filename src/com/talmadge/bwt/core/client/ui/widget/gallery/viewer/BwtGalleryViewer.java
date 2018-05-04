package com.talmadge.bwt.core.client.ui.widget.gallery.viewer;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.left.HasLeftHandlers;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.left.LeftHandler;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.right.HasRightHandlers;
import com.talmadge.bwt.core.client.ui.widget.gallery.event.right.RightHandler;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;

/**
 *
 */
public class BwtGalleryViewer extends BwtComposite implements HasLeftHandlers, HasRightHandlers
{
    /**
     */
    private BwtGalleryViewerCell cell;
    

    /**
     * Constructor
     * 
     */
    public BwtGalleryViewer ()
    {
        super();
        
        this.cell = new BwtGalleryViewerCell();
        
        this.initWidget(this.cell);
    }

    
    /**
     * 
     * @param handler LeftHandler
     */
    @Override
    public HandlerRegistration addLeftHandler (LeftHandler handler)
    {
        return this.getCell().addLeftHandler(handler);
    }


    /**
     * 
     * @param handler RightHandler
     */
    @Override
    public HandlerRegistration addRightHandler (RightHandler handler)
    {
        return this.getCell().addRightHandler(handler);
    }


    /**
     * 
     * @return int
     */
    public int getHeight ()
    {
        return this.getCell().getHeight();
    }


    /**
     * 
     */
    public void layout ()
    {
        this.getCell().layout();
    }


    /**
     * 
     * @param item BwtGalleryItem
     */
    public void update (BwtGalleryItem item)
    {
        this.getCell().update(item);
    }


    /**
     * 
     * @return BwtGalleryCell
     */
    protected BwtGalleryViewerCell getCell ()
    {
        return this.cell;
    }
}
