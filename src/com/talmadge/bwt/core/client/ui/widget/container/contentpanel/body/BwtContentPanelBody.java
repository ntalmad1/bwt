package com.talmadge.bwt.core.client.ui.widget.container.contentpanel.body;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class BwtContentPanelBody extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public BwtContentPanelBody ()
	{
		this((BwtContentPanelBodyAppearance) GWT.create(DefaultBwtContentPanelBodyAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance BwtContentPanelAppearance
	 */
	protected BwtContentPanelBody (BwtContentPanelBodyAppearance appearance)
	{
		super(appearance);
		
	}

}
