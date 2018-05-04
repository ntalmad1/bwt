package com.talmadge.bwt.core.client.ui.dom.style;

import com.google.gwt.dom.client.Style.BorderStyle;

/**
 * 
 *
 */
public class Border
{
	/**
	 */
	public static final Border NONE = new Border();
	
	
	/**
	 */
	private BorderStyle borderStyle;


	/**
	 */
	private String color;


	/**
	 */
	private int width;

	
	/**
	 * Constructor
	 * 
	 */
	protected Border ()
	{
		
	}
	
	
	/**
	 * Constructor
	 * 
	 *  @param width int
	 *  @param borderStyle BorderStyle
	 *  @param color String
	 */
	public Border (int width, BorderStyle borderStyle, String color)
	{
		this.width = width;
		this.borderStyle = borderStyle;
		this.color = color;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getColor ()
	{
		return this.color;
	}
	
	
	/**
	 * 
	 * @return Style.BroderStyle
	 */
	public BorderStyle getStyle ()
	{
		return this.borderStyle;
	}
	
	
	/**
	 * 
	 * @return width
	 */
	public int getWidth ()
	{
		return this.width;
	}
}
