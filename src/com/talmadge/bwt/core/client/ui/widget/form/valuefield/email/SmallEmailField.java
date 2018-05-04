package com.talmadge.bwt.core.client.ui.widget.form.valuefield.email;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;

/**
 * 
 * @author Noah
 *
 */
public class SmallEmailField extends EmailField
{
	/**
	 * Constructor
	 *  
	 */
	public SmallEmailField ()
	{
		super();
		this.setSize(FormElementSize.SMALL);
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param label String
	 */
	public SmallEmailField (String label)
	{
		this();
		this.setLabel(label);
	}
	
	
	/**
	 * Constructor
	 * @param name String
	 * @param label String
	 */
	public SmallEmailField (String name, String label)
	{
		this(label);
		this.setName(name);
	}
}
