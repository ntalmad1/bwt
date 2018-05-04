package com.talmadge.bwt.core.client.ui.dom.style.color;

/**
 * 
 *
 */
public class HexColor implements Color
{
	/**
	 */
	private String color;
	
	
	/**
	 * Constructor
	 * 
	 * @param color String
	 */
	public HexColor (String color)
	{
		this.color = color;
	}
	
	
	
	/**
	 * 
	 * @return String
	 */
	public String toString ()
	{
		return this.color;
	}
}
