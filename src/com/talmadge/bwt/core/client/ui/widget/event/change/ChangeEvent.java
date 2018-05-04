package com.talmadge.bwt.core.client.ui.widget.event.change;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 * @author Noah
 *
 * @param <T>
 */
public class ChangeEvent<T> extends GwtEvent<ChangeHandler<T>>
{
	/**
	 */
	private static final GwtEvent.Type<ChangeHandler<?>> TYPE = new GwtEvent.Type<ChangeHandler<?>>();
	
	/**
	 */
	private T oldValue;
	
	/**
	 */
	private T newValue;
		
	
	/**
	 * 
	 * @param oldValue T
	 * @param newValue T
	 */
	public ChangeEvent (T oldValue, T newValue)
	{
		super();
		
		this.oldValue = oldValue;
		this.newValue = newValue;
	}


	/**
	 * 
	 * @return GwtEvent.Type<ChangeHandler<?>>
	 */
	public static GwtEvent.Type<ChangeHandler<?>> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 * 
	 * @return GwtEvent.Type
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GwtEvent.Type<ChangeHandler<T>> getAssociatedType ()
	{
		return (GwtEvent.Type) TYPE;
	}

	
	/**
	 * 
	 * @return T
	 */
	public T getOldValue ()
	{
		return this.oldValue;
	}

	
	/**
	 * 
	 * @return T
	 */
	public T getNewValue ()
	{
		return this.newValue;
	}

	
	/**
	 * 
	 * @return T
	 */
	public T getValue ()
	{
		return this.newValue;
	}
	

	/**
	 * 
	 * @param handler ChangeHandler<T>
	 */
	protected void dispatch (ChangeHandler<T> handler)
	{
		handler.onChange(this);
	}
}
