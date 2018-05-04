package com.talmadge.bwt.core.client.ui.widget.container.contentpanel.body;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultBwtContentPanelBodyAppearance extends DefaultBwtWidgetContainerAppearance implements BwtContentPanelBodyAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultBwtContentPanelBodyAppearance ()
	{
		super(Document.get().createDivElement());
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.ensureCssName("panel-body");
		
	}
}
