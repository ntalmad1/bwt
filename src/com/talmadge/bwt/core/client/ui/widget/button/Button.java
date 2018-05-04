package com.talmadge.bwt.core.client.ui.widget.button;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;
import com.talmadge.bwt.core.client.ui.widget.Disableable;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonSize;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.event.select.HasSelectHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler; 


/**
 * 
 * @author Noah
 *
 */
public class Button extends BwtWidget implements 
	  Disableable
	, HasButtonSize
	, HasButtonStyle
	, HasClickHandlers
	, HasSelectHandlers<Button>
{
	/**
	 */
	private boolean blurOnClick = true;
	
	/**
	 */
	private boolean disabled;
	
	/**
	 */
	private boolean pressed;
	
	/**
	 */
	private String text;



	/**
	 * Constructor
	 *  
	 */
	public Button ()
	{
		this((ButtonAppearance) GWT.create(DefaultButtonAppearance.class));
	}
	
	
	/**
	 * Construcotr
	 * 
	 * @param alignCenter Glyphicon
	 */
	public Button (Glyphicon alignCenter)
	{
		this();
		
		this.setIcon(alignCenter);
	}


	/**
	 * Constructor 
	 *
	 * @param string String
	 */
	public Button (String string)
	{
		this();
		
		this.setText(string);
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param icon Glyphicon
	 * @param text String
	 */
	public Button (Glyphicon icon, String text)
	{
		this(text);
		
		this.setIcon(icon);
	}


	/**
	 * 
	 * @param appearance ButtonAppearance
	 */
	protected Button (ButtonAppearance appearance)
	{
		super(appearance);
		
		this.bind();
	}

	
	/**
	 * 
	 * @param clickHandler ClickHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addClickHandler (ClickHandler clickHandler)
	{
		return this.addHandler(clickHandler, ClickEvent.getType());
	}
	
	
	/**
	 * 
	 * @param selectHandler SelectHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSelectHandler (SelectHandler<Button> selectHandler)
	{
		return this.addHandler(selectHandler, SelectEvent.getType());
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
	 * @return String
	 */
	public String getText ()
	{
		return this.text;
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
	 * @return boolean
	 */
	public boolean isBlurOnClick ()
	{
		return this.blurOnClick;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isPressed ()
	{
		return !this.pressed;
	}
	

	
	/**
	 * 
	 * @param block boolean
	 */
	public void setBlock (boolean block)
	{
		this.getAppearance().setBlock(block);
	}


	/**
	 * 
	 * @param blurOnClick boolean
	 */
	public void setBlurOnClick (boolean blurOnClick)
	{
		this.blurOnClick = blurOnClick;
	}


	/**
	 * 
	 * @param size ButtonSize
	 */
	public void setButtonSize (ButtonSize size)
	{
		this.getAppearance().setButtonSize(size);
	}


	/**
	 * 
	 * @param style ButtonStyle
	 */
	public void setButtonStyle (ButtonStyle style)
	{
		this.getAppearance().setButtonStyle(style);		
	}

	
	/**
	 *
	 * @param centered boolean
	 */
	public void setCentered (boolean centered)
    {
        this.getAppearance().setCentered(centered);        
    }
 

    /**
	 * 
	 * @param disabled boolean
	 */
	public void setDisabled (boolean disabled)
	{
		this.disabled = disabled;
		
		this.getAppearance().setDisabled(disabled);		
	}


	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.getAppearance().setIcon(icon);		
	}


	/**
	 * 
	 * @param iconAlign IconAlign
	 */
	public void setIconAlign (IconAlign iconAlign)
	{
		this.getAppearance().setIconAlign(iconAlign);		
	}

	
	/**
     * 
     * @param pressed boolean
     */
    public void setPressed (boolean pressed)
    {
    	this.pressed = pressed;
    	
    	this.getAppearance().setPressed(pressed);
    }


    /**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.text = text;
		this.getAppearance().setText(text);
	}
	

	/**
	 * 
	 * @return ButtonAppearance
	 */
	protected ButtonAppearance getAppearance ()
	{
		return (ButtonAppearance) super.getAppearance();
	}


	/**
	 * 
	 */
	protected void bind ()
	{
		this.addDomHandler(new ClickHandler()
		{
			public void onClick (ClickEvent event)
			{
				Button.this._click(event);
			}
		}, ClickEvent.getType());
	}
	
	
	/**
	 * 
	 * @param event ClickEvent
	 */
	protected void onClick (ClickEvent event)
	{
		
	}
	
	
	/**
	 * 
	 */
	protected void onLoad ()
	{
		
	}
	
	
	/**
	 * 
	 */
	protected void onUnload ()
	{
		
	}
	
	
	/**
	 * 
	 * @param  event SelectEvent
	 */
	protected void onSelect (SelectEvent<Button> event) 
	{
		
	}
	
	
	/**
	 * 
	 * @param event ClickEvent
	 */
	protected void _click (ClickEvent event)
	{
		this.onClick(event);
		
		SelectEvent<Button> selectEvent = new SelectEvent<Button>(this);

		this.onSelect(selectEvent);
		this.fireEvent(selectEvent);
				
		if (this.isBlurOnClick())
		{
			this.blur();
		}
	}	
}
