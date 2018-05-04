package com.talmadge.bwt.core.client.ui.widget.html.abbr;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultAbbrAppearance extends DefaultHtmlAppearance implements AbbrAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultAbbrAppearance ()
	{
		super(Document.get().createElement("abbr"));
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}


	/**
	 * 
	 * @param isInitialism boolean
	 */
	public void setInitialism (boolean isInitialism)
	{
		this.toggleCssName("initialism", isInitialism);
	}
}
