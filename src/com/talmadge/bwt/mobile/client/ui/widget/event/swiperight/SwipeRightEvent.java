package com.talmadge.bwt.mobile.client.ui.widget.event.swiperight;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 *
 */
public class SwipeRightEvent extends GwtEvent<SwipeRightHandler>
{
	/**
	 */
	private static GwtEvent.Type<SwipeRightHandler> TYPE = new GwtEvent.Type<SwipeRightHandler>();
	
	/**
	 * 
	 * @return 
	 */
	public static GwtEvent.Type<SwipeRightHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 * 
	 * 
	 */
	@Override
	public GwtEvent.Type<SwipeRightHandler> getAssociatedType ()
	{
		return TYPE;
	}
	
	
	/**
	 * 
	 * @param handler SwipeRightHandler
	 */
	@Override
	protected void dispatch (SwipeRightHandler handler)
	{
		handler.onSwipeRight(this);
	}
}
