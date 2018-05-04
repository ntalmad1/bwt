package com.talmadge.bwt.core.client.ui.widget.container.simple;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Panel;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultSimpleContainerAppearance extends DefaultBwtWidgetContainerAppearance implements SimpleWidgetContainerAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultSimpleContainerAppearance ()
	{
		super(Document.get().createDivElement());
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param panel
	 */
	public DefaultSimpleContainerAppearance (Panel panel)
	{
		String id = panel.getElement().getId();
	
		this.setElement(panel.getElement());
		this.getElement().setId(id);
	}

	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		
		
	}
}
