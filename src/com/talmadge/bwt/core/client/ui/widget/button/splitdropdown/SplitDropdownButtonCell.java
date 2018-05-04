package com.talmadge.bwt.core.client.ui.widget.button.splitdropdown;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.Timer;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Mode;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButtonCell;

/**
 * 
 * @author Noah
 *
 */
public class SplitDropdownButtonCell extends DropdownButtonCell
{
	/**
	 * 
	 */
	private Button textButton;
	
	/**
	 * 
	 */
	public SplitDropdownButtonCell ()
	{
		super();
		
		this.bindTextButton();
	}
	
	
	/**
	 * 
	 * @return Button
	 */
	public Button getMainButton ()
	{
		return this.textButton;
	}

	
	/**
	 * 
	 * @return Button
	 */
	public Button getSideButton ()
	{
		return super.getButton();
	}


	/**
	 * 
	 * @return String
	 */
	public String getText ()
	{
		return this.textButton.getText();
	}
	
	
	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.textButton.setText(text);
	}
	
	
	/**
	 * 
	 */
	protected void bindButton ()
	{
		final Timer collapseTimer = new Timer()
		{
			public void run ()
			{
				SplitDropdownButtonCell.this.collapse();
				
			}
		};
		
		this.getSideButton().addDomHandler(new MouseOverHandler()
		{
			public void onMouseOver (MouseOverEvent event)
			{
				if (DropdownButton.Mode.HOVER.equals(SplitDropdownButtonCell.this.getMode()))
				{
					collapseTimer.cancel();
					SplitDropdownButtonCell.this.expand();
				}
			}
			
		}, MouseOverEvent.getType());
		
		
		this.addDomHandler(new MouseOutHandler()
		{
			public void onMouseOut (MouseOutEvent event)
			{
				if (DropdownButton.Mode.HOVER.equals(SplitDropdownButtonCell.this.getMode()))
				{
					collapseTimer.schedule(250);
				}
			}
			
		}, MouseOutEvent.getType());
		
		this.getMenu().addDomHandler(new MouseOverHandler()
		{
			public void onMouseOver (MouseOverEvent event)
			{
				if (DropdownButton.Mode.HOVER.equals(SplitDropdownButtonCell.this.getMode()))
				{
					collapseTimer.cancel();
					SplitDropdownButtonCell.this.expand();
				}
			}
			
		}, MouseOverEvent.getType());
		
	}
	

	/**
	 * 
	 */
	protected void bindTextButton ()
	{
		this.textButton.addDomHandler(new MouseOverHandler()
		{
			public void onMouseOver (MouseOverEvent event)
			{
				if (Mode.HOVER.equals(SplitDropdownButtonCell.this.getMode()))
				{
					SplitDropdownButtonCell.this.collapse();
				}
			}
		}, MouseOverEvent.getType());
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.textButton = new Button();
		this._add(this.textButton);
		
		super.build();
	}
}
