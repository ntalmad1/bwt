package com.talmadge.bwt.core.client.ui.dom.layout;

/**
 * 
 * @author Noah
 *
 */
public class AbstractQuadrilateral
{
	/**
	 */
	private Integer bottom;

	/**
	 */
	private Integer left;

	/**
	 */
	private Integer right; 

	/**
	 */
	private Integer top;
	
	
	/**
	 * Constructor
	 * 
	 */
	public AbstractQuadrilateral ()
	{
		
	}


	/**
	 * Constructor
	 * 
	 * @param top int
	 * @param right int
	 * @param bottom int
	 * @param left int
	 */
	public AbstractQuadrilateral (int top, int right, int bottom, int left)
	{
		this.setTop(top);
		this.setRight(right);
		this.setBottom(bottom);
		this.setLeft(left);
	}
	
	
	/**
	 * 
	 * @param bottom int
	 */
	public AbstractQuadrilateral setBottom (int bottom)
	{
		this.bottom = new Integer(bottom);
		return this;
	}
	
	
	/**
	 * 
	 * @param left int
	 */
	public AbstractQuadrilateral setLeft (int left)
	{
		this.left = new Integer(left);
		return this;
	}
	
	
	/**
	 * 
	 * @param right int
	 */
	public AbstractQuadrilateral setRight (int right)
	{
		this.right = new Integer(right);
		return this;
	}
	
	
	/**
	 * 
	 * @param top int
	 * @return Margins
	 */
	public AbstractQuadrilateral setTop (int top)
	{
		this.top = new Integer(top);
		return this;
	}
	
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer getBottom ()
	{
		return this.bottom;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer getLeft ()
	{
		return this.left;
	}
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer getRight ()
	{
		return this.right;
	}
	
	
	/**
	 * 
	 * @return Integer
	 */
	public Integer getTop ()
	{
		return this.top;
	}
}
