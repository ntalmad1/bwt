package com.talmadge.bwt.core.client.ui.widget.menu.event.hide;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface MenuHideHandler extends EventHandler
{
	/**
	 * 
	 * @param event MenuHideEvent
	 */
	void onMenuHide (MenuHideEvent event);
}
