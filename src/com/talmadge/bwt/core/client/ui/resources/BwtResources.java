package com.talmadge.bwt.core.client.ui.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 *
 */
public interface BwtResources extends ClientBundle
{
    /**
     */
    BwtResources INSTANCE = GWT.create(BwtResources.class);
   
    
    /**
     * 
     * @return ImageResource
     */
    @Source("ajax-loader.gif")
    ImageResource ajaxLoader ();
}
