package com.talmadge.bwt.core.client.ui.widget.html.list.ol;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.list.AbstractListCell;

/**
 * 
 * @author Noah
 *
 */
public class OlCell extends AbstractListCell
{
	/**
	 * Constructor 
	 *
	 */
	public OlCell ()
	{
		this((DefaultOlAppearance) GWT.create(DefaultOlAppearance.class)); 
	}
	
	
	/**
	 * 
	 * @param appearance OlCellAppearance
	 */
	protected OlCell (OlAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return OlCellAppearance
	 */
	public OlAppearance getAppearance ()
	{
		return (OlAppearance) super.getAppearance();
	}
}
