package com.talmadge.bwt.core.client.ui.widget.table.row;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultTableRowAppearance extends DefaultBwtWidgetContainerAppearance implements TableRowAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultTableRowAppearance ()
	{
		super(Document.get().createTRElement());
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		
		
	}

}
