package com.talmadge.bwt.core.client.ui.widget.form.valuefield.integer;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.form.event.valueinput.ValueInputEvent;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.ValueField;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.constrainer.ValueFieldConstrainer;

/**
 * 
 *
 */
public class IntegerField extends ValueField<Integer>  
{
	/**
	 */
	public static final String SIGNED_INTEGER_PATTERN = "^(0{1})|(-?([1-9]\\d*)?)$";
	
	/**
	 */
	public static final String UNSIGNED_INTEGER_PATTERN = "^(0{1})|([1-9]\\d*)$";
	
	/**
	 */
	public static final String ALLOWED_CHARS = "0123456789"; 
	
	
	/**
	 */
	private boolean allowNegative = false;	
	
	
	
	/**
	 * 
	 */
	public IntegerField ()
	{
		this((IntegerFieldAppearance) GWT.create(DefaultIntegerFieldAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param label String
	 */
	public IntegerField (String label)
	{
		this();
		this.setLabel(label);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param appearance IntegerFieldAppearance
	 */
	protected IntegerField (IntegerFieldAppearance appearance)
	{
		super(appearance);
		
		this.setMaxLength(19);
		
		this.setValueConstrainer(new ValueFieldConstrainer());
		this.getValueConstrainer().setPattern(UNSIGNED_INTEGER_PATTERN);
		this.getValueConstrainer().setAllowedChars(ALLOWED_CHARS);
		
		this.bindIntegerField();
	}

	/**
	 * 
	 * @return IntegerFieldAppearance
	 */
	public IntegerFieldAppearance getAppearance ()
	{
		return (IntegerFieldAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public Integer getValue ()
	{
		String value = this.trim(this.getAppearance().getValue());
		if (value == null || value.isEmpty())
		{
			return null;
		}
		
		try 
		{
			return new Integer(value);
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isAllowNegative ()
	{
		return this.allowNegative;
	}
	
	
	/**
	 * 
	 * @param allowNegative boolean
	 */
	public void setAllowNegative (boolean allowNegative)
	{
		if (this.isAllowNegative() == allowNegative)
		{
			return;
		}
		
		
		if (allowNegative)
		{
			this.getValueConstrainer().setPattern(SIGNED_INTEGER_PATTERN);
			this.getValueConstrainer().setAllowedChars(ALLOWED_CHARS + "-"); 
		}
		else
		{
			this.getValueConstrainer().setPattern(UNSIGNED_INTEGER_PATTERN);
			this.getValueConstrainer().setAllowedChars(ALLOWED_CHARS);
		}
	}
	

	/**
	 * 
	 */
	protected void bindIntegerField ()
	{
	
	}
	
	
	/**
	 * 
	 */
	protected void checkForValueChange ()
	{
		Integer value = this.getValue();
		
		boolean change = false;
		
		if (((value == null) && (this.getPreviousValue() != null)) 
		|| ((value != null) && !value.equals(this.getPreviousValue())))
		{
			change = true;
		}
		
		if (change)
		{
			ValueInputEvent<IntegerField, Integer> event = new ValueInputEvent<IntegerField, Integer>(this, this.getPreviousValue(), value);
			this.fireEvent(event);
			
			this.setPreviousValue(value);
		}
	}
	

	/**
	 * 
	 * @param value String
	 * @return String
	 */
	private String trim (String value)
	{
		if (value != null)
		{
			return value.trim();
		}
		
		return value;
	}
}