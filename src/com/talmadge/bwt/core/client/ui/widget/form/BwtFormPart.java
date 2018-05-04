package com.talmadge.bwt.core.client.ui.widget.form;

import java.util.List;

import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
public interface BwtFormPart
{
	/**
	 * @return List<FormElement<?>>
	 */
	List<FormElement<?>> getFormElements ();
	
	/**
	 * @return String
	 */
	String getName ();
}
