package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class DefaultSplitDropdownButton extends SplitDropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultSplitDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.DEFAULT);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public DefaultSplitDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
