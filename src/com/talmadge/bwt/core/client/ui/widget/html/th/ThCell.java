package com.talmadge.bwt.core.client.ui.widget.html.th;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 *
 */
public class ThCell extends HtmlCell
{
	/**
	 * Constrcutor
	 * 
	 */
	public ThCell ()
	{
		this((ThAppearance) GWT.create(DefaultThAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance ThAppearance
	 */
	protected ThCell (ThAppearance appearance)
	{
		super(appearance);		
	}
	
}
