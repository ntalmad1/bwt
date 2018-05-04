package com.talmadge.bwt.core.client.ui.widget.container.contentpanel.head;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class BwtContentPanelHead extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public BwtContentPanelHead ()
	{
		this((BwtContentPanelHeadAppearance) GWT.create(DefaultBwtContentPanelHeadAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance BwtContentPanelAppearance
	 */
	protected BwtContentPanelHead (BwtContentPanelHeadAppearance appearance)
	{
		super(appearance);
		
	}
	
	
	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.getAppearance().setIcon(icon);		
	}


	/**
	 * 
	 * @param title String
	 */
	public void setTitle (String title)
	{
		this.getAppearance().setTitle(title);
	}
	
	
	/**
	 * 
	 * @return BwtContentPanelHeadAppearance
	 */
	protected BwtContentPanelHeadAppearance getAppearance ()
	{
		return (BwtContentPanelHeadAppearance) super.getAppearance();
	}

}
