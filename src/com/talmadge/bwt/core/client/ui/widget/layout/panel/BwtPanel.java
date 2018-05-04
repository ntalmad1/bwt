package com.talmadge.bwt.core.client.ui.widget.layout.panel;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class BwtPanel extends BwtWidgetContainer implements BwtPanelInterface
{
	public BwtPanel ()
	{
		this((BwtPanelAppearance) GWT.create(DefaultBwtPanelAppearance.class));
	}
	
	/**
	 * 
	 * @param appearance BwtPanelAppearance
	 */
	protected BwtPanel (BwtPanelAppearance appearance)
	{
		super(appearance);
	}
	
}
