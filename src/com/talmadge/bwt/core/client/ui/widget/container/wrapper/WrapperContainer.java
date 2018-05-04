package com.talmadge.bwt.core.client.ui.widget.container.wrapper;

import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;

/**
 * 
 *
 */
public class WrapperContainer extends BwtWidgetContainer implements BwtPanelInterface
{
	/**
	 * Constructor
	 * 
	 */
	public WrapperContainer (Element target)
	{			  
		super(new DefaultWrapperContainerAppearance(target));
	}
}
