package com.talmadge.bwt.core.client.ui.widget.event.show;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * @author Noah
 *
 */
public interface HasShowHandlers
{
	/**
	 * 
	 * @param handler ShowHandler
	 * @return ShowRegistration
	 * 
	 * @param <W> extends BwtWidget
	 */
	<W extends BwtWidget> HandlerRegistration addShowHandler (ShowHandler<W> handler);
}
