package com.talmadge.bwt.core.client.ui.widget.button.toolbar;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.Disableable;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonSize;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;

/**
 * 
 * @author Noah
 *
 */
public class ButtonToolbar extends BwtComposite implements 
	  Disableable
	, HasButtonSize
	, HasButtonStyle
{
	/**
	 */
	private ButtonToolbarCell cell;
	
	
	/**
	 * Constructor 
	 * 
	 */
	public ButtonToolbar ()
	{
		super();
		
		this.cell = new ButtonToolbarCell();
		
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
	 * @param buttonGroup ButtonGroup
	 */
	public void add (ButtonGroup buttonGroup)
    {
	    this.cell.add(buttonGroup);	    
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
	 * @param buttonGroup Button
	 * @return boolean true if the button exists
	 */
	public boolean remove (ButtonGroup buttonGroup)
    {
	    return this.cell.remove(buttonGroup);	    
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
	 * @return ButtonToolbarCell
	 */
	protected ButtonToolbarCell getCell ()
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
