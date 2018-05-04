package com.talmadge.bwt.core.client.ui.widget.form.simpleselect;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;

/**
 * 
 * @author Noah
 *
 * @param <T>
 */
public class SmallSimpleSelect<T> extends SimpleSelect<T> 
{
	/**
	 * Constructor
	 * 
	 */
	public SmallSimpleSelect ()
	{
		super();
		this.setSize(FormElementSize.SMALL);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param label String
	 */
	public SmallSimpleSelect (String label)
	{
		this();
		this.setLabel(label);
	}

	
	/**
	 * 
	 * @param name String
	 * @param label String
	 */
	public SmallSimpleSelect (String name, String label)
	{
		this(label);
		this.setName(name);
	}
}
