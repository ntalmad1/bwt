package com.talmadge.bwt.core.client.ui.widget.html.list.dl;

import com.talmadge.bwt.core.client.ui.widget.html.list.AbstractList;

/**
 * 
 * @author Noah
 *
 */
public class Dl extends AbstractList
{
	/**
	 * Constructor 
	 *
	 */
	public Dl ()
	{
		this.setCell(new DlCell());
		this.initWidget(this.getCell());
	}
	
	
	/**
	 * 
	 * @param dlItem DlItem
	 */
	public void add (DlItem dlItem)
	{
		this.add(dlItem.getName());
		this.add(dlItem.getDescription());
	}
	

	/**
	 * 
	 * @param isHorizontal boolean
	 */
	public void setHorizontal (boolean isHorizontal)
	{
		this.getCell().setHorizontal(isHorizontal);
	}


	/**
	 * 
	 * @return OlCell
	 */
	protected DlCell getCell ()
	{
		return (DlCell) super.getCell();
	}
}
