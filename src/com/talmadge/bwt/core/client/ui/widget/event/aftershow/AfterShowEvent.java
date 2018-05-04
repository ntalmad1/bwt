package com.talmadge.bwt.core.client.ui.widget.event.aftershow;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * @author Noah
 * 
 * @param <W> extends BwtWidget
 */
public class AfterShowEvent<W extends BwtWidget> extends GwtEvent<AfterShowHandler<W>>
{
	/**
	 */
	private static final GwtEvent.Type<AfterShowHandler<?>> TYPE = new GwtEvent.Type<AfterShowHandler<?>>();
	
	/**
	 * 
	 * @return GwtEvent.Type<ShowHandler<?>>
	 */
	public static GwtEvent.Type<AfterShowHandler<?>> getType ()
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
	public AfterShowEvent (W widget)
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
    protected void dispatch (AfterShowHandler<W> handler)
    {
	    handler.onAfterShow(this);	    
    }

}
