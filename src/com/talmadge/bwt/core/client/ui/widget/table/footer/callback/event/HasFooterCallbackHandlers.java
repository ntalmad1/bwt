package com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 *
 */
public interface HasFooterCallbackHandlers
{
	/**
	 * 
	 * @param handler FooterCallbackHandler
	 * @return HandlerRegistration
	 */
	HandlerRegistration addFooterCallbackHandler (FooterCallbackHandler handler);
}
