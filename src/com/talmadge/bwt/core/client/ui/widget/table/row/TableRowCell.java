package com.talmadge.bwt.core.client.ui.widget.table.row;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class TableRowCell<T extends JavaScriptObject> extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public TableRowCell ()
	{
		this((TableRowAppearance) GWT.create(DefaultTableRowAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance TableFooterAppearance
	 */
	protected TableRowCell (TableRowAppearance appearance)
	{
		super(appearance);
	}
}
