package com.talmadge.bwt.core.client.history;

import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeEvent;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeHandler;

/**
 *
 */
public final class BwtHistory 
{
    /**
     */
    public enum MatchMode 
    {
        /**
         */
        BEGINS_WITH,
        
        /**
         */
        CONTAINS,
        
        /**
         */
        ENDS_WITH,
        
        /**
         */
        EQUALS;
    }
        
    
    /**
     */
    private static BwtHistory instance;
    
    
    
    /**
     * 
     */
    public static void init ()
    {
        if (BwtHistory.instance == null)
        {
            BwtHistory.instance = new BwtHistory();
        }
    }
    
    
    /**
     * 
     * @param baseUrl String 
     */
    public static void init (String baseUrl)
    {
        BwtHistory.init();
        
        BwtHistory.getInstance().setBaseUrl(baseUrl);
    }
    
    
    /**
     *  
     * @return BwtHistory
     */
    public static BwtHistory getInstance ()
    {
        BwtHistory.init();
        
        return BwtHistory.instance;
    }


    /**
     */
    private HandlerManager handlerManager;

    /**
     */
    private JQueryEventBridge jqBridge;
    
    /**
     */
    private String baseUrl;
    
    
    
    /**
     * Hidden Constructor
     * 
     */
    protected BwtHistory ()
    {
       this.handlerManager = new HandlerManager(this);
        
       this.jqBridge = new JQueryEventBridge(this); 
       this.jqBridge.attach();
       
    }
    
    
    /**
	 * 
	 * @param handler HistoryStateChangeHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addHistoryStateChangeHandler (HistoryStateChangeHandler handler)
	{
	    return BwtHistory.getInstance().addHandler(HistoryStateChangeEvent.getType(), handler);
	}


	/**
	 * Defaults to push(url, true)
	 * 
	 * @param url String
	 */
	public void push (String url)
	{
	    BwtHistory.getInstance().push(url, true);
	}
	
	/**
	 * 
	 * @param url String
	 * @param fireEvent boolean
	 */
	public void push (String url, boolean fireEvent)
	{
	    BwtHistory.getInstance().pushUrl(url, fireEvent);
	}

	
	/**
	 * 
	 * @param url String
	 */
	public void redirect (String url)
	{
		if (url.startsWith("/"))
        {
            if (this.getBaseUrl().endsWith("/"))
            {
                url = url.substring(1);
            }
            
            url = this.getBaseUrl() + url;
        }
        
        this.setLocation(url);
	}


	/**
	 * All GWT state will be lost.
	 * 
	 * @param url String
	 */
	public void setLocation (String url)
	{
		Window.Location.replace(url);		
	}


	/**
     * 
     * @param type GwtEvent.Type<?>
     * @param handler EventHandler
     * @return HandlerRegistration
     * @param <H> extends EventHandler
     */
    protected <H extends EventHandler> HandlerRegistration addHandler (GwtEvent.Type<H> type, H handler)
    {
        return this.getHandlerManager().addHandler(type, handler);
    }

    
    /**
     * 
     * @param event GwtEvent<?>
     */
    protected void fireEvent (GwtEvent<?> event)
    {
        this.handlerManager.fireEvent(event);        
    }

    
    /**
     * 
     * @return String
     */
    protected String getBaseUrl ()
    {
    	if (this.baseUrl == null)
    	{
    		this.setBaseUrl("/");
    	}
    	
        return this.baseUrl;
    }


    /**
     * 
     * @return HandlerManager
     */
    protected HandlerManager getHandlerManager ()
    {
        return this.handlerManager;
    }


    /**
     * 
     * @return jqBridge
     */
    protected JQueryEventBridge getJqBridge ()
    {
        return this.jqBridge;
    }
    
    
    /**
     * 
     * @param prevUrl String
     * @param url String
     */
    protected void onStateChange (String prevUrl, String url)
    {
        HistoryStateChangeEvent event = new HistoryStateChangeEvent(prevUrl, url);
        this.fireEvent(event);
    }

    
    /**
     * 
     * @param url String
     * @param fireEvent boolean
     */
    protected void pushUrl (String url, boolean fireEvent)
    {
        if (url.startsWith("/"))
        {
            if (this.getBaseUrl().endsWith("/"))
            {
                url = url.substring(1);
            }
            
            url = this.getBaseUrl() + url;
        }
        
        this._pushUrl(url, fireEvent);
        
    }
    
    
    /**
     * 
     * @param baseUrl String
     */
    protected void setBaseUrl (String baseUrl)
    {
        this.baseUrl = baseUrl;
    }


    /**
     * 
     * @param url String
     * @param fireEvent boolean
     */
    private native void _pushUrl (String url, boolean fireEvent) /*-{
        
        if (fireEvent)
        {
        	$wnd.history.pushState({"fireEvent": true}, "", url);
        }
        else
        {
           $wnd.history.pushState({}, "", url);
        }
        
  }-*/;
}
