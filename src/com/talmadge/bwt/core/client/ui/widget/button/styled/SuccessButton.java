package com.talmadge.bwt.core.client.ui.widget.button.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.Button;



/**
 * 
 * @author Noah
 *
 */
public class SuccessButton extends Button 
{
	/**
	 * Constructor
	 */
	public SuccessButton ()
	{
		super();
		
		this.setButtonStyle(ButtonStyle.SUCCESS);
	}


	/**
	 * 
	 * @param text String
	 */
	public SuccessButton (String text)
	{
		this();
		
		this.setText(text);
	}
		
}
