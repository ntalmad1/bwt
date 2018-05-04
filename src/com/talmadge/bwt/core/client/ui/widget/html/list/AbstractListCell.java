package com.talmadge.bwt.core.client.ui.widget.html.list;

import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public abstract class AbstractListCell extends HtmlCell
{
	/**
	 * 
	 * @param appearance AbbrCellAppearance
	 */
	protected AbstractListCell (AbstractListAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return AbbrCellAppearance
	 */
	public AbstractListAppearance getAppearance ()
	{
		return (AbstractListAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 * @param isStyled boolean
	 */
	public void setStyled (boolean isStyled)
	{
		this.getAppearance().setStyled(isStyled);		
	}

	
	/**
	 * 
	 * @param isInline boolean
	 */
	public void setInline (boolean isInline)
	{
		this.getAppearance().setInline(isInline);
		
	}
}
