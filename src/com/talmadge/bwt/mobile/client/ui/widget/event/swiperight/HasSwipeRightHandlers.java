package com.talmadge.bwt.mobile.client.ui.widget.event.swiperight;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 *
 */
public interface HasSwipeRightHandlers
{
	/**
	 * 
	 * @param handler SwipeRightHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSwipeRightHandler (SwipeRightHandler handler);
}
