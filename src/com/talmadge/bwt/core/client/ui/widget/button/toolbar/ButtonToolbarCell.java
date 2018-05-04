package com.talmadge.bwt.core.client.ui.widget.button.toolbar;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.Disableable;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonSize;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 * @author Noah
 *
 */
public class ButtonToolbarCell extends BwtWidgetContainer
{
	/**
	 */
	private ButtonSize buttonSize = ButtonSize.NORMAL;
	
	/**
	 */
	private ButtonStyle buttonStyle = ButtonStyle.DEFAULT;

	/**
	 */
	private boolean disabled;
	
	/**
	 */
	private Map<Button, ButtonToolbar> individualButtons;
	
	
	
	/**
	 * Constructor 
	 * 
	 */
	public ButtonToolbarCell ()
	{
		this((ButtonToolbarAppearance) GWT.create(DefaultButtonToolbarCellAppearance.class));
		
		
	}
	
	
	/**
	 * 
	 * @param appearance ButtonToolbarAppearance
	 */
	protected ButtonToolbarCell (ButtonToolbarAppearance appearance)
	{	
		super(appearance);
		
		this.individualButtons = new HashMap<Button, ButtonToolbar>();
		
		this.bind();
	}


	/**
	 * 
	 * @param button Button
	 */
	public void add (Button button)
	{
		ButtonToolbar wrapper = new ButtonToolbar();
		
		wrapper.setButtonStyle(this.buttonStyle);
		wrapper.setButtonSize(this.buttonSize);
		
		if (this.disabled)
	    {
	    	wrapper.setDisabled(this.disabled);
	    }
		
		wrapper._add(button);
		
		super.add(wrapper);
		
		
		this.individualButtons.put(button, wrapper);
	}
	
	
	/**
	 * 
	 * @param buttonGroup Button
	 */
	public void add (ButtonGroup buttonGroup)
	{
		buttonGroup.setButtonStyle(this.buttonStyle);
		buttonGroup.setButtonSize(this.buttonSize);
		
		if (this.disabled)
	    {
			buttonGroup.setDisabled(this.disabled);
	    }
		
		super.add(buttonGroup);
	}


	/**
	 * 
	 * @return ButtonToolbarAppearance
	 */
	public ButtonToolbarAppearance getAppearance ()
	{
		return (ButtonToolbarAppearance) super.getAppearance();
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
	 * @return boolean
	 */
	public boolean isActive ()
	{
		return !this.disabled;
	}
	
	
	/**
	 * 
	 * @param button Button
	 * @return boolean true if the button exists
	 */
	public boolean remove (Button button)
    {
		if (this.individualButtons.containsKey(button))
		{
			return super.remove(this.individualButtons.get(button));
		}
		
		return false;
    }
	
	
	/**
	 * 
	 * @param buttonGroup Button
	 * @return boolean true if the button exists
	 */
	public boolean remove (ButtonGroup buttonGroup)
    {
		return super.remove(buttonGroup);		
    }
	
	
	/**
	 * 
	 * @param size ButtonSize
	 */
	public void setButtonSize (ButtonSize size)
	{
		this.buttonSize = size;
		
		for (Widget child : this.getChildren())
		{
			if (child instanceof HasButtonSize)
			{
				((HasButtonSize) child).setButtonSize(size);
			}
		}
	}
	
	
	/**
	 * 
	 * @param disabled boolean
	 */
	public void setDisabled (boolean disabled)
	{
		this.disabled = disabled;
		
		for (Widget child : this.getChildren())
		{
			if (child instanceof Disableable)
			{
				((Disableable) child).setDisabled(disabled);
			}
		}
	}
	
	
	/**
	 * 
	 * @param style ButtonStyle
	 */
	public void setButtonStyle (ButtonStyle style)
	{
		this.buttonStyle = style;
		
		for (Widget child : this.getChildren())
		{
			if (child instanceof HasButtonStyle)
			{
				((HasButtonStyle) child).setButtonStyle(style);
			}
		}
	}


	/**
	 * 
	 */
	protected void bind ()
	{
	    	    
	}

	
	/**
	 * 
	 * @param button Button
	 */
	protected void _add (Button button)
	{
	    super.add(button);	 
	    
	    button.setButtonStyle(this.buttonStyle);
	    button.setButtonSize(this.buttonSize);
	    
	    if (this.disabled)
	    {
	    	button.setDisabled(this.disabled);
	    }
	}

	/**
	 * 
	 * @param button Button
	 * @return booelan
	 */
	protected boolean _remove (Button button) 
	{
		return super.remove(button);
	}
}
