package com.talmadge.bwt.core.client.ui.widget.html.list.ol;

import com.talmadge.bwt.core.client.ui.widget.html.list.AbstractList;

/**
 * 
 * @author Noah
 *
 */
public class Ol extends AbstractList
{
	/**
	 * Constructor 
	 *
	 */
	public Ol ()
	{
		this.setCell(new OlCell());
		this.initWidget(this.getCell());
	}
	

	/**
	 * 
	 * @return OlCell
	 */
	protected OlCell getCell ()
	{
		return (OlCell) super.getCell();
	}
}
