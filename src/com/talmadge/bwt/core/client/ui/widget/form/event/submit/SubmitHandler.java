package com.talmadge.bwt.core.client.ui.widget.form.event.submit;

import com.google.gwt.event.shared.EventHandler;

/**
 * 
 *
 */
public interface SubmitHandler extends EventHandler
{
	/**
	 * 
	 * @param event SubmitEvent
	 */
	void onSubmit (SubmitEvent event);
}
