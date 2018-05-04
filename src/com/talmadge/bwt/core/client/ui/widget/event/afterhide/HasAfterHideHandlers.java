package com.talmadge.bwt.core.client.ui.widget.event.afterhide;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 */
public interface HasAfterHideHandlers
{
	/**
	 * 
	 * @param handler HideHandler
	 * @return HandlerRegistration
	 * 
	 * @param <W> extends BwtWidget
	 */
	<W extends BwtWidget> HandlerRegistration addAfterHideHandler (AfterHideHandler<W> handler);
}
