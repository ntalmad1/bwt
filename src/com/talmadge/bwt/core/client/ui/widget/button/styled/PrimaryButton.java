package com.talmadge.bwt.core.client.ui.widget.button.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.Button;



/**
 * 
 * @author Noah
 *
 */
public class PrimaryButton extends Button 
{
	/**
	 * Constructor
	 */
	public PrimaryButton ()
	{
		super();
		
		this.setButtonStyle(ButtonStyle.PRIMARY);
	}


	/**
	 * 
	 * @param text String
	 */
	public PrimaryButton (String text)
	{
		this();
		
		this.setText(text);
	}
		
}
