package com.talmadge.bwt.core.client.ui.widget.button.dropdown;

import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Direction;
import com.talmadge.bwt.core.client.ui.widget.button.group.DefaultButtonGroupAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultDropdownButtonAppearance extends DefaultButtonGroupAppearance implements DropdownButtonAppearance
{	
	/**
	 */
	private Button button;
	
	/**
	 */
	private String text;
	
	
	
	/**
	 * 
	 * @return Button
	 */
	public Button getButton ()
	{
		return this.button;
	}


	/**
	 * 
	 * @return String
	 */
	public String getText ()
	{
		return this.text;
	}


	/**
	 * 
	 * @param button Button
	 */
	public void setButton (Button button)
	{
		this.button = button;
		
		this.button.ensureCssName("dropdown-toggle");
		this.button.getElement().setAttribute("data-toggle", "dropdown");
	}


	/**
	 * 
	 * @param direction Direction
	 */
	public void setDirection (Direction direction)
	{
		this.toggleCssName("dropup", (Direction.UP.equals(direction)));
	}


	/**
	 *  
	 * @param text String
	 */
	public void setText (String text)
	{
		this.text = text;
		this.getButton().setText(text + "&nbsp;&nbsp;");
	}


	/**
	 * 
	 */
	protected void build ()
	{
		super.build();
	}
}
