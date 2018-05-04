package com.talmadge.bwt.core.client.ui.dom.style.color;

/**
 * 
 *
 */
public class RGBColor implements Color
{
	/**
	 */
	private int red;
	
	/**
	 */	
	private int green;
	
	/**
	 */
	private int blue;
	
	/**
	 */
	private double alpha;
	
	
	/**
	 * Constructor
	 * 
	 * @param red int 
	 * @param green int
	 * @param blue int
	 * @param alpha double
	 */
	public RGBColor (int red, int green, int blue, double alpha)
	{
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String toString ()
	{
		return "rgba(" + this.red + ", " + this.green + ", " + this.blue + ", " + this.alpha + ")";
	}
}
