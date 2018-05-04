package com.talmadge.bwt.core.client.ui.widget.table.renderer;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public abstract class ColumnRenderer<T extends JavaScriptObject>
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
        
        return ("columnRenderer" + id); 
    }
    
    
    /**
     */
    private String functionName;
    
    
    /**
     */
    public ColumnRenderer ()
    {
        this.functionName = nextId();
        
        this._exportFunction(this, this.functionName);
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
     * Data is the data to be renedered for this column.
     * 
     * @param data String
     * @param type String
     * @param row T
     * @return string
     */
    public abstract String render (String data, String type, T row);


    /**
     * 
     * @param columnRenderer ColumnRenderer
     * @param functionName String
     */
    private native void _exportFunction (ColumnRenderer<?> columnRenderer, String functionName) /*-{
        
        $wnd[functionName] = function(data, type, row) {
            return columnRenderer.@com.talmadge.bwt.core.client.ui.widget.table.renderer.ColumnRenderer::render(Ljava/lang/String;Ljava/lang/String;Lcom/google/gwt/core/client/JavaScriptObject;)(data, type, row);
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
