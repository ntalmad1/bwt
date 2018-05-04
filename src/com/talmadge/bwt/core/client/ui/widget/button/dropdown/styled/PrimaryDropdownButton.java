package com.talmadge.bwt.core.client.ui.widget.button.dropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class PrimaryDropdownButton extends DropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public PrimaryDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.PRIMARY);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public PrimaryDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
