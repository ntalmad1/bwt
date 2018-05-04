package com.talmadge.bwt.core.client.ui.widget.form.event.valueinput;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
@SuppressWarnings("rawtypes")
public interface HasValueInputHandlers<T extends FormElement, V>
{
	HandlerRegistration addValueChangeHandler (ValueInputHandler<T, V> handler);
}
