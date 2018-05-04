package com.talmadge.bwt.core.client.ui.widget.container.well;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.WellSize;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultWellAppearance extends DefaultBwtWidgetContainerAppearance implements WellAppearance
{
	/**
	 * 
	 * @param element
	 */
	public DefaultWellAppearance ()
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


	/**
	 * 
	 * @param size WellSize
	 */
	public void setWellSize (WellSize size)
	{
		this.removeCssNames(WellSize.values());
		this.ensureCssName(size.getCssName());
	}
}
