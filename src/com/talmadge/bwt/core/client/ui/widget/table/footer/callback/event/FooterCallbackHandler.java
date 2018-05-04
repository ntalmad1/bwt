package com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 *
 */
public interface FooterCallbackHandler extends EventHandler
{
	/**
	 * @param event FooterCallbackEvent
	 */
	void onFooterCallback (FooterCallbackEvent event);
}
