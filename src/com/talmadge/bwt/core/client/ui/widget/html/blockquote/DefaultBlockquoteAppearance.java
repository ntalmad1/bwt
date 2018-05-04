package com.talmadge.bwt.core.client.ui.widget.html.blockquote;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultBlockquoteAppearance extends DefaultHtmlAppearance implements BlockquoteAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultBlockquoteAppearance ()
	{
		super(Document.get().createElement("blockquote"));
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}


	/**
	 * 
	 * @param isReverse boolean
	 */
	public void setReverse (boolean isReverse)
	{
		this.toggleCssName("blockquote-reverse", isReverse);
	}
}
