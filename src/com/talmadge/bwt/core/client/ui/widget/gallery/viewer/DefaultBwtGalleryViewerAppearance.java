package com.talmadge.bwt.core.client.ui.widget.gallery.viewer;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultBwtGalleryViewerAppearance extends DefaultBwtWidgetContainerAppearance implements BwtGalleryViewerAppearance
{
    /**
     * Constructor
     * 
     */
    protected DefaultBwtGalleryViewerAppearance ()
    {
        super(Document.get().createDivElement());
        
    }
    
    
    /**
     * 
     */
    @Override
    protected void build ()
    {
        this.ensureCssName("well");
    
    }
}
