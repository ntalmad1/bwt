package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforeshow;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface BeforeTabShowHandler extends EventHandler
{
	/**
	 * 
	 * @param event BeforeTabShowEvent
	 */
	void onBeforeTabShow (BeforeTabShowEvent event);
}
