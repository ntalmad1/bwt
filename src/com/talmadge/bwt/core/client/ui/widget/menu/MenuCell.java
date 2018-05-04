package com.talmadge.bwt.core.client.ui.widget.menu;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.MenuAlign;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 * @author Noah
 *
 */
public class MenuCell extends BwtWidgetContainer
{
	/**
	 * Constructor
	 * 
	 */
	public MenuCell ()
	{
		this((MenuAppearance) GWT.create(DefaultMenuAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param appearance MenuAppearance
	 */
	protected MenuCell (MenuAppearance appearance)
	{
		super(appearance);
	}

	
	/**
	 * 
	 * @param menuAlign MenuAlign
	 */
	public void setMenuAlign (MenuAlign menuAlign)
	{
		this.getAppearance().setMenuAlign(menuAlign);		
	}
	
	
	/**
	 * 
	 * @return MenuCellAppearance
	 */
	public MenuAppearance getAppearance ()
	{
		return (MenuAppearance) super.getAppearance();
	}
}
