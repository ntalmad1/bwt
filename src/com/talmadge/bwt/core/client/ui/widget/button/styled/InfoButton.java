package com.talmadge.bwt.core.client.ui.widget.button.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.Button;



/**
 * 
 * @author Noah
 *
 */
public class InfoButton extends Button 
{
	/**
	 * Constructor
	 */
	public InfoButton ()
	{
		super();
		
		this.setButtonStyle(ButtonStyle.INFO);
	}


	/**
	 * 
	 * @param text String
	 */
	public InfoButton (String text)
	{
		this();
		
		this.setText(text);
	}
		
}
