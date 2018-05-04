package com.talmadge.bwt.core.client.ui.widget.form.fieldset;

import com.talmadge.bwt.core.client.ui.widget.form.BwtFormAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface FieldSetAppearance extends BwtFormAppearance
{
	/**
	 * 
	 * @param label String
	 */
	void setLabel (String label);

	/**
	 * 
	 * @return String
	 */
	String getLabel ();
}
