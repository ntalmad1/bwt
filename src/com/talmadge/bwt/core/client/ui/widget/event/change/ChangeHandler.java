package com.talmadge.bwt.core.client.ui.widget.event.change;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 * 
 * @param <T>
 */
public interface ChangeHandler<T> extends EventHandler
{
	/**
	 * 
	 * @param event ChangeEvent<T>
	 */
	void onChange (ChangeEvent<T> event);
}
