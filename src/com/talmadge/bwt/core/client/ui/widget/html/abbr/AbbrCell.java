package com.talmadge.bwt.core.client.ui.widget.html.abbr;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public class AbbrCell extends HtmlCell
{
	/**
	 * Constructor 
	 *
	 */
	public AbbrCell ()
	{
		this((DefaultAbbrAppearance) GWT.create(DefaultAbbrAppearance.class));
	}
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public AbbrCell (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param appearance AbbrCellAppearance
	 */
	protected AbbrCell (AbbrAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return AbbrCellAppearance
	 */
	public AbbrAppearance getAppearance ()
	{
		return (AbbrAppearance) super.getAppearance();
	}
	
	
	/**
	 * 
	 * @param isInitialism boolean
	 */
	public void setInitialism (boolean isInitialism)
	{
		this.getAppearance().setInitialism(isInitialism);		
	}
}
