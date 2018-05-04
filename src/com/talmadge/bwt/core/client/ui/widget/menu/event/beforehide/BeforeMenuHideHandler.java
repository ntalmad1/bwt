package com.talmadge.bwt.core.client.ui.widget.menu.event.beforehide;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 */
public interface BeforeMenuHideHandler extends EventHandler
{
	/**
	 * 
	 * @param event BeforeMenuHideEvent
	 */
	void onBeforeMenuHide (BeforeMenuHideEvent event);
}
