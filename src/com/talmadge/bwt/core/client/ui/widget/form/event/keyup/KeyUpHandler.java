package com.talmadge.bwt.core.client.ui.widget.form.event.keyup;

import com.google.gwt.event.shared.EventHandler;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

@SuppressWarnings("rawtypes")
public interface KeyUpHandler<T extends FormElement> extends EventHandler
{
	/**
	 * 
	 * @param event KeyUpEvent<T> 
	 */
	void onKeyUp (KeyUpEvent<T> event);
}
