package com.talmadge.bwt.core.client.ui.widget.container.collapse;

import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultCollapseAppearance extends DefaultBwtWidgetContainerAppearance implements CollapseAppearance
{
	/**
	 * 
	 * @param element
	 */
	public DefaultCollapseAppearance ()
	{
		super();
	}
	

	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("collapse");		
	}

	
	/**
	 * 
	 */
    @Override
    public void collapse ()
    {
        this.toggleCssName("in", false);
    }
}
