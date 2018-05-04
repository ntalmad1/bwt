package com.talmadge.bwt.core.client.ui.widget.form.event.keypress;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
@SuppressWarnings("rawtypes")
public interface HasKeyPressHandlers<T extends FormElement>
{
	HandlerRegistration addKeyPressHandler (KeyPressHandler<T> handler);
}
