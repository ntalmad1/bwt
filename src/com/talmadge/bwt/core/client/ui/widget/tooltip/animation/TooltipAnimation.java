package com.talmadge.bwt.core.client.ui.widget.tooltip.animation;

/**
 * 
 *
 */
public class TooltipAnimation
{
	/**
	 */
	public static final TooltipAnimation FADE = new TooltipAnimation("fade");
	
	/**
	 */
	public static final TooltipAnimation FALL = new TooltipAnimation("fall");
	
	/**
	 */
	public static final TooltipAnimation GROW = new TooltipAnimation("grow");
	
	/**
	 */
	public static final TooltipAnimation SLIDE = new TooltipAnimation("slide");
	
	/**
	 */
	public static final TooltipAnimation SWING = new TooltipAnimation("swing");
	
	
	
	/**
	 */
	private String label;
	
	
	/**
	 * Constructor 
	 * 
	 * @param label String
	 */
	public TooltipAnimation (String label)
	{
		this.label = label;
	}
	
	
	/**
	 * 
	 * @return string
	 */
	public String  toString ()
	{
		return this.label;
	}
}
