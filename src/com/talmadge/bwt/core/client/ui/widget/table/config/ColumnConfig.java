package com.talmadge.bwt.core.client.ui.widget.table.config;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONObject;
import com.talmadge.bwt.core.client.config.javascriptobject.AbstractJavaScriptObjectConfig;
import com.talmadge.bwt.core.client.ui.widget.table.renderer.ColumnRenderer;
import com.talmadge.bwt.core.client.ui.widget.table.renderer.DateTimeColumnRenderer;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public class ColumnConfig<T extends JavaScriptObject> extends AbstractJavaScriptObjectConfig
{
    /**
     */
    public enum ColumnType 
    {
        /**
         */
        DATE_TIME("date");
        
        //------------------------------------------------------
        
        /**
         */
        private String type;
        
        /**
         * Hidden Construtor
         * 
         * @param type String 
         */
        ColumnType (String type)
        {
            this.type = type;
        }
        
        
        /**
         * 
         * @return String
         */
        public String getType ()
        {
            return this.type;
        }
    }
    
    
    
    /**
     * Constructor
     * 
     */
    public ColumnConfig ()
    {
        super((ColumnConfigOverlay) ((new JSONObject()).getJavaScriptObject()));
        
        this.setDefaultContent("");
    }
    
    
    /**
     * Constrcutor
     * 
     * @param title String
     */
    public ColumnConfig (String title)
    {
        this();
        this.setTitle(title);
    }
    
    
    /**
     * 
     * @param colTitle String
     * @param colSource String
     */
    public ColumnConfig (String colTitle, String colSource)
    {
        this();
        this.setTitle(colTitle);
        this.setSource(colSource);
    }

    
    /**
     * 
     * @param colTitle String
     * @param colSource String
     */
    public ColumnConfig (String colTitle, String colSource, ColumnRenderer<T> renderer)
    {
        this(colTitle, colSource);
        this.setRenderer(renderer);
    }
    
    
    /**
     * 
     * @param colTitle String
     * @param colSource String
     * @param colType ColumnType
     */
    public ColumnConfig (String colTitle, String colSource, ColumnType colType)
    {
        this();
        this.setTitle(colTitle);
        this.setSource(colSource);
        this.setType(colType);
        
        if (ColumnType.DATE_TIME.equals(colType))
        {
            this.setRenderer(new DateTimeColumnRenderer<T>());
        }
    }

    
    /**
     * 
     * @param html String
     */
    public void setDefaultContent (String html)
    {
        this._put(this.getOverlay(), "defaultContent", html);
    }
    
    
    /**
     * 
     * @param columnRenderer ColumnRenderer
     */ 
    public void setRenderer (ColumnRenderer<?> columnRenderer)
    {
        this.put("render", columnRenderer.getFunction());
    }

    
    /**
     * 
     * @return ColumnConfigOverlay
     */
    public ColumnConfigOverlay getOverlay ()
    {
        return (ColumnConfigOverlay) super.getOverlay();
    }
    

    /**
     * 
     * @param title String
     */
    public void setTitle (String title)
    {
        this.put("title", title);
    }
    
    
    /**
     * 
     * @param type ColumnType
     */
    public void setType (ColumnType type)
    {
        this.put("type", type.getType());
    }
    
    
    /**
     * 
     * @param key String
     */
    public void setSource (String key)
    {
        this.put("data", key);        
    }
}
