package com.talmadge.bwt.core.client.ui.widget.form.valuefield.integer;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;

/**
 * 
 * @author Noah
 *
 */
public class SmallIntegerField extends IntegerField
{
	/**
	 * Constructor
	 *  
	 */
	public SmallIntegerField ()
	{
		super();
		this.setSize(FormElementSize.SMALL);
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param label String
	 */
	public SmallIntegerField (String label)
	{
		this();
		this.setLabel(label);
	}

	
	/**
	 * 
	 * @param name String
	 * @param label String
	 */
	public SmallIntegerField (String name, String label)
	{
		this(label);
		this.setName(name);
	}
}
