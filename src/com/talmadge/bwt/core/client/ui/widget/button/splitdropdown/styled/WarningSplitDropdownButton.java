package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class WarningSplitDropdownButton extends SplitDropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public WarningSplitDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.WARNING);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public WarningSplitDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
