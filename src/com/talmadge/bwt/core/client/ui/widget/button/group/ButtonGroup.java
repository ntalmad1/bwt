package com.talmadge.bwt.core.client.ui.widget.button.group;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.Disableable;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonSize;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;

/**
 * 
 * @author Noah
 *
 */
public class ButtonGroup extends BwtComposite implements 
	  Disableable
	, HasButtonSize
	, HasButtonStyle
{
	/**
	 */
	private ButtonGroupCell cell;
	
	
	/**
	 * Constructor 
	 * 
	 */
	public ButtonGroup ()
	{
		super();
		
		this.cell = new ButtonGroupCell();
		
		this.initWidget(cell);
	}
	
	
	/**
	 * 
	 * @param button Button
	 */
	public void add (Button button)
    {
	    this.cell.add(button);	    
    }
	
	
	/**
	 * 
	 * @param dropdownButton DropdownButton
	 */
	public void add (DropdownButton dropdownButton) 
	{
		this.cell.add(dropdownButton);	 
	}

	
	/**
	 * 
	 */
	public void disable ()
	{
		this.setDisabled(true);
	}


	/**
	 * 
	 */
	public void enable ()
	{
		this.setDisabled(false);
	}


	/**
	 * 
	 * @param button Button
	 * @return boolean true if the button exists
	 */
	public boolean remove (Button button)
    {
	    return this.cell.remove(button);	    
    }
	
	
	/**
	 * 
	 * @param dropdownBbutton DropdownButton
	 * @return boolean true if the button exists
	 */
	public boolean remove (DropdownButton dropdownBbutton)
    {
	    return this.cell.remove(dropdownBbutton);	    
    }

	
	/**
	 * 
	 * @param isBlock boolean 
	 */
	public void setBlock (boolean isBlock)
	{
		this.getCell().setBlock(isBlock);
	}


	/**
	 * 
	 * @param size ButtonSize
	 */
	public void setButtonSize (ButtonSize size)
	{
		this.getCell().setButtonSize(size);
		
	}


	/**
	 * 
	 * @param style ButtonStyle
	 */
	public void setButtonStyle (ButtonStyle style)
	{
		this.getCell().setButtonStyle(style);		
	}


	/**
	 * 
	 * @param isDisabled boolean
	 */
	public void setDisabled (boolean isDisabled)
	{
		this.getCell().setDisabled(isDisabled);		
	}
	
	
	/**
	 * 
	 * @param isVertical boolean
	 */
	public void setVertical (boolean isVertical)
	{
		this.getCell().setVertical(isVertical);		
	}
	
	
	/**
	 * 
	 * @return ButtonGroupCell
	 */
	protected ButtonGroupCell getCell ()
	{
		return this.cell;
	}


	/**
	 * 
	 * @param button Button
	 */
	protected void _add (Button button)
	{
		this.getCell()._add(button);
	}
	
	
	/**
	 * 
	 * @param button Button
	 */
	protected void _remove (Button button)
	{
		this.getCell()._remove(button);
	}
}
