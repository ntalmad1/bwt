package com.talmadge.bwt.core.client.ui.dom.style;

import com.google.gwt.dom.client.Style.HasCssName;

/**
 * 
 * @author Noah
 *
 */
public class CssName implements HasCssName
{
	/**
	 */
	private String cssName;

	
	/**
	 * Constructor 
	 *
	 * @param cssName String
	 */
	public CssName (String cssName)
	{
		this.cssName = cssName;
	}
	
	
	/**'
	 * 
	 * @return String
	 */
	public String getCssName ()
	{
		return this.cssName;
	}

}
