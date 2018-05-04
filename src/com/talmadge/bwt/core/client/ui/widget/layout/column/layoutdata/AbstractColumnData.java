package com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata;

import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;

/**
 * 
 * @author Noah
 *
 */
public abstract class AbstractColumnData
{
	/**
	 */
	private Size size;
	
	/**
	 */
	private int columns;
	
	
	/**
	 * Constructor
	 * 
	 * @param size Size
	 * @param columns int
	 */
	public AbstractColumnData (Size size, int columns)
	{
		assert columns >= 0;
		assert columns <= 12;
		
		this.size = size;
		this.columns = columns;
	}
	
	
	/**
	 * 
	 * @return Size
	 */
	public Size getSize ()
	{
		return this.size;
	}
	
	
	/**
	 * 
	 * @return int
	 */
	public int getColumns ()
	{
		return this.columns;
	}
}
