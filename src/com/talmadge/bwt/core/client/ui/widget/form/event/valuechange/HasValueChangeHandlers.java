package com.talmadge.bwt.core.client.ui.widget.form.event.valuechange;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
@SuppressWarnings("rawtypes")
public interface HasValueChangeHandlers<T extends FormElement, V>
{
	HandlerRegistration addValueChangeHandler (ValueChangeHandler<T, V> handler);
}
