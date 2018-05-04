package com.talmadge.bwt.core.client.ui.widget.html.list.dl;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.list.DefaultAbstractListAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultDlAppearance extends DefaultAbstractListAppearance implements DlAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultDlAppearance ()
	{
		super(Document.get().createElement("dl"));
	}

	
	/**
	 * 
	 * @param isHorizontal boolean
	 */
	public void setHorizontal (boolean isHorizontal)
	{
		this.toggleCssName("dl-horizontal", isHorizontal);		
	}


	/**
	 * 
	 */
	protected void build ()
	{
		
	}
}
