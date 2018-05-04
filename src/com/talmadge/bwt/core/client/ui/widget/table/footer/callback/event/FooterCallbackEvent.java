package com.talmadge.bwt.core.client.ui.widget.table.footer.callback.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.shared.GwtEvent;

/**
 * 
 *
 */
public class FooterCallbackEvent extends GwtEvent<FooterCallbackHandler>
{
	/**
	 */
	private static final GwtEvent.Type<FooterCallbackHandler> TYPE = new GwtEvent.Type<FooterCallbackHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<FooterCallbackHandler>
	 */
	public static GwtEvent.Type<FooterCallbackHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 */
	private JavaScriptObject table;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public FooterCallbackEvent ()
	{
		super();
	}
	
	
	/**
	 * 
	 * @param table
	 */
	public FooterCallbackEvent (JavaScriptObject table)
	{
		this();
		
		this.table = table;
	}



	/**
	 * 
	 * @return GwtEvent.Type<FooterCallbackHandler>
	 */
	@Override
	public GwtEvent.Type<FooterCallbackHandler> getAssociatedType ()
	{
		return TYPE;
	}
	
	
	/**
	 * 
	 * @return JavaScriptObject
	 */
	public JavaScriptObject getNativeTable ()
	{
		return this.table;
	}
	
	
	/**
	 * 
	 * @param handler FooterCallbackHandler
	 */
	@Override
	protected void dispatch (FooterCallbackHandler handler)
	{
		handler.onFooterCallback(this);		
	}

}
