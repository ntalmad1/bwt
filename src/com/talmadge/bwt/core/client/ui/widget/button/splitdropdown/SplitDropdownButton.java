package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown;

import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;

/**
 * 
 * @author Noah
 *
 */
public class SplitDropdownButton extends DropdownButton 
{
	/**
	 * Constructor
	 * 
	 */
	public SplitDropdownButton ()
	{
		super(new SplitDropdownButtonCell()); 
	}
	
	/**
	 * 
	 * @param text String
	 */
	public SplitDropdownButton (String text)
	{
		this();
		this.setText(text);
	}
	
	/**
	 * 
	 * @return Button
	 */
	public Button getMainButton ()
	{
		return this.getCell().getMainButton();
	}
	
	
	/**
	 * 
	 * @return Button
	 */
	public Button getSideButton ()
	{
		return this.getCell().getSideButton();
	}
	
	
	/**
	 * 
	 * @return SplitDropdownButtonCell
	 */
	protected SplitDropdownButtonCell getCell ()
	{
		return (SplitDropdownButtonCell) super.getCell();
	}
}
