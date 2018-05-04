package com.talmadge.bwt.core.client.ui.widget.table.footer;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackEvent;
import com.talmadge.bwt.core.client.ui.widget.table.footer.column.FooterColumn;
import com.talmadge.bwt.core.client.ui.widget.table.row.TableRow;

/**
 * 
 *
 */
public class TableFooterCell<T extends JavaScriptObject> extends BwtWidgetContainer
{
	/**
	 */
	private TableRow<T> tableRow;
	
	/**
	 */
	private List<FooterColumn<T>> footerColumns;
	
	
	/**
	 * Constructor
	 * 
	 */
	protected TableFooterCell ()
	{
		this((TableFooterAppearance) GWT.create(DefaultTableFooterAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance TableFooterAppearance
	 */
	protected TableFooterCell (TableFooterAppearance appearance)
	{
		super(appearance);
		
		this.footerColumns = new ArrayList<FooterColumn<T>>();
		this.tableRow = new TableRow<T>();
		this.add(tableRow);
	}
	
	
	/**
	 * 
	 * @param fc FooterColumn
	 */
	public void add (FooterColumn<T> fc)
	{
		this.getRow().add(fc);
		this.footerColumns.add(fc);
	}
	
	
	/**
	 * 
	 * @return TableRow<T>
	 */
	public TableRow<T> getRow ()
	{
		return this.tableRow;		
	}

	
	/**
	 * 
	 * @param event FooterCallbackEvent
	 */
	public void onFooterCallback (FooterCallbackEvent event)
	{
		for (FooterColumn<T> footerColumn : this.getFooterColumns())
		{
			footerColumn.onFooterCallback(event);
		}
	}
	
	
	/**
	 * 
	 * @return List<FooterColumn<T>>
	 */
	protected List<FooterColumn<T>> getFooterColumns ()
	{
		return this.footerColumns;
	}
}
