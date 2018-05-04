package com.talmadge.bwt.core.client.ui.widget.event.change;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 * @param <T> source
 */
public interface HasChangeHandlers<T>
{
	/**
	 * 
	 * @param handler ChangeHandler<T>
	 * @return HandlerRegistration
	 */
	HandlerRegistration addChangeHandler (ChangeHandler<T> handler);
}
