package com.talmadge.bwt.core.client.ui.widget.container.alert;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.AlertStyle;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultAlertAppearance extends DefaultBwtWidgetContainerAppearance implements AlertAppearance
{
	/**
	 * 
	 * @param element
	 */
	public DefaultAlertAppearance ()
	{
		super();
	}
	

	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("alert");		
	}


	/**
	 * 
	 * @param style AlertStyle
	 */
	public void setStyle (AlertStyle style)
	{
		this.removeCssNames(AlertStyle.values());
		this.ensureCssName(style);
	}
}
