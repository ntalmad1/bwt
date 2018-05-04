package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.hide;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasTabHideHandlers
{
	/**
	 * 
	 * @param handler TabHideHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addTabHideHandler (TabHideHandler handler);
}
