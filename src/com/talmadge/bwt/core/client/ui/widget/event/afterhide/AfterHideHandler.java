package com.talmadge.bwt.core.client.ui.widget.event.afterhide;

import com.google.gwt.event.shared.EventHandler;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;


/**
 * 
 * @author Noah
 * 
 * @param <W> extends BwtWidget
 */
public interface AfterHideHandler<W extends BwtWidget> extends EventHandler
{
	/**
	 * 
	 * @param event AfterHideEvent<W>
	 */
	void onAfterHide (AfterHideEvent<W> event);
}
