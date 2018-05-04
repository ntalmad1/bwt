package com.talmadge.bwt.core.client.ui.widget.menu.event.beforeshow;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasBeforeMenuShowHandlers
{
	/**
	 * 
	 * @param handler BeforeMenuHideHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addBeforeMenuShowHandler (BeforeMenuShowHandler handler);
}
