package com.talmadge.bwt.core.client.ui.widget.event.hide;

import com.google.gwt.event.shared.EventHandler;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;


/**
 * 
 * @author Noah
 * 
 * @param <W> extends BwtWidget
 */
public interface HideHandler<W extends BwtWidget> extends EventHandler
{
	/**
	 * 
	 * @param event HideEvent<W>
	 */
	void onHide (HideEvent<W> event);
}
