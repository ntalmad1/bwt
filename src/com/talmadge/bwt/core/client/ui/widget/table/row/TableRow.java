package com.talmadge.bwt.core.client.ui.widget.table.row;

import com.google.gwt.core.client.JavaScriptObject;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.html.th.Th;
import com.talmadge.bwt.core.client.ui.widget.table.footer.column.FooterColumn;

/**
 * 
 *
 */
public class TableRow<T extends JavaScriptObject> extends BwtComposite
{
	/**
	 */
	private TableRowCell<T> cell;
	
	
	/**
	 * Constructor
	 * 
	 */
	public TableRow ()
	{
		super();
		
		this.cell = new TableRowCell<T>();
		
		this.initWidget(this.cell);
	}
	
	
	/**
	 * 
	 * @param th Th
	 */
	public void add (Th th)
	{
		this.getCell().add(th);		
	}
	
	
	/**
	 * 
	 * @param fc FooterColumn<T>
	 */
	public void add (FooterColumn<T> fc)
	{
		this.getCell().add(fc);		
	}
	

	/**
	 * 
	 * @return TableFooterCell<T>
	 */
	protected TableRowCell<T> getCell ()
	{
		return this.cell;
	}
}
