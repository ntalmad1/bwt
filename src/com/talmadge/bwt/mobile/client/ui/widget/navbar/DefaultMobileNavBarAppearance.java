package com.talmadge.bwt.mobile.client.ui.widget.navbar;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.RootPanel;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultMobileNavBarAppearance extends DefaultBwtWidgetContainerAppearance implements MobileNavBarAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultMobileNavBarAppearance ()
	{
		super(Document.get().createElement("nav"));
	}
	
	
	/**
	 * 
	 */
	protected void build ()
	{
		this.ensureCssName("mobile-navbar");
		this.ensureCssName("navbar");
		this.ensureCssName("navbar-default");
		this.ensureCssName("navbar-fixed-top");
	}

	
	/**
	 * 
	 */
	@Override
	public void onAttach ()
	{
		this.ensureCssName(RootPanel.getBodyElement(), "drawer");
		this.ensureCssName(RootPanel.getBodyElement(), "drawer--left");
		this.ensureCssName(RootPanel.getBodyElement(), "mobile-navbar-pagebody");
	}

}
