package com.talmadge.bwt.core.client.ui.widget.html.p;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultPAppearance extends DefaultHtmlAppearance implements PAppearance
{
	/**
	 * Constructor 
	 * 
	 */
	protected DefaultPAppearance ()
	{
		super(Document.get().createPElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}


	/**
	 * 
	 * @param isLead boolean
	 */
	public void setLead (boolean isLead)
	{
		this.toggleCssName("lead", isLead);
	}
}
