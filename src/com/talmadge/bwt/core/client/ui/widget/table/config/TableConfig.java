package com.talmadge.bwt.core.client.ui.widget.table.config;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.talmadge.bwt.core.client.config.javascriptobject.AbstractJavaScriptObjectConfig;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.FooterCallback;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public class TableConfig<T extends JavaScriptObject> extends AbstractJavaScriptObjectConfig 
{
    /**
     * Constructor
     * 
     */
    public TableConfig ()
    {
       super((TableConfigOverlay) ((new JSONObject()).getJavaScriptObject())); 
    }

    
    /**
     * 
     * @param columnConfigs List<ColumnConfig<T>>
     */
    @SuppressWarnings("unchecked")
    public void setColumnConfigs (List<ColumnConfig<T>> columnConfigs)
    {
        JsArray<ColumnConfigOverlay> columns = (JsArray<ColumnConfigOverlay>) ((new JSONArray()).getJavaScriptObject());
        
        int index = 0;
        for (ColumnConfig<T> columnConfig : columnConfigs)
        {
            columns.set(index, columnConfig.getOverlay());
            ++index;
        }
        
        this.put("columns", columns);        
    }
    

    /**
     * 
     * @param dataSet JSONArray
     */
    public void setData (JSONArray dataSet)
    {
        this.put("data", dataSet);
    }
    
    
    /**
     * 
     * @param data JsArray<T>
     */
    public void setData (JsArray<T> data)
    {
        this.setData(new JSONArray(data));
    }
    
    
    /**
     * 
     * @param footerCallback
     */
    public void setFooterCallback (FooterCallback<T> footerCallback)
	{
		this.put("footerCallback", footerCallback.getFunction());		
	}


	/**
     * 
     * @param paginated
     */
	public void setPaginated (boolean paginated)
	{
		this.put("bPaginate", paginated);		
	}

	
	/**
	 * 
	 * @param searchable boolean
	 */
	public void setSearchable (boolean searchable)
	{
		this.put("bFilter", searchable);		
	}
	
	/**
	 * 
	 * @param selectMode SelectMode
	 */
	public void setSelectMode (SelectMode selectMode)
	{
	    this.put("select", selectMode.getValue());        
	}


	/**
	 * 
	 * @param searchable boolean
	 */
	public void setShowInfo (boolean showInfo)
	{
		this.put("bInfo", showInfo);		
	}
}
