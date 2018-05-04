package com.talmadge.bwt.core.client.ui.widget.table;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.table.config.ColumnConfig;
import com.talmadge.bwt.core.client.ui.widget.table.config.SelectMode;
import com.talmadge.bwt.core.client.ui.widget.table.config.TableConfig;
import com.talmadge.bwt.core.client.ui.widget.table.footer.TableFooter;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.FooterCallback;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackEvent;
import com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event.FooterCallbackHandler;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public class BwtTableCell<T extends JavaScriptObject> extends BwtWidgetContainer
{
    /**
     */
    private List<ColumnConfig<T>> columnConfigs;
    
    /**
	 */
	private TableFooter<T> footer;
	
	/**
	 */
	private FooterCallback<T> footerCallback;

	/**
	 */
	private JQueryBridge<T> jQueryBridge;
	
	/**
     */
    private TableConfig<T> tableConfig;
    
    /**
     */
    private JavaScriptObject tableHandle;
    
    
    
    /**
     * Constructor
     * 
     */
    public BwtTableCell ()
    {
        this(new DefaultBwtTableAppearance());
    }
    
    
    /**
	 * 
	 * @param data JSONArray
	 */
	public BwtTableCell (JsArray<T> data)
	{
	    this();
	    this.setData(data);
	}


	/**
     * Hidden Constructor
     *  
     * @param appearance BwtTableAppearance
     */
    protected BwtTableCell (BwtTableAppearance appearance)
    {
        super(appearance);
        
        this.jQueryBridge = new JQueryBridge<T>(this);
        this.tableConfig = new TableConfig<T>();        
        this.columnConfigs = new ArrayList<ColumnConfig<T>>();
        
        this.footerCallback = new FooterCallback<T>();
        this.tableConfig.setFooterCallback(this.footerCallback);
       
        this.setSelectMode(SelectMode.SINGLE);
        
        this.bindTable();
    }
    
    
    /**
     * 
     * @param model T
     */
    public void add (T model)
	{
    	this.addRow(this.tableHandle, model);
	}


	/**
     * 
     * @param columnConfig ColumnConfig
     */
    public void addColumnConfig (ColumnConfig<T> columnConfig)
    {
        this.getColumnConfigs().add(columnConfig);   
    }
    
    
    /**
     * 
     */
    public void clearData ()
	{
		this.getJQueryBridge().clear();		
	}


	/**
     * 
     * @return TableFooter<T>
     */
    public TableFooter<T> getFooter ()
	{
		if (this.footer == null)
		{
			this.setFooter(new TableFooter<T>());
		}
		
		return this.footer;
	}


    /**
     * 
     */
	public void redraw ()
	{
		this.getJQueryBridge().draw();		
	}


	/**
     * 
     * @param data JsArray<T>
     */
    public void setData (JsArray<T> data)
    {
        if (!this.hasBeenAttached())
        {
            this.getTableConfig().setData(data);
        }
        else
        {
        	this.clearData();
        	this.getJQueryBridge().setData(data);
        	this.redraw();
        }
    }
    
    
    /**
     * 
     * @param footer TableFooter<T>
     */
    public void setFooter (TableFooter<T> footer)
	{
		if (this.footer != null)
		{
			this.remove(this.footer);
		}
		
		this.add(footer);
		this.footer = footer;
	}


	/**
	 * 
	 * @param paginated boolean
	 */
	public void setPaginated (boolean paginated)
	{
		if (!this.hasBeenAttached())
        {
            this.getTableConfig().setPaginated(paginated);
        }
	}

	
	/**
	 * 
	 * @param searchable boolean
	 */
	public void setSearchable (boolean searchable)
	{
		if (!this.hasBeenAttached())
        {
            this.getTableConfig().setSearchable(searchable);
        }
	}


	/**
     * 
     * @param selectMode SelectMode
     */
    public void setSelectMode (SelectMode selectMode)
    {
        if (!this.hasBeenAttached())
        {
            this.getTableConfig().setSelectMode(selectMode);
        }
    }


    /**
	 * 
	 * @param showInfo
	 */
	public void setShowInfo (boolean showInfo)
	{
		if (!this.hasBeenAttached())
        {
            this.getTableConfig().setShowInfo(showInfo);
        }
	}


	/**
	 * 
	 * @param striped boolean
	 */
	public void setStriped (boolean striped)
	{
	    this.getAppearance().setStriped(striped);
	}


	/**
	 * 
	 */
	protected void bindTable ()
	{
		this.footerCallback.addFooterCallbackHandler(new FooterCallbackHandler() {
			public void onFooterCallback (FooterCallbackEvent event) {
				if (BwtTableCell.this.getFooter() != null){
					BwtTableCell.this.getFooter().onFooterCallback(event);
				}
			}
		});
	}


	/**
     * 
     * @return BwtTableAppearance
     */
    protected BwtTableAppearance getAppearance ()
    {
       return  (BwtTableAppearance) super.getAppearance();
    }
    
    
    /**
     * 
     * @return List<ColumnConfig<T>>
     */
    protected List<ColumnConfig<T>> getColumnConfigs ()
    {
        return this.columnConfigs;
    }


    /**
     * 
     * @return JQueryBridge<T>
     */
    protected JQueryBridge<T> getJQueryBridge ()
	{
		return this.jQueryBridge;
	}


	/**
     * 
     * @return TableConfig<T>
     */
    protected TableConfig<T> getTableConfig ()
    {
         return this.tableConfig;
    }


    /**
     * 
     */
    protected void onInitialAttach ()
    {
        this.getTableConfig().setColumnConfigs(this.getColumnConfigs());
        
        this.tableHandle = this._init(this.getId(), this.getTableConfig().getJavaScriptObject());
        
        this.getJQueryBridge().exportCutomHandlers();
    }


    /**
     * 
     * @param id String
     * @param tableConfig TableConfig
     */
    private native void addRow (JavaScriptObject tableHandle, JavaScriptObject row) /*-{
        
        tableHandle.row.add(row).draw();
        
    }-*/;
    
    
    /**
     * 
     * @param id String
     * @param tableConfig TableConfig
     */
    private native JavaScriptObject _init (String id, JavaScriptObject tableConfig) /*-{
        
        var t = $wnd.$("#" + id).DataTable(tableConfig);
        return t;
                
    }-*/;

}
