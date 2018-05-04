package com.talmadge.bwt.mobile.client.ui.widget.navbar.header;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultMobileNavBarHeaderAppearance extends DefaultBwtWidgetContainerAppearance implements MobileNavBarHeaderAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultMobileNavBarHeaderAppearance ()
	{
		super(Document.get().createDivElement());
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.ensureCssName("navbar-header");
		
	}

}
