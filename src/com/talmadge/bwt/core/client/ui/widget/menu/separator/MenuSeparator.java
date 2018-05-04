package com.talmadge.bwt.core.client.ui.widget.menu.separator;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 */
public class MenuSeparator extends BwtWidget
{
	/**
	 * Constructor
	 * 
	 */
	public MenuSeparator ()
	{
		this((MenuSeparatorAppearance) GWT.create(DefaultMenuSeparatorAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param appearance MenuSeparatorAppearance
	 */
	protected MenuSeparator (MenuSeparatorAppearance appearance)
	{
		super(appearance);
		
		this.bind();
		
	}
	
	/**
	 * 
	 */
	protected void bind ()
	{
		
	}

	
	/**
	 * 
	 * @return MenuSeparatorAppearance
	 */
	protected MenuSeparatorAppearance getAppearance ()
	{
		return (MenuSeparatorAppearance) super.getAppearance();
	}
}
