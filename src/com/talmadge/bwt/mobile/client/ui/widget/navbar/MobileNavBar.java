package com.talmadge.bwt.mobile.client.ui.widget.navbar;

import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.mobile.client.ui.widget.navbar.navitem.DrawerNavItem;

/**
 * 
 */
public class MobileNavBar extends BwtComposite
{
	/**
	 * 
	 */
	private MobileNavBarCell cell;
	
	
	/**
	 * Constructor
	 * 
	 */
	public MobileNavBar ()
	{
		super();
		
		this.cell = new MobileNavBarCell();
		this.initWidget(this.cell);
	}
	
	
	
	/**
	 * 
	 * @return MobileNavBarCell
	 */
	protected MobileNavBarCell getCell ()
	{
		return this.cell;
	}


	
	/**
	 * 
	 * @param drawerNavItem DrawerNavItem
	 */
	public void addDrawerNavItem (DrawerNavItem drawerNavItem)
	{
		this.getCell().addDrawerNavItem(drawerNavItem);		
	}
}
