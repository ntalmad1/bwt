package com.talmadge.bwt.core.client.ui.widget.menu.header;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 */
public class MenuHeader extends BwtWidget
{
	/**
	 * Constructor
	 * 
	 */
	public MenuHeader ()
	{
		this((MenuHeaderAppearance) GWT.create(DefaultMenuHeaderAppearance.class));
	}
	
	
	/**
	 * Constructor
	 *  
	 * @param text String
	 */
	public MenuHeader (String text)
	{
		this();
		
		this.setText(text);
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.getAppearance().setText(text);
	}


	/**
	 * Constructor
	 * 
	 * @param appearance MenuItemAppearance
	 */
	protected MenuHeader (MenuHeaderAppearance appearance)
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
	 * @return MenuHeaderAppearance
	 */
	protected MenuHeaderAppearance getAppearance ()
	{
		return (MenuHeaderAppearance) super.getAppearance();
	}
}
