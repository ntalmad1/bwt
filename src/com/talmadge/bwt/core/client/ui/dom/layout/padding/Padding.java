package com.talmadge.bwt.core.client.ui.dom.layout.padding;

import com.talmadge.bwt.core.client.ui.dom.layout.AbstractQuadrilateral;

/**
 * @author Noah
 *
 */
public class Padding extends AbstractQuadrilateral
{
	/**
	 * 
	 * @param padding int
	 * @return Padding
	 */
	public static Padding right (int padding)
	{
		return new PaddingRight(padding);
	}

	

	/**
	 * Constructor
	 * 
	 */
	public Padding ()
	{
		super();
	}


	/**
	 * Constructor
	 * 
	 * @param padding int
	 */
	public Padding (int padding)
	{
		this(padding, padding, padding, padding);
	}



	/**
	 * Constructor
	 * 
	 * @param top int
	 * @param right int
	 * @param bottom int
	 * @param left int
	 */
	public Padding (int top, int right, int bottom, int left)
	{
		super(top, right, bottom, left);
	}
}
