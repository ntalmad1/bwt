package com.talmadge.bwt.core.client.ui.widget.event.resize;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 *
 */
public interface BwtResizeHandler extends EventHandler
{
    /**
     * 
     * @param event BwtResizeEvent
     */
    void onResize (BwtResizeEvent event);
}
