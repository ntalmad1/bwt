package com.talmadge.bwt.core.client.ui.widget.table.toolbutton;

import com.google.gwt.user.client.Timer;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;

/**
 * 
 *
 */
public class DeleyedSelectTimer extends Timer
{
	/**
	 */
	private SelectEvent<Button> event;
	
	/**
	 */
	private SelectHandler<Button> selectHandler;
	
	
	/**
	 * Constructor
	 * 
	 * @param selectHandler SelectHandler<Button>
	 */
	public DeleyedSelectTimer (SelectHandler<Button> selectHandler)
	{
		super();
		
		this.selectHandler = selectHandler;
	}
	
	
	/**
	 * 
	 * 
	 * @param millis long
	 * @param event
	 */
	public void schedule (int delayMillis, SelectEvent<Button> event)
	{
		this.event = event; 
		
		super.schedule(delayMillis);
	}
	
	
	/**
	 * 
	 */
	public void run () 
	{
		this.selectHandler.onSelect(this.event);
	}
	
};