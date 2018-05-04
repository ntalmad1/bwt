package com.talmadge.bwt.core.client.ui.widget.event.hide;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 */
public interface HasHideHandlers
{
	/**
	 * 
	 * @param handler HideHandler
	 * @return HandlerRegistration
	 * 
	 * @param <W> extends BwtWidget
	 */
	<W extends BwtWidget> HandlerRegistration addHideHandler (HideHandler<W> handler);
}
