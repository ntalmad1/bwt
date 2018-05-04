package com.talmadge.bwt.core.client.ui.dom.layout.margin;

import com.talmadge.bwt.core.client.ui.dom.layout.AbstractQuadrilateral;

/**
 * @author Noah
 *
 */
public class Margins extends AbstractQuadrilateral
{
	/**
	 * 
	 * @param margin int
	 * @return Margins
	 */
	public static Margins bottom (int margin)
	{
		return new MarginBottom(margin);
	}

	
	/**
	 * 
	 * @param margin int
	 * @return Margins
	 */
	public static Margins left (int margin)
	{
		return new MarginLeft(margin);
	}
	

	/**
	 * 
	 * @param margin int
	 * @return Margins
	 */
	public static Margins right (int margin)
	{
		return new MarginRight(margin); 
	}

	
	/**
	 * 
	 * @param margin int
	 * @return Margins
	 */
	public static Margins top (int margin)
	{
		return new MarginTop(margin);
	}



	/**
	 * Constructor
	 * 
	 */
	public Margins ()
	{
		super();
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param margin int
	 */
	public Margins (int margin)
	{
		this(margin, margin, margin, margin);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param top int
	 * @param right int
	 * @param bottom int
	 * @param left int
	 */
	public Margins (int top, int right, int bottom, int left)
	{
		super(top, right, bottom, left);
	}
}
