package com.talmadge.bwt.core.client.ui.widget.gallery.thumbpanel;

import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;

/**
 * 
 *
 */
public class ThumbPanel extends BwtComposite
{
    /**
     */
    private ThumbPanelCell cell;
    
    
    
    /**
     * Constructor
     * 
     */
    public ThumbPanel ()
    {
        super();
        
        this.cell = new ThumbPanelCell();
        
        this.initWidget(this.getCell());
    }
    
    
    /**
     * 
     * @param item BwtGalleryItem
     */
    public void add (BwtGalleryItem item)
    {
        this.getCell().add(item);        
    }


    /**
     * 
     * @return ThumbPanelCell
     */
    protected ThumbPanelCell getCell ()
    {
        return this.cell;
    }
}
