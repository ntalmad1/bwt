package com.talmadge.bwt.core.client.ui.widget.event.show;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * @author Noah
 * 
 * @param <W> extends BwtWidget
 */
public class ShowEvent<W extends BwtWidget> extends GwtEvent<ShowHandler<W>>
{
	/**
	 */
	private static final GwtEvent.Type<ShowHandler<?>> TYPE = new GwtEvent.Type<ShowHandler<?>>();
	
	/**
	 * 
	 * @return GwtEvent.Type<ShowHandler<?>>
	 */
	public static GwtEvent.Type<ShowHandler<?>> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 */
	private W widget;
	
	
	
	/**
	 * Constructor
	 * 
	 * @param widget W
	 */
	public ShowEvent (W widget)
	{
		this.widget = widget;
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type<HideHandler<?>>
	 */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public GwtEvent.Type getAssociatedType ()
    {
	    return TYPE;
    }

    
    /**
     * 
     * @return W
     */
    public W getWidget ()
    {
    	return this.widget;
    }
    
	
    /**
     * 
     * @param handler ShowHandler<W>
     */
    protected void dispatch (ShowHandler<W> handler)
    {
	    handler.onShow(this);	    
    }

}
