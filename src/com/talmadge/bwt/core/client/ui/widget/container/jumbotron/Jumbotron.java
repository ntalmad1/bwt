package com.talmadge.bwt.core.client.ui.widget.container.jumbotron;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 * @author Noah
 *
 */
public class Jumbotron extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public Jumbotron ()
	{           
		this((JumbotronAppearance) GWT.create(DefaultJumbotronAppearance.class));
	}
	
	
	/**
	 * Constructor 
	 * 
	 * @param appearance BwtRowAppearance
	 */
	protected Jumbotron (JumbotronAppearance appearance)
	{
		super(appearance);
	}


    /**
	 * 
	 * @return BwtRowAppearance
	 */
	protected JumbotronAppearance getAppearance ()
	{
		return (JumbotronAppearance) super.getAppearance();
	}
}
