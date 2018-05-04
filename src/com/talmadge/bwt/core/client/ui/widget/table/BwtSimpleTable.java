package com.talmadge.bwt.core.client.ui.widget.table;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;

/**
 * 
 */
public class BwtSimpleTable extends BwtTable<JavaScriptObject>
{
    /**
     * 
     */
    public BwtSimpleTable ()
    {
        super();
    }


    /**
     * 
     * @param data JSONArray
     */
    public BwtSimpleTable (JSONArray data)
    {
        super();
        this.setData(data);
    }

    
    /**
     * 
     * @param dataSet JSONArray
     */
    public void setData (JSONArray dataSet)
    {
    	if (!this.hasBeenAttached())
        {
            this.getCell().getTableConfig().setData(dataSet);
        }
    }
}
