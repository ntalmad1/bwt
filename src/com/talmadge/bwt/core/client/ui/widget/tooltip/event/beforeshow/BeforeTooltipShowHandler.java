package com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 *
 */
public interface BeforeTooltipShowHandler extends EventHandler
{
	/**
	 * 
	 * @param event BeforeTooltipShowEvent
	 */
	void onBeforeTooltipShow (BeforeTooltipShowEvent event);
}
