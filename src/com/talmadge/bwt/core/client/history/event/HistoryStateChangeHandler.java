package com.talmadge.bwt.core.client.history.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 *
 */
public interface HistoryStateChangeHandler extends EventHandler
{
    /**
     * 
     * @param event HistoryStateChangeEvent
     */
    void onHistoryStateChange (HistoryStateChangeEvent event);
}
