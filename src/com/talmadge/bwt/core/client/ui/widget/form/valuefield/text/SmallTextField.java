package com.talmadge.bwt.core.client.ui.widget.form.valuefield.text;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;

/**
 * 
 * @author Noah
 *
 */
public class SmallTextField extends TextField
{
	/**
	 * Constructor
	 *  
	 */
	public SmallTextField ()
	{
		super();
		this.setSize(FormElementSize.SMALL);
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param label String
	 */
	public SmallTextField (String label)
	{
		this();
		this.setLabel(label);
	}

	
	/**
	 * 
	 * @param name String
	 * @param label String
	 */
	public SmallTextField (String name, String label)
	{
		this(label);
		this.setName(name);
	}
}
