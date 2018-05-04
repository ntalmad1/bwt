package com.talmadge.bwt.core.client.ui.widget.gallery.thumbpanel;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultThumbPanelAppearance extends DefaultBwtWidgetContainerAppearance implements ThumbPanelAppearance
{
    /**
     * Constructor
     * 
     */
    protected DefaultThumbPanelAppearance ()
    {
        super(Document.get().createDivElement());
    }
    
    
    /**
     * 
     */
    @Override
    protected void build ()
    {
        this.ensureCssName("center-block");
        
        this.ensureCssName("bwt-thumbpanel");
    }
}
