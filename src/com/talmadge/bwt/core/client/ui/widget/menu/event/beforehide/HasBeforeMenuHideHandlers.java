package com.talmadge.bwt.core.client.ui.widget.menu.event.beforehide;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasBeforeMenuHideHandlers
{
	/**
	 * 
	 * @param handler BeforeMenuHideHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addBeforeMenuHideHandler (BeforeMenuHideHandler handler);
}
