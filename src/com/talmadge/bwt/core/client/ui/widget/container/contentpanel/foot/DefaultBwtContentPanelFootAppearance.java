package com.talmadge.bwt.core.client.ui.widget.container.contentpanel.foot;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultBwtContentPanelFootAppearance extends DefaultBwtWidgetContainerAppearance implements BwtContentPanelFootAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultBwtContentPanelFootAppearance ()
	{
		super(Document.get().createDivElement());
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.ensureCssName("panel-heading");
		this.ensureCssName("bwt-content-panel-footer");
		
	}
}
