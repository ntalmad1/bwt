package com.talmadge.bwt.core.client.ui.widget.nav.simple;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.widget.nav.NavCell;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class SimpleNavCell extends NavCell
{
	/**
	 */
	private NavGroup navGroup;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public SimpleNavCell ()
	{
		this((SimpleNavAppearance) GWT.create(DefaultSimpleNavAppearance.class));
	}
	
	
	/**
	 * 
	 * @param appearance SimpleNavAppearance
	 */
	protected SimpleNavCell (SimpleNavAppearance appearance)
	{
		super(appearance);

		
		this.navGroup = new NavGroup();
		this.add(this.navGroup);
	}
	
	
	/**
	 * 
	 * @param navItem NavItem
	 */
	public void add (NavItem navItem)
	{
		this.navGroup.add(navItem);
	}
	
	
	
	/**
     * 
     * @return NavGroup
     */
	public NavGroup getNavGroup ()
	{
		return this.navGroup;
	}

}
