package com.talmadge.bwt.core.client.ui.widget.nav.event;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 *
 */
public interface HasItemAddHandlers
{
    /**
     * 
     * @param handler ItemAddHandler
     * @return HandlerRegistration
     */
    HandlerRegistration addItemAddHandler (ItemAddHandler handler);
}
