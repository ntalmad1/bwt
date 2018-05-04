package com.talmadge.bwt.mobile.client.ui.widget.navbar;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.nav.simple.SimpleNav;
import com.talmadge.bwt.mobile.client.ui.widget.navbar.header.MobileNavBarHeader;
import com.talmadge.bwt.mobile.client.ui.widget.navbar.navitem.DrawerNavItem;

/**
 * 
 *
 */
public class MobileNavBarCell extends BwtWidgetContainer 
{
	/**
	 */
	private Html container;
	
	/**
	 */
	private MobileNavBarHeader header;
	
	/**
	 */
	private SimpleNav drawer;


	/**
	 * Constructor
	 * 
	 */
	public MobileNavBarCell ()
	{
		this((MobileNavBarAppearance) GWT.create(DefaultMobileNavBarAppearance.class));
	}
	
	
	/**
	 * 
	 * @param appearance MobileNavBarAppearance
	 */
	protected MobileNavBarCell (MobileNavBarAppearance appearance)
	{
		super(appearance);
		
		
		this.container = Html.div();
		this.container.ensureCssName("container-fluid");
        this.add(this.container);
        
        this.header = new MobileNavBarHeader();
        
        this.container.add(this.header);	
        
        this.drawer = new SimpleNav();
        this.drawer.getNavGroup().ensureCssName("drawer-menu");
        this.drawer.ensureCssName("drawer-nav");
                
        
        this.add(this.drawer);
        
        
 	}
	
	
	/**
	 * 
	 * @param drawerNavItem DrawerNavItem
	 */
	public void addDrawerNavItem (DrawerNavItem drawerNavItem)
	{
		this.drawer.add(drawerNavItem);		
	}


	/**
	 * 
	 */
	protected void onInitialAttach ()
	{
		super.onInitialAttach();
		
		this.getAppearance().onAttach();
		this._initDrawer();
	}
	
	
	/**
	 * 
	 */
	protected void onAttach ()
	{
		super.onAttach();
		
		this.getAppearance().onAttach();
	}


	/**
	 * 
	 * @return MobileNavBarAppearance
	 */
	protected MobileNavBarAppearance getAppearance ()
	{
		return (MobileNavBarAppearance) super.getAppearance();
	}


	/**
	 * 
	 */
	private native void _initDrawer () /*-{
		$wnd.$('.drawer').drawer();
	}-*/;
}
