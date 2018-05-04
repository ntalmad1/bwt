package com.talmadge.bwt.core.client.ui.widget.tabpanel.event.show;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 */
public interface HasTabShowHandlers
{
	/**
	 * 
	 * @param handler TabShowHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addTabShowHandler (TabShowHandler handler);
}
