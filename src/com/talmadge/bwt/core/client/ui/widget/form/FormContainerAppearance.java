package com.talmadge.bwt.core.client.ui.widget.form;

import com.google.gwt.dom.client.FormElement;
import com.talmadge.bwt.core.client.ui.Form.SubmitMethod;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 *
 */
public interface FormContainerAppearance extends BwtWidgetContainerAppearance
{
	/**
	 */
	FormElement getElement ();
	
	/**
	 * @param method SubmitMethod
	 */
	void setSubmitMethod (SubmitMethod method);
}
