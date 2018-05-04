package com.talmadge.bwt.core.client.ui.widget.tooltip;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * 
 *
 */
public class TooltipHelper extends JavaScriptObject
{
	/**
	 * Hidden Constructor
	 */
	protected TooltipHelper ()
	{
		
	}
	
	
	/**
	 * 
	 * @return Element
	 */
	public final Element getTooltipElement ()
	{
		return this._getTooltipElement().cast();
	}

	
	/**
	 * 
	 * @return JavaScriptObject
	 */
	private final native JavaScriptObject _getTooltipElement () /*-{
		return this.tooltip;
	}-*/;
}
