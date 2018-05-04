package com.talmadge.bwt.core.client.ui.widget.html.blockquote;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public class BlockquoteCell extends HtmlCell
{
	/**
	 * Constructor 
	 *
	 */
	public BlockquoteCell ()
	{
		this((DefaultBlockquoteAppearance) GWT.create(DefaultBlockquoteAppearance.class));
	}
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public BlockquoteCell (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param appearance AbbrCellAppearance
	 */
	protected BlockquoteCell (BlockquoteAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return AbbrCellAppearance
	 */
	public BlockquoteAppearance getAppearance ()
	{
		return (BlockquoteAppearance) super.getAppearance();
	}

	
	/**
	 * 
	 * @param isReverse boolean
	 */
	public void setReverse (boolean isReverse)
	{
		this.getAppearance().setReverse(isReverse);
		
	}
}
