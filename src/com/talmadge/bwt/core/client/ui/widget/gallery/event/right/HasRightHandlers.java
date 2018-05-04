package com.talmadge.bwt.core.client.ui.widget.gallery.event.right;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 *
 */
public interface HasRightHandlers
{
    /**
     * 
     * @param handler RightHandler
     * @return HandlerRegistration
     */
    HandlerRegistration addRightHandler (RightHandler handler);
}
