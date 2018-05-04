package com.talmadge.bwt.core.client.ui.widget.tooltip.event.show;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 *
 */
public interface TooltipShowHandler extends EventHandler
{
	/**
	 * 
	 * @param event TooltipShowEvent
	 */
	void onTooltipShow (TooltipShowEvent event);
}
