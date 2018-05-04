package com.talmadge.bwt.core.client.ui.widget.html.list.li;

import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class Li extends Html
{
	/**
	 * Constructor 
	 *
	 */
	public Li ()
	{
		this.setCell(new LiCell());
		this.initWidget(this.getCell());
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public Li (String html)
	{
		this();
		this.setInnerHtml(html);
	}


	/**
	 * 
	 * @return AbbrCell
	 */
	protected LiCell getCell ()
	{
		return (LiCell) super.getCell();
	}
}
