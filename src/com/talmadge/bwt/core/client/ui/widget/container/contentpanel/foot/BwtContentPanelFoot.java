package com.talmadge.bwt.core.client.ui.widget.container.contentpanel.foot;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class BwtContentPanelFoot extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public BwtContentPanelFoot ()
	{
		this((BwtContentPanelFootAppearance) GWT.create(DefaultBwtContentPanelFootAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance BwtContentPanelAppearance
	 */
	protected BwtContentPanelFoot (BwtContentPanelFootAppearance appearance)
	{
		super(appearance);
		
	}

}
