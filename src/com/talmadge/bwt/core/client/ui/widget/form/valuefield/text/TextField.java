package com.talmadge.bwt.core.client.ui.widget.form.valuefield.text;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.form.event.valueinput.ValueInputEvent;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.ValueField;

/**
 * 
 *
 */
public class TextField extends ValueField<String> 
{
	
	/**
	 * Constructor
	 * 
	 * @param appearance TextFieldAppearance
	 */
	protected TextField (TextFieldAppearance appearance)
	{
		super(appearance);
		
		this.bindTextField();
	}
	
	/**
	 * 
	 */
	public TextField ()
	{
		this((TextFieldAppearance) GWT.create(DefaultTextFieldAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param label String
	 */
	public TextField (String label)
	{
		this();
		this.setLabel(label);
	}
	
	
	/**
	 * 
	 * @return TextFieldAppearance
	 */
	public TextFieldAppearance getAppearance ()
	{
		return (TextFieldAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getValue ()
	{
		return this.trim(this.getAppearance().getValue());
	}
	

	/**
	 * 
	 */
	protected void bindTextField ()
	{
	
	}
	
	
	/**
	 * 
	 */
	protected void checkForValueChange ()
	{
		String value = this.getValue();
		
		boolean change = false;
		
		if (((value == null) && (this.getPreviousValue() != null)) 
		|| ((value != null) && !value.equals(this.getPreviousValue())))
		{
			change = true;
		}
		
		if (change)
		{
			this.clearState();
			
			ValueInputEvent<TextField, String> event = new ValueInputEvent<TextField, String>(this, this.getPreviousValue(), value);
			this.fireEvent(event);
			
			this.setPreviousValue(value);
		}
	}

	
	/**
	 * 
	 * @param value String
	 * @return String
	 */
	protected String trim (String value)
	{
		if (value != null)
		{
			return value.trim();
		}
		
		return value;
	}
}