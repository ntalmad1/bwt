package com.talmadge.bwt.core.client.ui.widget.form.valuefield.text;

import com.google.gwt.core.shared.GWT;

/**
 * 
 *
 */
public class PasswordField extends TextField
{
	
	/**
	 * Constructor
	 * 
	 * @param appearance TextFieldAppearance
	 */
	protected PasswordField (PasswordFieldAppearance appearance)
	{
		super(appearance);
	}
	
	/**
	 * 
	 */
	public PasswordField ()
	{
		this((PasswordFieldAppearance) GWT.create(DefaultPasswordFieldAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param label String
	 */
	public PasswordField (String label)
	{
		this();
		this.setLabel(label);
	}
	
	
	/**
	 * 
	 * @return PasswordFieldAppearance
	 */
	public PasswordFieldAppearance getAppearance ()
	{
		return (PasswordFieldAppearance) super.getAppearance();
	}
}