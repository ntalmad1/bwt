package com.talmadge.bwt.core.client.ui.widget.html.list.li;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultLiAppearance extends DefaultHtmlAppearance implements LiAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultLiAppearance ()
	{
		super(Document.get().createLIElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}
}
