package com.talmadge.bwt.core.client.ui.widget.form.datepartfield;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;

/**
 * 
 * @author Noah
 *
 */
public class SmallDatePartField extends DatePartField
{
	/**
	 * 
	 * @param label String
	 */
	public SmallDatePartField (String label)
	{
		super(label);
		
		this.setSize(FormElementSize.SMALL);
	}

	
	/**
	 * 
	 * @param name String
	 * @param label String
	 */
	public SmallDatePartField (String name, String label)
	{
		super(name, label);
		
		this.setSize(FormElementSize.SMALL);
	}
}
