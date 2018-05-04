package com.talmadge.bwt.core.client.ui.widget.html.list.ol;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.list.DefaultAbstractListAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultOlAppearance extends DefaultAbstractListAppearance implements OlAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultOlAppearance ()
	{
		super(Document.get().createOLElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}
}
