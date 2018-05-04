package com.talmadge.bwt.core.client.ui.widget.event.select;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author Noah
 * 
 * @param <T> 
 */
public class SelectEvent<T> extends GwtEvent<SelectHandler<T>>
{
	/**
	 */
	private static final GwtEvent.Type<SelectHandler<?>> TYPE = new GwtEvent.Type<SelectHandler<?>>();
	
	
	
	/**
	 * 
	 * @return GwtEvent.Type<SelectHandler>
	 */
	public static GwtEvent.Type<SelectHandler<?>> getType ()
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
	public SelectEvent (T source)
	{
		super();
		
		this.source = source;
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type<SelectHandler>
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GwtEvent.Type<SelectHandler<T>> getAssociatedType ()
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
	 * @param handler SelectHandler
	 */
	protected void dispatch (SelectHandler<T> handler)
	{
		handler.onSelect(this);		
	}
}
