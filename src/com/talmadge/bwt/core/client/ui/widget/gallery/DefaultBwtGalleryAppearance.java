package com.talmadge.bwt.core.client.ui.widget.gallery;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultBwtGalleryAppearance extends DefaultBwtWidgetContainerAppearance implements BwtGalleryAppearance
{
    /**
     * Constructor
     * 
     */
    protected DefaultBwtGalleryAppearance ()
    {
        super(Document.get().createDivElement());
    }
    
    
    /**
     * 
     */
    @Override
    protected void build ()
    {
        // TODO Auto-generated method stub
        
    }
}
