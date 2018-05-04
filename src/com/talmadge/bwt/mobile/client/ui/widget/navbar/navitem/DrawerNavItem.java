package com.talmadge.bwt.mobile.client.ui.widget.navbar.navitem;

import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class DrawerNavItem extends NavItem
{
	/**
	 * 
	 */
	public DrawerNavItem ()
	{
		super();
		
		this.ensureCssName("drawer-menu-item");
	}
	
	
	/**
	 * 
	 * @param text String
	 */
	public DrawerNavItem (String text)
	{
		this();
		
		this.setText(text);
	}
}
