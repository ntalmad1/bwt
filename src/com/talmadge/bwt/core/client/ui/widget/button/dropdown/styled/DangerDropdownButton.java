package com.talmadge.bwt.core.client.ui.widget.button.dropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class DangerDropdownButton extends DropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public DangerDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.DANGER);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public DangerDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
