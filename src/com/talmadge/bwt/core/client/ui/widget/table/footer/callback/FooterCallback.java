package com.talmadge.bwt.core.client.ui.widget.table.footer.callback;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackEvent;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackHandler;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.HasFooterCallbackHandlers;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public class FooterCallback<T extends JavaScriptObject> implements HasFooterCallbackHandlers
{
    /**
     */
    private static int id = 0;
    
    /**
     * 
     * @return String
     */
    private static String nextId ()
    {
        ++id;
        
        return ("footerCallback" + id); 
    }
    
    
    /**
     */
    private String functionName;
    
    /**
     */
    private HandlerManager handlerManager;
    
    
    /**
     * Constructor
     * 
     */
    public FooterCallback ()
    {
    	this.handlerManager = new HandlerManager(this);
    	
        this.functionName = nextId();
        
        this._exportFunction(this, this.functionName);
    }
    
    
    /**
     * 
     * @param handler FooterCallbackHandler
     * @return HandlerRegistration
     */
    @Override
	public HandlerRegistration addFooterCallbackHandler (FooterCallbackHandler handler)
	{
		return this.handlerManager.addHandler(FooterCallbackEvent.getType(), handler);
	}


	/**
     * 
     * @return JsFunction
     */
    public JavaScriptObject getFunction ()
    {
        return this._getFunction(this.functionName);
    }


    /**
     * 
     * @param table JavaScriptObject
     */ 
    protected void onNativeCallback (JavaScriptObject table)
    {
    	this.handlerManager.fireEvent(new FooterCallbackEvent(table));  	
    }


    /**
     * 
     * @param columnRenderer ColumnRenderer
     * @param functionName String
     */
    private native void _exportFunction (FooterCallback<?> columnRenderer, String functionName) /*-{
   
        $wnd[functionName] = function(tfoot, data, start, end, display) {
        	
        	var table = this;
        	
            return columnRenderer.@com.talmadge.bwt.core.client.ui.widget.table.footer.callback.FooterCallback::onNativeCallback(Lcom/google/gwt/core/client/JavaScriptObject;)(table);
        };
        
    }-*/;
    
    
    /**
     * 
     * @param functionName String
     * @return JavaScriptObject
     */
    private native JavaScriptObject _getFunction (String functionName) /*-{
        
        return $wnd[functionName];
        
    }-*/;
}
