package com.talmadge.bwt.core.client.ui.widget.layout.panel;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 */
public class DefaultBwtPanelAppearance extends DefaultBwtWidgetContainerAppearance implements BwtPanelAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultBwtPanelAppearance ()
	{
		this(Document.get().createDivElement());
	}
	
	
	/**
	 * 
	 * @param element
	 */
	protected DefaultBwtPanelAppearance (Element element)
	{
		super(element);
	}


	/**
	 * 
	 */
	@Override
	protected void build ()
	{

		
	}

}
