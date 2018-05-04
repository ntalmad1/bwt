package com.talmadge.bwt.core.client.ui.widget.button.dropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class WarningDropdownButton extends DropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public WarningDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.WARNING);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public WarningDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
