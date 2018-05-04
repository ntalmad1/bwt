package com.talmadge.bwt.core.client.ui.widget.button.styled;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.button.Button;



/**
 * 
 * @author Noah
 *
 */
public class LinkButton extends Button 
{
	/**
	 * Constructor
	 */
	public LinkButton ()
	{
		super();
		
		this.setButtonStyle(ButtonStyle.LINK);
	}


	/**
	 * 
	 * @param text String
	 */
	public LinkButton (String text)
	{
		this();
		
		this.setText(text);
	}
	
	
	/**
	 *  
	 * @param icon Glyphicon
	 */
    public LinkButton (Glyphicon icon)
    {
        this();
        this.setIcon(icon);
    }
		
}
