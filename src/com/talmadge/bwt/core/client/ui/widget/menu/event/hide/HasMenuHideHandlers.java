package com.talmadge.bwt.core.client.ui.widget.menu.event.hide;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasMenuHideHandlers
{
	/**
	 * 
	 * @param handler MenuHideHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addMenuHideHandler (MenuHideHandler handler);
}
