package com.talmadge.bwt.core.client.ui.widget.form.event.valuechange;

import com.google.gwt.event.shared.EventHandler;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

@SuppressWarnings("rawtypes")
public interface ValueChangeHandler<T extends FormElement, V> extends EventHandler
{
	/**
	 * 
	 * @param event ValueChangeEvent<T, V> 
	 */
	void onValueChange (ValueChangeEvent<T, V> event);
}
