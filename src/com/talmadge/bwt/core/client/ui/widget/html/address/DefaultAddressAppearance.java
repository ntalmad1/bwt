package com.talmadge.bwt.core.client.ui.widget.html.address;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultAddressAppearance extends DefaultHtmlAppearance implements AddressAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultAddressAppearance ()
	{
		super(Document.get().createElement("address"));
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}
}
