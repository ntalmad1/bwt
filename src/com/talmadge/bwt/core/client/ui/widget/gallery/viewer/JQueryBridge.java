package com.talmadge.bwt.core.client.ui.widget.gallery.viewer;

/**
 * 
 *
 */
class JQueryBridge
{
    /**
     */
    private BwtGalleryViewerCell bwtGallery;
    
    
    /**
     * Constructor
     * 
     * @param bwtGallery BwtGalleryCell
     */
    protected JQueryBridge (BwtGalleryViewerCell bwtGallery)
    {
        this.bwtGallery = bwtGallery;
    }
    
    
    /**
     * 
     * @return BwtGallery
     */
    protected BwtGalleryViewerCell getGallery ()
    {
        return this.bwtGallery;
    }
}
