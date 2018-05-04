package com.talmadge.bwt.core.client.ui.widget.html.list.ul;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.list.DefaultAbstractListAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultUlCellAppearance extends DefaultAbstractListAppearance implements UlCellAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultUlCellAppearance ()
	{
		super(Document.get().createULElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}
}
