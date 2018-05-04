package com.talmadge.bwt.core.client.ui.widget.component;

import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;

/**
 * 
 *
 */
public class DefaultBwtComponentView extends BwtFlowPanel implements BwtComponentView
{
	/**
	 */
	private BwtComponent component;
	
	
	/**
	 * Constructor 
	 * 
	 * @param presenter
	 */
	public DefaultBwtComponentView (BwtComponent component)
	{
		super();
		this.component = component;
	}


	/**
	 * 
	 * @return BwtComponent
	 */
	protected BwtComponent getComponent ()
	{
		return this.component;
	}
	
	
	/**
	 * 
	 * @param component BwtComponent
	 */
	protected void setComponent (BwtComponent component)
	{
		this.component = component;
	}
}
