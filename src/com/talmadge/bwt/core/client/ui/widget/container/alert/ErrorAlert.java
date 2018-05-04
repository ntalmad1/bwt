package com.talmadge.bwt.core.client.ui.widget.container.alert;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.AlertStyle;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class ErrorAlert extends Alert
{
	/**
	 * Constructor
	 * 
	 */
	public ErrorAlert ()
	{
		super();
		this.setStyle(AlertStyle.DANGER);
	}

	
	/**
	 * 
	 * @param html String
	 */
	public ErrorAlert (String html)
	{
		this();
		
		this.add(new Html(html));
	}
}
