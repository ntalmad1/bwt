package com.talmadge.bwt.core.client.ui.widget.container.jumbotron;

import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultJumbotronAppearance extends DefaultBwtWidgetContainerAppearance implements JumbotronAppearance
{
	/**
	 * 
	 * @param element
	 */
	public DefaultJumbotronAppearance ()
	{
		super();
	}
	

	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("well");		
	}
}
