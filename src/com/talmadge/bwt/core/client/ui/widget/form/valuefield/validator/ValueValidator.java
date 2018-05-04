package com.talmadge.bwt.core.client.ui.widget.form.valuefield.validator;

/**
 * 
 *
 */
public interface ValueValidator
{
	/**
	 * Return null if valid else return error message why not valid.
	 * 
	 * @param value String
	 * @return String
	 */
	String validate (String label, String value);
}
