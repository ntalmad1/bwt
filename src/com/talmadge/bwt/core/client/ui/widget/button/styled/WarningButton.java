package com.talmadge.bwt.core.client.ui.widget.button.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.Button;



/**
 * 
 * @author Noah
 *
 */
public class WarningButton extends Button 
{
	/**
	 * Constructor
	 */
	public WarningButton ()
	{
		super();
		
		this.setButtonStyle(ButtonStyle.WARNING);
	}


	/**
	 * 
	 * @param text String
	 */
	public WarningButton (String text)
	{
		this();
		
		this.setText(text);
	}
		
}
