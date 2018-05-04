package com.talmadge.bwt.core.client.ui.widget.container.simple;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.ui.Panel;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class SimpleWidgetContainer extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public SimpleWidgetContainer ()
	{
		this((SimpleWidgetContainerAppearance) GWT.create(DefaultSimpleContainerAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param appearance SimpleWidgetContainerAppearance
	 */
	protected SimpleWidgetContainer (SimpleWidgetContainerAppearance appearance)
	{
		super(appearance);
	}

	
	/**
	 * 
	 * @param panel
	 */
	public SimpleWidgetContainer (Panel panel)
	{
		this(new DefaultSimpleContainerAppearance(panel));
		
		if (panel.isAttached())
		{
			BwtWidgetUtils.attachWidget(this);
		}
	}

}
