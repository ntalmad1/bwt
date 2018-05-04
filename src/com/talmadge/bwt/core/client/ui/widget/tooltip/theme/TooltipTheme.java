package com.talmadge.bwt.core.client.ui.widget.tooltip.theme;

import com.talmadge.bwt.core.client.ui.util.label.DefaultLabelProvider;

/**
 * 
 *
 */
public class TooltipTheme extends DefaultLabelProvider
{
	/**
	 */
	public static final TooltipTheme BORDERLESS = new TooltipTheme("tooltipster-borderless");

	/**
	 */
	public static final TooltipTheme DEFAULT = new TooltipTheme("tooltipster-default");
	
	/**
	 */
	public static final TooltipTheme LIGHT = new TooltipTheme("tooltipster-light");
	
	/**
	 */
	public static final TooltipTheme NOIR = new TooltipTheme("tooltipster-noir");
	
	/**
	 */
	public static final TooltipTheme PUNK = new TooltipTheme("tooltipster-punk");

	/**
	 */
	public static final TooltipTheme SHADOW = new TooltipTheme("tooltipster-shadow");
	
	//------------------------------------------------
	
	/**
	 */
	public static final TooltipTheme DANGER = new TooltipTheme("tooltipster-danger");
	
	//------------------------------------------------
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param label String
	 */
	protected TooltipTheme (String label)
	{
		super(label);
	}
}
