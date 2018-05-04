package com.talmadge.bwt.core.client.ui.widget.html.pre;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultPreAppearance extends DefaultHtmlAppearance implements PreAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultPreAppearance ()
	{
		super(Document.get().createPreElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}


	/**
	 * 
	 * @param isScrollable boolean
	 */
	public void setScrollable (boolean isScrollable)
	{
		this.toggleCssName("pre-scrollable", isScrollable);
	}
}
