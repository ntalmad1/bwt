package com.talmadge.bwt.core.client.ui.widget.event.click;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 * @param <T> source
 */
public interface HasClickHandlers<T>
{
	/**
	 * 
	 * @param handler ClickHandler<T>
	 * @return HandlerRegistration
	 */
	HandlerRegistration addClickHandler (ClickHandler<T> handler);
}
