package com.talmadge.bwt.core.client.ui.widget.button.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.Button;



/**
 * 
 * @author Noah
 *
 */
public class DangerButton extends Button 
{
	/**
	 * Constructor
	 */
	public DangerButton ()
	{
		super();
		
		this.setButtonStyle(ButtonStyle.DANGER);
	}


	/**
	 * 
	 * @param text String
	 */
	public DangerButton (String text)
	{
		this();
		
		this.setText(text);
	}
		
}
