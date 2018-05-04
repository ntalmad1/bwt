package com.talmadge.bwt.core.client.ui.widget.form.event.keyup;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
@SuppressWarnings("rawtypes")
public interface HasKeyUpHandlers<T extends FormElement>
{
	HandlerRegistration addKeyUpHandler (KeyUpHandler<T> handler);
}
