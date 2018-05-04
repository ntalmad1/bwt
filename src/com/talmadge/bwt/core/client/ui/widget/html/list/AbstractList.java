package com.talmadge.bwt.core.client.ui.widget.html.list;

import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public abstract class AbstractList extends Html
{
	/**
	 * 
	 * @param listItem String
	 * @return AbstractList
	 */
	public AbstractList add (String listItem)
	{
		this.add(Html.li(listItem));
		return this;
	}
	
	
	/**
	 * 
	 * @param isInline boolean
	 */
	public void setInline (boolean isInline)
	{
		this.getCell().setInline(isInline);		
	}
	
	
	/**
	 * 
	 * @param isStyled boolean
	 */
	public void setStyled (boolean isStyled)
	{
		this.getCell().setStyled(isStyled);	
	}
	
	
	/**
	 * 
	 * @return AbstractListCell
	 */
	protected AbstractListCell getCell ()
	{
		return (AbstractListCell) super.getCell();
	}
}
