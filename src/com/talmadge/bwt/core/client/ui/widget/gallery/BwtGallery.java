package com.talmadge.bwt.core.client.ui.widget.gallery;

import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;

/**
 *
 */
public class BwtGallery extends BwtComposite
{
    /**
     */
    private BwtGalleryCell cell;
        
    
    /**
     * Constructor
     * 
     */
    public BwtGallery ()
    {
        super();
        
        this.cell = new BwtGalleryCell();
        
        this.initWidget(this.cell);
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
     * @param isCentered boolean
     */
    public void setCentered (boolean isCentered)
    {
        this.getCell().setCentered(isCentered);        
    }


    /**
     * 
     * @param width int
     */
    public void setMaxWidth (int width)
    {
        this.getCell().setMaxWidth(width);        
    }


    /**
     * 
     * @return BwtGalleryCell
     */
    protected BwtGalleryCell getCell ()
    {
        return this.cell;
    }
}
