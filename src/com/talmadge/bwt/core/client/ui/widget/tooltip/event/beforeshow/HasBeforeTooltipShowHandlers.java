package com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 *
 */
public interface HasBeforeTooltipShowHandlers
{
	/**
	 * 
	 * @param handler BeforeShowTooltipHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addBeforeTooltipShowHandler (BeforeTooltipShowHandler handler);
}
