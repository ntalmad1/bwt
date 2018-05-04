package com.talmadge.bwt.core.client.ui.dom;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;

/**
 * @author Noah
 *
 */
public final class BwtDom
{
	/**
	 */
	private static BwtDom instance;
	
	
	/**
	 * 
	 * @return BwtDom
	 */
	public static BwtDom getInstance ()
	{
		if (instance == null)
		{
			instance = new BwtDom();
		}
		
		return instance;
	}
	
	
	/**
	 * @return Element
	 */
	public static Element createBElement ()
	{
		return DOM.createElement("b");
	}


	/**
	 * 
	 * @return Element
	 */
	public static Element createNavElement ()
	{
		return DOM.createElement("nav");
	}
	
	
	/**
	 */
	private HandlerManager handlerManager;
	
	/**
	 */
	private HandlerRegistration nativeEventHandlerReg;
	
	
	/**
	 * Hidden Constructor
	 * 
	 */
	private BwtDom ()
	{
		
	}

	/**
	 * 
	 * @param keyPressHandler KeyPressHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addKeyPressHandler (KeyPressHandler keyPressHandler)
	{
		this.ensureEventHandling();
		
		return this.handlerManager.addHandler(KeyPressEvent.getType(), keyPressHandler);
	}

	
	/**
	 * 
	 * @return HandlerRegistration
	 */
	protected HandlerRegistration getNativeEventHandlerReg ()
	{
		return this.nativeEventHandlerReg;
	}


	/**
	 * 
	 * @param event
	 */
	protected void onKeyPress (NativePreviewEvent event)
	{
		KeyPressEvent.fireNativeEvent(event.getNativeEvent(), this.handlerManager);
	}


	/**
	 * 
	 */
	private void ensureEventHandling ()
	{
		if (this.handlerManager == null)
		{
			this.handlerManager = new HandlerManager(this);
			
			this.nativeEventHandlerReg = Event.addNativePreviewHandler(new NativePreviewHandler()
			{
				public void onPreviewNativeEvent (NativePreviewEvent event) {					
						switch (event.getTypeInt()) {
							case Event.ONKEYPRESS:
								BwtDom.this.onKeyPress(event);
								break;
							default:
								break;
						}
				}
			});
		}		
	}
}
