package com.talmadge.bwt.core.client.ui.util;


/**
 * 
 *
 */
public enum Position
{
	/**
	 */
	TOP("top"),
	
	/**
	 */
	RIGHT("right"),
	
	/**
	 */
	BOTTOM("bottom"),
	
	/**
	 */
	LEFT("left");
	
	
	//------------------------------------------------------------
	
	
	/**
	 */
	private String label;
	
	
	
	/**
	 * Hiden Constructor
	 *  
	 * @param label String
	 */
	private Position (String label)
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
