package com.talmadge.bwt.core.client.ui.widget.event.resize;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 *
 */
public interface HasBwtResizeHandlers
{
    /**
     * 
     * @param handler BwtResizeHandler
     * @return HandlerResgistration
     */
    HandlerRegistration addBwtResizeHandler (BwtResizeHandler handler);
}
