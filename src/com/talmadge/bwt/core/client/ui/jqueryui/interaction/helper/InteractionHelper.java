package com.talmadge.bwt.core.client.ui.jqueryui.interaction.helper;


/**
 * 
 *
 */
public class InteractionHelper
{
	/**
	 */
	public static final InteractionHelper CLONE = new InteractionHelper("clone");
	
	/**
	 */
	public static final InteractionHelper ORIGINAL = new InteractionHelper("original");
	
	
	/**
	 */
	private String label;
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param label String
	 */
	protected InteractionHelper (String label)
	{
		this.label = label;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String toString ()
	{
		return this.label;
	}
}
