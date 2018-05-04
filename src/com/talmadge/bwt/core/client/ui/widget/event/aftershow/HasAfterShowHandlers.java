package com.talmadge.bwt.core.client.ui.widget.event.aftershow;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * @author Noah
 *
 */
public interface HasAfterShowHandlers
{
	/**
	 * 
	 * @param handler ShowHandler
	 * @return ShowRegistration
	 * 
	 * @param <W> extends BwtWidget
	 */
	<W extends BwtWidget> HandlerRegistration addAfterShowHandler (AfterShowHandler<W> handler);
}
