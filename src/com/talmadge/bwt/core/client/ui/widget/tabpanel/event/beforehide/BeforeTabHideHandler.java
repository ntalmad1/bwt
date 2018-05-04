package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforehide;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface BeforeTabHideHandler extends EventHandler
{
	/**
	 * 
	 * @param event BeforeTabHideEvent
	 */
	void onBeforeTabHide (BeforeTabHideEvent event);
}
