package com.talmadge.bwt.core.client.ui.widget.event.show;

import com.google.gwt.event.shared.EventHandler;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;


/**
 * @author Noah
 * 
 * @param <W> extends BwtWidget
 */
public interface ShowHandler<W extends BwtWidget> extends EventHandler
{
	/**
	 * 
	 * @param event ShowEvent<W>
	 */
	void onShow (ShowEvent<W> event);
}
