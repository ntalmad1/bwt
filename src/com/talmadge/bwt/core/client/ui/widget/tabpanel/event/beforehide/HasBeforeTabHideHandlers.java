package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforehide;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasBeforeTabHideHandlers
{
	/**
	 * 
	 * @param handler BeforeTabHideHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addBeforeTabHideHandler (BeforeTabHideHandler handler);
}
