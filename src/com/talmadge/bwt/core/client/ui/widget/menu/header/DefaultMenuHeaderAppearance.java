package com.talmadge.bwt.core.client.ui.widget.menu.header;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultMenuHeaderAppearance extends DefaultBwtWidgetAppearance implements MenuHeaderAppearance
{
	/**
	 */
	private String text;

	
	
	/**
	 * Constructor
	 *  
	 * @param element
	 */
	public DefaultMenuHeaderAppearance ()
	{
		super(Document.get().createLIElement());
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getText ()
	{
		return this.text;
	}
	
	
	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.text = text;
		
		this.getElement().setInnerHTML(text);
		
		if (text == null || text.isEmpty())
		{
			this.removeCssName("hasText");
		}
		else
		{
			this.ensureCssName("hasText");
		}
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.ensureCssName("dropdown-header");
	}
}
