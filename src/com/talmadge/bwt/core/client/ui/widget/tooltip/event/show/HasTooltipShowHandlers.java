package com.talmadge.bwt.core.client.ui.widget.tooltip.event.show;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 *
 */
public interface HasTooltipShowHandlers
{
	/**
	 * 
	 * @param handler TooltipShowHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addTooltipShowHandler (TooltipShowHandler handler);
}
