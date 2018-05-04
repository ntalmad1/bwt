package com.talmadge.bwt.core.client.ui.widget.button.dropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class DefaultDropdownButton extends DropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.DEFAULT);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public DefaultDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
