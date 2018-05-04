package com.talmadge.bwt.core.client.ui.widget.gallery.thumbpanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.dom.client.Style.Unit;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;
import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;

/**
 * 
 *
 */
public class ThumbPanelCell extends BwtWidgetContainer
{
    /**
     */
    private List<BwtGalleryItem> items;
    
    /**
     */
    private Map<BwtGalleryItem, BwtImage> thumbs;
   
    
    
    /**
     * Constructor
     * 
     */
    public ThumbPanelCell ()
    {
        this(new DefaultThumbPanelAppearance());
    }
    
    
    /**
     * Hidden Constructor
     * 
     * @param appearance ThumbPanelAppearance
     */
    protected ThumbPanelCell (ThumbPanelAppearance appearance)
    {
        super(appearance);
        
        this.items = new ArrayList<BwtGalleryItem>();
        this.thumbs = new HashMap<BwtGalleryItem, BwtImage>();
    }


    /**
     * 
     * @param item BwtGalleryItem
     */
    public void add (BwtGalleryItem item)
    {
        if (!this.items.isEmpty())
        {
            this.thumbs.get(this.items.get(this.items.size() - 1)).getElement().getStyle().setMarginRight(10, Unit.PX);
        }
        
        this.items.add(item);
        
        BwtImage thumb = new BwtImage(item.getThumbUrl());
        
        this.thumbs.put(item, thumb);
        
        this.add(thumb);
    }
}
