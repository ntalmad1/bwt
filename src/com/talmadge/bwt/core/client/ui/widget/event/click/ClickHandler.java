package com.talmadge.bwt.core.client.ui.widget.event.click;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 * @author Noah
 *
 * @param <T> source
 */
public interface ClickHandler<T> extends EventHandler
{
	/**
	 * 
	 * @param event SelectEvent
	 */
	void onClick (ClickEvent<T> event);
}
