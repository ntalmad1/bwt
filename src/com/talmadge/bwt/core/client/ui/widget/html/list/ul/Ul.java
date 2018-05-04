package com.talmadge.bwt.core.client.ui.widget.html.list.ul;

import com.talmadge.bwt.core.client.ui.widget.html.list.AbstractList;

/**
 * 
 * @author Noah
 *
 */
public class Ul extends AbstractList
{
	/**
	 * Constructor 
	 *
	 */
	public Ul ()
	{
		this.setCell(new UlCell());
		this.initWidget(this.getCell());
	}
	

	/**
	 * 
	 * @return AbbrCell
	 */
	protected UlCell getCell ()
	{
		return (UlCell) super.getCell();
	}
}
