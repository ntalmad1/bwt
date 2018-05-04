package com.talmadge.bwt.core.client.ui.widget.table.footer;

import com.google.gwt.core.client.JavaScriptObject;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackEvent;
import com.talmadge.bwt.core.client.ui.widget.table.footer.column.FooterColumn;

/**
 * 
 *
 */
public class TableFooter<T extends JavaScriptObject> extends BwtComposite
{
	/**
	 */
	private TableFooterCell<T> cell;
	
	
	/**
	 * Constructor
	 * 
	 */
	public TableFooter ()
	{
		super();
		
		this.cell = new TableFooterCell<T>();
		
		this.initWidget(this.cell);
	}
	
	
	/**
	 * 
	 * @param fc FooterColumn
	 */
	public void add (FooterColumn<T> fc)
	{
		this.getCell().add(fc);		
	}

	
	/**
	 * 
	 * @param html String
	 * @return FooterColumn<T>
	 */
	public FooterColumn<T> add (String html)
	{
		FooterColumn<T> fc = new FooterColumn<T>(html);
		this.add(fc);
		return fc;
	}

	
	/**
	 * 
	 * @param event FooterCallbackEvent
	 */
	public void onFooterCallback (FooterCallbackEvent event)
	{
		this.getCell().onFooterCallback(event);		
	}


	/**
	 * 
	 * @return TableFooterCell<T>
	 */
	protected TableFooterCell<T> getCell ()
	{
		return this.cell;
	}
}
