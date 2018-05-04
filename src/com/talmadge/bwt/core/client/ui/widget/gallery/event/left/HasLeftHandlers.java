package com.talmadge.bwt.core.client.ui.widget.gallery.event.left;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 *
 */
public interface HasLeftHandlers 
{
    /**
     * 
     * @param handler LeftHandler
     * @return HandlerRegistration
     */
    HandlerRegistration addLeftHandler (LeftHandler handler);
}
