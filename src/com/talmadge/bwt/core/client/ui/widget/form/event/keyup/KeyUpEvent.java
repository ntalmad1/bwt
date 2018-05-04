package com.talmadge.bwt.core.client.ui.widget.form.event.keyup;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
@SuppressWarnings("rawtypes")
public class KeyUpEvent<T extends FormElement> extends GwtEvent<KeyUpHandler<T>>
{
	/**
	 */
	private static final GwtEvent.Type<KeyUpHandler<?>> TYPE = new  GwtEvent.Type<KeyUpHandler<?>>();

	
	/**
	 * 
	 * @return GwtEvent.Type<KeyUpHandler<?>>
	 */
	public static GwtEvent.Type<KeyUpHandler<?>> getType ()
	{
		return TYPE;
	}

	
	/**
	 */
	private T source;
	
	/**
	 */
	private Event browserEvent;

	
	
	/**
	 * Constructor
	 * 
	 * @param source T
	 */
	public KeyUpEvent (T source, Event browserEvent)
	{
		super();
		
		this.source = source;
		this.browserEvent = browserEvent;
	}
	

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public GwtEvent.Type<KeyUpHandler<T>> getAssociatedType ()
	{
		return (GwtEvent.Type) TYPE;
	}

	
	/**
	 * 
	 * @return Event
	 */
	public Event getBrowserEvent ()
	{
		return this.browserEvent;
	}
	
	
	/**
	 * 
	 * @return int
	 */
	public int getKeyCode ()
	{
		return this.getBrowserEvent().getKeyCode();
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
	 * @param handler KeyUpHandler<T>
	 */
	@Override
	protected void dispatch (KeyUpHandler<T> handler)
	{
		handler.onKeyUp(this);
	}
}
