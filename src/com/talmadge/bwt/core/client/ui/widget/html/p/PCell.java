package com.talmadge.bwt.core.client.ui.widget.html.p;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public class PCell extends HtmlCell
{
	/**
	 * Constructor 
	 *
	 */
	public PCell ()
	{
		this((DefaultPAppearance) GWT.create(DefaultPAppearance.class));
	}
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public PCell (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param appearance PCellAppearance
	 */
	protected PCell (PAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return PAppearance
	 */
	public PAppearance getAppearance ()
	{
		return (PAppearance) super.getAppearance();
	}
	

	/**
	 * 
	 * @param isLead boolean
	 * @return P
	 */
	public PCell setLead (boolean isLead)
	{
		this.getAppearance().setLead(isLead);
		
		return this;
	}
}
