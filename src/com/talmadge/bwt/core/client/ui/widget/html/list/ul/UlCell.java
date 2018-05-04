package com.talmadge.bwt.core.client.ui.widget.html.list.ul;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.list.AbstractListCell;

/**
 * 
 * @author Noah
 *
 */
public class UlCell extends AbstractListCell
{
	/**
	 * Constructor 
	 *
	 */
	public UlCell ()
	{
		this((DefaultUlCellAppearance) GWT.create(DefaultUlCellAppearance.class));
	}
	
	
	/**
	 * 
	 * @param appearance UlCellAppearance
	 */
	protected UlCell (UlCellAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return UlCellAppearance
	 */
	public UlCellAppearance getAppearance ()
	{
		return (UlCellAppearance) super.getAppearance();
	}
}
