package com.talmadge.bwt.core.client.ui.widget.html.list.dl;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.list.AbstractListCell;

/**
 * 
 * @author Noah
 *
 */
public class DlCell extends AbstractListCell
{
	/**
	 * Constructor 
	 *
	 */
	public DlCell ()
	{
		this((DefaultDlAppearance) GWT.create(DefaultDlAppearance.class)); 
	}
	
	
	/**
	 * 
	 * @param appearance OlCellAppearance
	 */
	protected DlCell (DlAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return OlCellAppearance
	 */
	public DlAppearance getAppearance ()
	{
		return (DlAppearance) super.getAppearance();
	}

	
	/**
	 * 
	 * @param isHorizontal boolean
	 */
	public void setHorizontal (boolean isHorizontal)
	{
		this.getAppearance().setHorizontal(isHorizontal);
		
	}
}
