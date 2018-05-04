package com.talmadge.bwt.core.client.ui.jqueryui;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * 
 *
 */
public class JQueryUi extends JavaScriptObject
{
	/**
	 * Hidden Constructor
	 * 
	 */
	protected JQueryUi ()
	{
		
	}

	
	final public native Element getElement () /*-{
		
		return this.helper;
		
	}-*/;
}
