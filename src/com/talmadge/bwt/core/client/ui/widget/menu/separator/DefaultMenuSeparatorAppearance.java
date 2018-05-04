package com.talmadge.bwt.core.client.ui.widget.menu.separator;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultMenuSeparatorAppearance extends DefaultBwtWidgetAppearance implements MenuSeparatorAppearance
{
	/**
	 * Constructor
	 *  
	 */
	public DefaultMenuSeparatorAppearance ()
	{
		super(Document.get().createLIElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		this.ensureCssName("divider");
	}
}
