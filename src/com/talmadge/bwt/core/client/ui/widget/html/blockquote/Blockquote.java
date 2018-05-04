package com.talmadge.bwt.core.client.ui.widget.html.blockquote;

import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class Blockquote extends Html
{
	/**
	 * Constructor 
	 *
	 */
	public Blockquote ()
	{
		this.setCell(new BlockquoteCell());
		this.initWidget(this.getCell());
	}
	
	
	/**
	 * 
	 * @param isReverse boolean
	 */
	public void setReverse (boolean isReverse)
	{
		this.getCell().setReverse(isReverse); 
	}


	/**
	 * 
	 * @return AbbrCell
	 */
	protected BlockquoteCell getCell ()
	{
		return (BlockquoteCell) super.getCell();
	}
}
