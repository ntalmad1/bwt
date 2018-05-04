package com.talmadge.bwt.core.client.ui.widget.form.event.keypress;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Event;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElement;

/**
 * 
 *
 */
@SuppressWarnings("rawtypes")
public class KeyPressEvent<T extends FormElement> extends GwtEvent<KeyPressHandler<T>>
{
	/**
	 */
	private static final GwtEvent.Type<KeyPressHandler<?>> TYPE = new  GwtEvent.Type<KeyPressHandler<?>>();

	
	/**
	 * 
	 * @return GwtEvent.Type<KeyUpHandler<?>>
	 */
	public static GwtEvent.Type<KeyPressHandler<?>> getType ()
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
	public KeyPressEvent (T source, Event browserEvent)
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
	public GwtEvent.Type<KeyPressHandler<T>> getAssociatedType ()
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
	protected void dispatch (KeyPressHandler<T> handler)
	{
		handler.onKeyPress(this);
	}
}
