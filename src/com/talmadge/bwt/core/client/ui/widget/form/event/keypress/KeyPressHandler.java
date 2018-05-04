package com.talmadge.bwt.core.client.ui.widget.form.event.keypress;

import com.google.gwt.event.shared.EventHandler;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

@SuppressWarnings("rawtypes")
public interface KeyPressHandler<T extends FormElement> extends EventHandler
{
	/**
	 * 
	 * @param event KeyUpEvent<T> 
	 */
	void onKeyPress (KeyPressEvent<T> event);
}
