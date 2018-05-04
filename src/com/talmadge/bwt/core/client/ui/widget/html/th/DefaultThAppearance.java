package com.talmadge.bwt.core.client.ui.widget.html.th;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 *
 */
public class DefaultThAppearance extends DefaultHtmlAppearance implements ThAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public 	DefaultThAppearance ()
	{
		this(Document.get().createTHElement());
	}
	
	
	/**
	 * Hidden 
	 * @param element
	 */
	protected DefaultThAppearance (Element element)
	{
		super(element);
	}

	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		
		
	}

}
