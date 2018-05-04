package com.talmadge.bwt.core.client.ui.widget.form.event.valueinput;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
@SuppressWarnings("rawtypes")
public class ValueInputEvent<T extends FormElement, V> extends GwtEvent<ValueInputHandler<T, V>>
{
	/**
	 */
	private static final GwtEvent.Type<ValueInputHandler<?, ?>> TYPE = new  GwtEvent.Type<ValueInputHandler<?, ?>>();

	
	/**
	 * 
	 * @return GwtEvent.Type<KeyUpHandler<?, ?>>
	 */
	public static GwtEvent.Type<ValueInputHandler<?, ?>> getType ()
	{
		return TYPE;
	}

	
	/**
	 */
	private V previousValue;
	
	/**
	 */
	private T source;
	
	/**
	 */
	private V value;
	
	
	
	/**
	 * Constructor
	 * 
	 * @param source T
	 */
	public ValueInputEvent (T source, V previousValue, V value)
	{
		super();
		
		this.source = source;
		this.previousValue = previousValue;
		this.value = value;
	}
	

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public GwtEvent.Type<ValueInputHandler<T, V>> getAssociatedType ()
	{
		return (GwtEvent.Type) TYPE;
	}
	
	
	/**
	 * 
	 * @return V
	 */
	public V getPreviousValue ()
	{
		return this.previousValue;
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
	 * @return V
	 */
	public V getValue ()
	{
		return this.value;
	}
	
	
	/**
	 * 
	 * @param handler KeyUpHandler<T>
	 */
	@Override
	protected void dispatch (ValueInputHandler<T, V> handler)
	{
		handler.onValueChange(this);
	}
}
