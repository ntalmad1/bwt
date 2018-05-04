package com.talmadge.bwt.core.client.ui.widget.html.a;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultAAppearance extends DefaultHtmlAppearance implements AAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultAAppearance ()
	{
		super(Document.get().createElement("a"));
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}


	/**
	 * 
	 * @param href String
	 */
	public void setHref (String href)
	{
		this.getElement().setAttribute("href", href);
	}
}
