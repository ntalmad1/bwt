package com.talmadge.bwt.core.client.ui.widget.html.pre;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public class PreCell extends HtmlCell
{
	/**
	 * Constructor 
	 *
	 */
	public PreCell ()
	{
		this((DefaultPreAppearance) GWT.create(DefaultPreAppearance.class));
	}
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public PreCell (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param appearance PCellAppearance
	 */
	protected PreCell (PreAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @return PAppearance
	 */
	public PreAppearance getAppearance ()
	{
		return (PreAppearance) super.getAppearance();
	}
	

	/**
	 * 
	 * @param isScrollable boolean
	 * @return Pre
	 */
	public PreCell setScrollable (boolean isScrollable)
	{
		this.getAppearance().setScrollable(isScrollable);
		
		return this;
	}
}
