package com.talmadge.bwt.core.client.ui.widget.container.collapse;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 * @author Noah
 *
 */
public class Collapse extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public Collapse ()
	{           
		this((CollapseAppearance) GWT.create(DefaultCollapseAppearance.class));
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param appearance BwtRowAppearance
	 */
	protected Collapse (CollapseAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 */
	public void collapse ()
    {
	    this.getAppearance().collapse();        
    }


    /**
	 * 
	 * @return BwtRowAppearance
	 */
	protected CollapseAppearance getAppearance ()
	{
		return (CollapseAppearance) super.getAppearance();
	}
}
