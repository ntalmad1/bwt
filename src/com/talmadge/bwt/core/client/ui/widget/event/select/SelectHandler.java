package com.talmadge.bwt.core.client.ui.widget.event.select;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 * @param <T> source
 */
public interface SelectHandler<T> extends EventHandler
{
	/**
	 * 
	 * @param event SelectEvent
	 */
	void onSelect (SelectEvent<T> event);
}
