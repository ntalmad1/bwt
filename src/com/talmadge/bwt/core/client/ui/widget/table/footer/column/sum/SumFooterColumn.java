package com.talmadge.bwt.core.client.ui.widget.table.footer.column.sum;

import com.google.gwt.core.client.JavaScriptObject;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackEvent;
import com.talmadge.bwt.core.client.ui.widget.table.footer.column.FooterColumn;

/**
 * 
 *
 */
public class SumFooterColumn<T extends JavaScriptObject> extends FooterColumn<T>
{
	/**
	 * Constructor
	 * 
	 */
	public SumFooterColumn ()
	{
		super();
	}
	
	
	/**
	 * 
	 * @param event FooterCallbackEvent
	 */
	public void onFooterCallback (FooterCallbackEvent event)
	{
		this.sum(this, event.getNativeTable());
	}
	
	
	/**
	 * 
	 * @param total int
	 * @param pageTotal int
	 * @return String
	 */
	protected String render (int total, int pageTotal)
	{
		return total + " (" + pageTotal + ")"; 
	}
	
	
	/**
     * 
     * @param table JavaScriptObject
     */
    private native void sum (SumFooterColumn<T> sumFooterColumn, JavaScriptObject table) /*-{
        
        var api = table.api();
    	
    	var total = api.column(1).data().reduce(function(a, b) {
            return parseInt(a) + parseInt(b);
        }, 0);
        
        var pageTotal = api.column(1, { page: 'current'}).data().reduce( function (a, b) {
            return parseInt(a) + parseInt(b);
        }, 0 );
    	
    	$wnd.$(api.column(1).footer()).html(
    		sumFooterColumn.@com.talmadge.bwt.core.client.ui.widget.table.footer.column.sum.SumFooterColumn::render(II)(total, pageTotal)
    	);

    }-*/;
}
