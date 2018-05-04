package com.talmadge.bwt.core.client.ui.widget.table;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.table.config.ColumnConfig;
import com.talmadge.bwt.core.client.ui.widget.table.config.SelectMode;
import com.talmadge.bwt.core.client.ui.widget.table.footer.TableFooter;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public class BwtTable<T extends JavaScriptObject> extends BwtComposite
{
	/**
	 */
	private BwtTableCell<T> cell;
	
	
    /**
     * Constructor
     * 
     */
    public BwtTable ()
    {
    	super();
    	
        this.cell = new BwtTableCell<T>();
        
        this.initWidget(this.cell);
    }
    
    
    /**
     * 
     * @param data JSONArray
     */
    public BwtTable (JsArray<T> data)
    {
        this();
        this.setData(data);
    }

    
    /**
     * 
     * @param model T
     */
    public void add (T model)
	{
    	this.getCell().add(model);
	}


	/**
     * 
     * @param columnConfig ColumnConfig
     */
    public void addColumnConfig (ColumnConfig<T> columnConfig)
    {
    	this.getCell().addColumnConfig(columnConfig);
    }
    
    
    /**
     * 
     * @return TableFooter<T>
     */
    public TableFooter<T> getFooter ()
	{
		return this.getCell().getFooter();
	}


	/**
     * 
     * @param data JsArray<T>
     */
    public void setData (JsArray<T> data)
    {
    	this.getCell().setData(data);
    }
    
    
    /**
     * 
     * @param footer TableFooter
     */
    public void setFooter (TableFooter<T> footer)
	{
		this.getCell().setFooter(footer);
	}


	/**
	 * 
	 * @param paginated boolean
	 */
	public void setPaginated (boolean paginated)
	{
		this.getCell().setPaginated(paginated);
	}

	
	/**
	 * 
	 * @param searchable boolean
	 */
	public void setSearchable (boolean searchable)
	{
		this.getCell().setSearchable(searchable);
	}


	/**
     * 
     * @param selectMode SelectMode
     */
    public void setSelectMode (SelectMode selectMode)
    {
        this.getCell().setSelectMode(selectMode);
    }


    /**
	 * 
	 * @param showInfo
	 */
	public void setShowInfo (boolean showInfo)
	{
		this.getCell().setShowInfo(showInfo);
	}


	/**
	 * 
	 * @param striped boolean
	 */
	public void setStriped (boolean striped)
	{
	    this.getCell().setStriped(striped);
	}
	
	
	/**
	 * 
	 * @return BwtTableCell<T>
	 */
	protected BwtTableCell<T> getCell ()
	{
		return this.cell;
	}
}
