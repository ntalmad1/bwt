package com.talmadge.bwt.mobile.client.ui.widget.event;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * 
 *
 */
public class HammerEventBridge implements MobileEventBridge
{
	/**
	 */
	private JavaScriptObject jsInstance;
	
	
	
	/**
	 * Constructor
	 *  
	 * @param element
	 */
	public HammerEventBridge (Element element)
	{
		this(element, new HammerConfig());
	}

	
	/**
	 * Constructor
	 * 
	 * @param element
	 * @param config
	 */
	public HammerEventBridge (Element element, HammerConfig config)
	{
		this.jsInstance = this._createInstance(element, config.getJavaScriptObject());
		
		this._bindSwipeRight(this.jsInstance);
	}


	/**
	 * 
	 * @param jsInstance JavaScriptObject
	 */
	private native void _bindSwipeRight (JavaScriptObject jsInstance) /*-{
		jsInstance.on('swiperight', function(event) {
			$wnd.alert('swiperight');
		});
	}-*/;


	/**
	 * 
	 * @param element Element
	 * @param config JavaScriptObject
	 * @return
	 */
	private native JavaScriptObject _createInstance (Element element, JavaScriptObject config) /*-{
		var hammertime = new $wnd.Hammer(element, config);
		return hammertime;
	}-*/;
}
