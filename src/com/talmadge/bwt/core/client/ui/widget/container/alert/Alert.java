package com.talmadge.bwt.core.client.ui.widget.container.alert;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.AlertStyle;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 * @author Noah
 *
 */
public abstract class Alert extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public Alert ()
	{           
		this((AlertAppearance) GWT.create(DefaultAlertAppearance.class));
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param appearance BwtRowAppearance
	 */
	protected Alert (AlertAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @param style AlertStyle
	 */
	public void setStyle (AlertStyle style)
	{
		this.getAppearance().setStyle(style);
	}
	
	
	/**
	 * 
	 * @return BwtRowAppearance
	 */
	protected AlertAppearance getAppearance ()
	{
		return (AlertAppearance) super.getAppearance();
	}
}
