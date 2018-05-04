package com.talmadge.bwt.core.client.ui.dom.layout.margin;

/**
 * 
 * @author Noah
 *
 */
public final class Margin
{
	/**
	 * 
	 * @param margin int
	 * @return MarginBottom
	 */
	public static MarginBottom bottom (int margin)
	{
		return new MarginBottom(margin);
	}
	
	
	
	/**
	 * 
	 * @param margin int
	 * @return MarginLeft
	 */
	public static MarginLeft left (int margin)
	{
		return new MarginLeft(margin);
	}
	
	
	/**
	 * 
	 * @param margin int
	 * @return MarginRight
	 */
	public static MarginRight right (int margin)
	{
		return new MarginRight(margin);
	}
	
	/**
	 * 
	 * @param margin int
	 * @return MarginTop
	 */
	public static MarginTop top (int margin)
	{
		return new MarginTop(margin);
	}
	
	
	/**
	 * Hidden Constructor 
	 *
	 */
	private Margin ()
	{
		
	}
}
