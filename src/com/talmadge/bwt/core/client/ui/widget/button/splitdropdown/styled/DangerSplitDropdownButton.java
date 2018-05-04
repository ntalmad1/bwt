package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class DangerSplitDropdownButton extends SplitDropdownButton
{
	/**
	 * Constructor
	 * 
	 */
	public DangerSplitDropdownButton ()
	{
		super();
		
		this.setStyle(ButtonStyle.DANGER);
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public DangerSplitDropdownButton (String text)
	{
		this();
		this.setText(text); 
	}
}
