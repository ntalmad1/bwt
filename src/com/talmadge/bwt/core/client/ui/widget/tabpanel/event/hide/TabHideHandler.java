package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.hide;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface TabHideHandler extends EventHandler
{
	/**
	 * 
	 * @param event TabHideEvent
	 */
	void onTabHide (TabHideEvent event);
}
