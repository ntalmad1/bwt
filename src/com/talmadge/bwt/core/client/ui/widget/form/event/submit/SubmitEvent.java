package com.talmadge.bwt.core.client.ui.widget.form.event.submit;

import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 *
 */
public class SubmitEvent extends GwtEvent<SubmitHandler> 
{
	/**
	 */
	private static final GwtEvent.Type<SubmitHandler> TYPE = new GwtEvent.Type<SubmitHandler>();

	
	/**
	 * 
	 * @return GwtEvent.Type<SubmitHandler>
	 */
	public static GwtEvent.Type<SubmitHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 * Constructor
	 * 
	 */
	public SubmitEvent ()
	{
		super();
	}
	
	
	/**
	 *
	 * @return GwtEvent.Type<SubmitHandler>
	 */
	@Override
	public GwtEvent.Type<SubmitHandler> getAssociatedType ()
	{
		return TYPE;
	}
	
	
	/**
	 * 
	 * @param handler SubmitHandler
	 */
	@Override
	protected void dispatch (SubmitHandler handler)
	{
		handler.onSubmit(this);
	}
}
