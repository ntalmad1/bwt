package com.talmadge.bwt.core.client.ui.widget.tooltip.trigger;

/**
 * 
 *
 */
public class TooltipTrigger
{
	/**
	 */
	public static final TooltipTrigger CLICK = new TooltipTrigger("click");
	
	/**
	 */
	public static final TooltipTrigger CUSTOM = new TooltipTrigger("custom");
	
	/**
	 */
	public static final TooltipTrigger HOVER = new TooltipTrigger("hover");
	
	
	/**
	 */
	private String trigger;
	
	/**
	 * 
	 * @param trigger String
	 */
	public TooltipTrigger (String trigger)
	{
		this.trigger = trigger;
	}
	
	
	/**
	 * 
	 * @return trigger
	 */
	public String getTrigger ()
	{
		return this.trigger;
	}
}
