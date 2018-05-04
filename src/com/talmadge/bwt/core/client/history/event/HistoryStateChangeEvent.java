package com.talmadge.bwt.core.client.history.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 *
 */
public class HistoryStateChangeEvent extends GwtEvent<HistoryStateChangeHandler>
{
    /**
     */
    private static final GwtEvent.Type<HistoryStateChangeHandler> TYPE = new GwtEvent.Type<HistoryStateChangeHandler>();
    
    
    
    /**
     * 
     * @return GwtEvent.Type<HideHandler<?>>
     */
    public static GwtEvent.Type<HistoryStateChangeHandler> getType ()
    {
        return TYPE;
    }
    
    
    
    /**
     */
    private String prevUrl;
    
    
    /**
     */
    private String url;
    
    
    
    /**
     * Constructor
     * 
     * @param url String
     */
    public HistoryStateChangeEvent (String url)
    {
        super();
        
        this.url = url;
    }


    /**
     * Constructor
     * 
     * @param prevUrl String
     * @param url String
     */
    public HistoryStateChangeEvent (String prevUrl, String url)
    {
        this(url);
        
        this.prevUrl = prevUrl;
    }



    /**
     * 
     * @return GwtEvent.Type<HistoryStateChangeHandler>
     */
    @Override
    public GwtEvent.Type<HistoryStateChangeHandler> getAssociatedType ()
    {
        return TYPE;
    }
    
    
    /**
     * 
     * @return String
     */
    public String getUrl ()
    {
        return this.url;
    }
    
    
    /**
     * 
     * @return String
     */
    public String getPrevUrl ()
    {
        return this.prevUrl;
    }
    
    
    /**
     * 
     *  @param handler HistoryStateChangeHandler
     */
    @Override
    protected void dispatch (HistoryStateChangeHandler handler)
    {
        handler.onHistoryStateChange(this);
    }

}
