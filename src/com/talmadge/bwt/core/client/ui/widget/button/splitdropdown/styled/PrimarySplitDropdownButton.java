package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class PrimarySplitDropdownButton extends SplitDropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public PrimarySplitDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.PRIMARY);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public PrimarySplitDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
