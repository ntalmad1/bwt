package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforeshow;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasBeforeTabShowHandlers
{
	/**
	 * 
	 * @param handler BeforeTabShowHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addBeforeTabShowHandler (BeforeTabShowHandler handler);
}
