package com.talmadge.bwt.core.client.ui.widget.event.afterhide;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 * @param <W> extends BwtWidget
 */
public class AfterHideEvent<W extends BwtWidget> extends GwtEvent<AfterHideHandler<W>>
{
	/**
	 */
	private static final GwtEvent.Type<AfterHideHandler<?>> TYPE = new GwtEvent.Type<AfterHideHandler<?>>();
	
	/**
	 * 
	 * @return GwtEvent.Type<HideHandler<?>>
	 */
	public static GwtEvent.Type<AfterHideHandler<?>> getType ()
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
	public AfterHideEvent (W widget)
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
    protected void dispatch (AfterHideHandler<W> handler)
    {
	    handler.onAfterHide(this);	    
    }

}
