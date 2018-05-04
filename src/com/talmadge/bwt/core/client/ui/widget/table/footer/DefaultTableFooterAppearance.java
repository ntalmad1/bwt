package com.talmadge.bwt.core.client.ui.widget.table.footer;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultTableFooterAppearance extends DefaultBwtWidgetContainerAppearance implements TableFooterAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultTableFooterAppearance ()
	{
		super(Document.get().createTFootElement());
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		
		
	}

}
