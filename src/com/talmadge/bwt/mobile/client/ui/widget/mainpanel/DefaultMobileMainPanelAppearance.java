package com.talmadge.bwt.mobile.client.ui.widget.mainpanel;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.DefaultBwtPanelAppearance;

/**
 * 
 *
 */
public class DefaultMobileMainPanelAppearance extends DefaultBwtPanelAppearance implements MobileMainPanelAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultMobileMainPanelAppearance ()
	{
		super(Document.get().createDivElement());
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		super.build();
		
		this.ensureCssName("mobile-main-panel");
	}
}
