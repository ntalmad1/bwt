package com.talmadge.bwt.core.client.ui.widget.form.datetimepicker;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;

/**
 * 
 * @author Noah
 *
 */
public class SmallDateTimePicker extends DateTimePicker
{
	/**
	 * Constructor
	 *  
	 */
	public SmallDateTimePicker ()
	{
		super();
		this.setSize(FormElementSize.SMALL); 
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param label String
	 */
	public SmallDateTimePicker (String label)
	{
		this();
		this.setLabel(label);
	}
}
