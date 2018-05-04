package com.talmadge.bwt.core.client.ui.widget.button.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.Button;



/**
 * 
 * @author Noah
 *
 */
public class DefaultButton extends Button 
{
	/**
	 * Constructor
	 */
	public DefaultButton ()
	{
		super();
		
		this.setButtonStyle(ButtonStyle.DEFAULT);
	}


	/**
	 * 
	 * @param text String
	 */
	public DefaultButton (String text)
	{
		this();
		
		this.setText(text);
	}
		
}
