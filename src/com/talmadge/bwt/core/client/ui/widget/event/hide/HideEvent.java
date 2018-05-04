package com.talmadge.bwt.core.client.ui.widget.event.hide;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 * @param <W> extends BwtWidget
 */
public class HideEvent<W extends BwtWidget> extends GwtEvent<HideHandler<W>>
{
	/**
	 */
	private static final GwtEvent.Type<HideHandler<?>> TYPE = new GwtEvent.Type<HideHandler<?>>();
	
	/**
	 * 
	 * @return GwtEvent.Type<HideHandler<?>>
	 */
	public static GwtEvent.Type<HideHandler<?>> getType ()
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
	public HideEvent (W widget)
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
     * @param handler HideHandler<W>
     */
    protected void dispatch (HideHandler<W> handler)
    {
	    handler.onHide(this);	    
    }

}
