package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.show;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface TabShowHandler extends EventHandler
{
	/**
	 * 
	 * @param event TabShowEvent
	 */
	void onTabShow (TabShowEvent event);
}
