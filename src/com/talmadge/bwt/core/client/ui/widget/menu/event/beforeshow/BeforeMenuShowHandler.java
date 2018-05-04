package com.talmadge.bwt.core.client.ui.widget.menu.event.beforeshow;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface BeforeMenuShowHandler extends EventHandler
{
	/**
	 * 
	 * @param event BeforeMenuShowEvent
	 */
	void onBeforeMenuShow (BeforeMenuShowEvent event);
}
