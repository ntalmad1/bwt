package com.talmadge.bwt.core.client.ui.widget.nav;

import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public abstract class DefaultNavAppearance extends DefaultBwtWidgetContainerAppearance implements NavAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultNavAppearance ()
	{
		super(Document.get().createElement("nav"));
	}
	
	
	/**
	 * 
	 * @param element DivElement
	 */
	protected DefaultNavAppearance (DivElement element)
	{
		super(element);
	}
}
