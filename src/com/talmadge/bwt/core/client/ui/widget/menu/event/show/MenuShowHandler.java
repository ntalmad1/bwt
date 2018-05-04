package com.talmadge.bwt.core.client.ui.widget.menu.event.show;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface MenuShowHandler extends EventHandler
{
	/**
	 * 
	 * @param event MenuShowEvent
	 */
	void onMenuShow (MenuShowEvent event);
}
