package com.talmadge.bwt.core.client.ui.widget.form.datetimepicker;

import com.talmadge.bwt.core.client.ui.widget.form.valuefield.text.DefaultTextFieldAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultDateTimePickerAppearance extends DefaultTextFieldAppearance implements DateTimePickerAppearance
{	
	/**
	 * 
	 */
	protected void build ()
	{
		super.build();
		
		this.convertToInputGroup();
		this.getInputGroup().addClassName("date");
	}
}
