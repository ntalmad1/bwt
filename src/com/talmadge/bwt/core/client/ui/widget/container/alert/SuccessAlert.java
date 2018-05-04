package com.talmadge.bwt.core.client.ui.widget.container.alert;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.AlertStyle;

/**
 * 
 * @author Noah
 *
 */
public class SuccessAlert extends Alert
{
	/**
	 * Constructor
	 * 
	 */
	public SuccessAlert ()
	{
		super();
		this.setStyle(AlertStyle.SUCCESS);
	}
}
