package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class InfoSplitDropdownButton extends SplitDropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public InfoSplitDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.DEFAULT);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public InfoSplitDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
