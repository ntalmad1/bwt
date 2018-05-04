package com.talmadge.bwt.core.client.ui.widget.form.valuefield.email;

import com.talmadge.bwt.core.client.ui.widget.form.valuefield.text.DefaultTextFieldAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultEmailFieldAppearance extends DefaultTextFieldAppearance implements EmailFieldAppearance
{
	/**
	 * 
	 */
	protected void build () 
	{
		super.build();
		
		this.getInputElement().setAttribute("type", "email");
	}
}
