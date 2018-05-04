package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class SuccessSplitDropdownButton extends SplitDropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public SuccessSplitDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.SUCCESS);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public SuccessSplitDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
