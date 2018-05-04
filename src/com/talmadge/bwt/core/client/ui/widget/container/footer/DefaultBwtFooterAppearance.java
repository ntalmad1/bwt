package com.talmadge.bwt.core.client.ui.widget.container.footer;

import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultBwtFooterAppearance extends DefaultBwtWidgetContainerAppearance implements BwtFooterAppearance
{
	/**
	 * 
	 * @param element
	 */
	public DefaultBwtFooterAppearance ()
	{
		super();
	}
	

	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("bwt-footer");
		
		this.getElement().addClassName("navbar");
		
		this.getElement().addClassName("navbar-static-bottom");
		
		this.getElement().addClassName("navbar-inverse");
	}
}
