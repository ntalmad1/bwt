package com.talmadge.bwt.core.client.ui.widget.event.click;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author Noah
 * 
 * @param <T> 
 */
public class ClickEvent<T> extends GwtEvent<ClickHandler<T>>
{
	/**
	 */
	private static final GwtEvent.Type<ClickHandler<?>> TYPE = new GwtEvent.Type<ClickHandler<?>>();
	
	
	
	/**
	 * 
	 * @return GwtEvent.Type<SelectHandler>
	 */
	public static GwtEvent.Type<ClickHandler<?>> getType ()
	{
		return TYPE;
	}

	
	/**
	 */
	private T source;

	
	
	/**
	 * Constructor
	 * 
	 * @param source T
	 */
	public ClickEvent (T source)
	{
		super();
		
		this.source = source;
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type<SelectHandler>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GwtEvent.Type<ClickHandler<T>> getAssociatedType ()
	{
		return (GwtEvent.Type) TYPE;
	}

	
	/**
	 * 
	 * @return T
	 */
	public T getSource ()
	{
		return this.source;
	}
	
	
	/**
	 * 
	 * @return T
	 */
	public T getValue ()
	{
		return this.source;
	}
	
	
	/**
	 * 
	 * @param handler ClickHandler<T>
	 */
	protected void dispatch (ClickHandler<T> handler)
	{
		handler.onClick(this);		
	}
}
