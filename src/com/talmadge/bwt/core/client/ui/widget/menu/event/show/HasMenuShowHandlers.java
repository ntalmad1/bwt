package com.talmadge.bwt.core.client.ui.widget.menu.event.show;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasMenuShowHandlers
{
	/**
	 * 
	 * @param handler MenuShowHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addMenuShowHandler (MenuShowHandler handler);
}
