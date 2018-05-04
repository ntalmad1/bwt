package com.talmadge.bwt.core.client.ui.widget.html.list.li;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public class LiCell extends HtmlCell
{
	/**
	 * Constructor 
	 *
	 */
	public LiCell ()
	{
		this((DefaultLiAppearance) GWT.create(DefaultLiAppearance.class));
	}
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public LiCell (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param appearance AbbrCellAppearance
	 */
	protected LiCell (LiAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return AbbrCellAppearance
	 */
	public LiAppearance getAppearance ()
	{
		return (LiAppearance) super.getAppearance();
	}
}
