package com.talmadge.bwt.core.client.ui.widget.event.select;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 * @author Noah
 *
 * @param <T> source
 */
public interface HasSelectHandlers<T>
{
	/**
	 * 
	 * @param handler SelectHandler<T>
	 * @return HandlerRegistration
	 */
	HandlerRegistration addSelectHandler (SelectHandler<T> handler);
}
