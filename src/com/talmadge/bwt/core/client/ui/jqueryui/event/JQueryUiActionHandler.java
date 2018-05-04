package com.talmadge.bwt.core.client.ui.jqueryui.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;
import com.talmadge.bwt.core.client.config.javascriptobject.JavaScriptObjectParameter;
import com.talmadge.bwt.core.client.ui.jqueryui.JQueryUi;

/**
 * 
 *
 */
public abstract class JQueryUiActionHandler extends JavaScriptObjectParameter
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
        
        return ("jqueryUiActionHandlerFunction" + id); 
    }
	
	
	/**
	 * Constructor 
	 * 
	 */
	public JQueryUiActionHandler ()
	{
		super();
		
		this.setValue(this._exportFunction(this, JQueryUiActionHandler.nextId()));
	}
	
	
	/**
	 * 
	 * @param event NativeEvent
	 * @param ui JQueryUi  
	 */                  
	public abstract void onJQueryUiAction (NativeEvent event, JQueryUi ui);
	
	
	
	/**
     * 
     * @param tooltip Tooltip
     * @param functionName String
     */
    private native JavaScriptObject _exportFunction (JQueryUiActionHandler handler, String functionName) /*-{
   
        $wnd[functionName] = function(event, ui) {
            return handler.@com.talmadge.bwt.core.client.ui.jqueryui.event.JQueryUiActionHandler::onJQueryUiAction(Lcom/google/gwt/dom/client/NativeEvent;Lcom/talmadge/bwt/core/client/ui/jqueryui/JQueryUi;)(event, ui);
        };
        
        return $wnd[functionName];
                
    }-*/;
}
