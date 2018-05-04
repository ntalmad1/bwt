package com.talmadge.bwt.core.client.ui.widget.container.footer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.layout.container.LayoutContainer;

/**
 * 
 * 
 */
public class BwtFooter extends BwtWidgetContainer
{
	/**
	 */
	private LayoutContainer body;


	/**
	 * Constructor
	 * 
	 */
	public BwtFooter ()
	{
		this((BwtFooterAppearance) GWT.create(DefaultBwtFooterAppearance.class));
	}
	

	/**
	 * Hidden Constructor
	 * 
	 * @param appearance BwtFooterAppearance
	 */
	protected BwtFooter (BwtFooterAppearance appearance)
	{
		super(appearance);	
		
		this.body = new LayoutContainer();
		super.add(this.body);
	}
	
	
	/**
	 * 
	 * @param widget Widget
	 */
	public void add (Widget widget)
	{
		this.getBody().add(widget);
	}
	
	/**
	 * 
	 * @return LayoutContainer
	 */
	public LayoutContainer getBody ()
	{
		return this.body;
	}

}
