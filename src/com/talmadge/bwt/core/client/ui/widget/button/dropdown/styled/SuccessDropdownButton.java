package com.talmadge.bwt.core.client.ui.widget.button.dropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class SuccessDropdownButton extends DropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public SuccessDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.SUCCESS);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public SuccessDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
