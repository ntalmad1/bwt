package com.talmadge.bwt.core.client.ui.widget.container.well;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.WellSize;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 * @author Noah
 *
 */
public class Well extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public Well ()
	{           
		this((WellAppearance) GWT.create(DefaultWellAppearance.class));
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param appearance BwtRowAppearance
	 */
	protected Well (WellAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @param size WellSize
	 */
	public void setWellSize (WellSize size)
	{
		this.getAppearance().setWellSize(size);
	}
	
	
	/**
	 * 
	 * @return BwtRowAppearance
	 */
	protected WellAppearance getAppearance ()
	{
		return (WellAppearance) super.getAppearance();
	}
}
