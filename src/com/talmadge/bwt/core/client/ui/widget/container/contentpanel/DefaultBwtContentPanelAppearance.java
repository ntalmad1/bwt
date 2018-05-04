package com.talmadge.bwt.core.client.ui.widget.container.contentpanel;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentPanelStyle;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultBwtContentPanelAppearance extends DefaultBwtWidgetContainerAppearance implements BwtContentPanelAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultBwtContentPanelAppearance ()
	{
		super(Document.get().createDivElement());
	}
	
	
	/**
	 * 
	 * @param style ContentPanelStyle
	 */
	@Override
	public void setContentPanelStyle (ContentPanelStyle style)
	{
		this.removeCssNames(ContentPanelStyle.values());
		this.ensureCssName(style);		
	}
	

	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.ensureCssName("panel");
		
		this.ensureCssName("panel-default");
	}
}
