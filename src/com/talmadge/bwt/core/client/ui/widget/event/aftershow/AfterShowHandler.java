package com.talmadge.bwt.core.client.ui.widget.event.aftershow;

import com.google.gwt.event.shared.EventHandler;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;


/**
 * @author Noah
 * 
 * @param <W> extends BwtWidget
 */
public interface AfterShowHandler<W extends BwtWidget> extends EventHandler
{
	/**
	 * 
	 * @param event AfterShowEvent<W>
	 */
	void onAfterShow (AfterShowEvent<W> event);
}
