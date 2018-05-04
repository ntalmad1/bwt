package com.talmadge.bwt.core.client.ui.widget.table.toolbutton;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.styled.LinkButton;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;

/**
 * 
 *
 */
public class TableToolButton extends LinkButton
{
	/**
	 * Constructor
	 * 
	 * @param icon Glyphicon
	 * @param selectHandler SelectHandler<Button> 
	 */
	public TableToolButton (Glyphicon icon)
	{
		super(icon);
		
		this.setButtonSize(ButtonSize.XSMALL);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param icon Glyphicon
	 * @param selectHandler SelectHandler<Button>
	 */
	public TableToolButton (Glyphicon icon, SelectHandler<Button> selectHandler)
	{
		this(icon);
		
		this.addSelectHandler(selectHandler);
	}
	
	
	/**
	 * 
	 * @param selectHandler SelectHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSelectHandler (final SelectHandler<Button> selectHandler)
	{
		SelectHandler<Button> wrapper = new SelectHandler<Button>(){
			
			private DeleyedSelectTimer timer = new DeleyedSelectTimer(selectHandler);
			
			public void onSelect (SelectEvent<Button> event)
			{
				this.timer.schedule(50, event);
			}
		};
		
		return this.addHandler(wrapper, SelectEvent.getType());
	}
}
