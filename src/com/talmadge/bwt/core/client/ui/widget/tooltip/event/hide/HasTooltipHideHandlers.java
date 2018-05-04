package com.talmadge.bwt.core.client.ui.widget.tooltip.event.hide;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 *
 */
public interface HasTooltipHideHandlers
{
	/**
	 * 
	 * @param handler TooltipHideHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addTooltipHideHandler (TooltipHideHandler handler);
}
