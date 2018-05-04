package com.talmadge.bwt.core.client.ui.widget.form.event.submit;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * 
 *
 */
public interface HasSubmitHandlers
{
	/**
	 * 
	 * @return HandlerRegistration
	 */
	HandlerRegistration addSubmitHandler (SubmitHandler handler);
}
