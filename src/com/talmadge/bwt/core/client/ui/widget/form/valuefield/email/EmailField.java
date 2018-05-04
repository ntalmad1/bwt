package com.talmadge.bwt.core.client.ui.widget.form.valuefield.email;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.text.TextField;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.validator.EmailValidator;

/**
 * 
 * @author Noah
 *
 */
public class EmailField extends TextField
{
	/**
	 * Constructor
	 * 
	 * @param appearance EmailFieldAppearance
	 */
	protected EmailField (EmailFieldAppearance appearance)
	{
		super(appearance);
		
		this.addValidator(new EmailValidator());
	}
	

	/**
	 * Constructor
	 * 
	 */
	public EmailField ()
	{
		this((EmailFieldAppearance) GWT.create(DefaultEmailFieldAppearance.class));
	}

	
	/**
	 * Constructor
	 * 
	 * @param label String
	 */
	public EmailField (String label)
	{
		this();
		this.setLabel(label);
	}
}
