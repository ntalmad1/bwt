package com.talmadge.bwt.core.client.ui.widget.nav.simple;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.nav.AbstractNav;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class SimpleNav extends AbstractNav
{	
	/**
	 * Constructor
	 *  
	 */
	public SimpleNav ()
	{
		this(new SimpleNavCell());
		
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param cell
	 */
	protected SimpleNav (SimpleNavCell cell)
	{
		super(cell);
		
	}


	@Override
	public void add (NavItem navItem)
	{
		this.getCell().add(navItem);
		
	}

	
	/**
	 * 
	 */
	@Override
	public String getId ()
	{
		return this.getElement().getId();
	}

	
	/**
	 * 
	 * @return NavGroup
	 */
	public NavGroup getNavGroup ()
	{
		return this.getCell().getNavGroup();
	}


	@Override
	public void setActive (NavItem navItem)
	{
		// TODO Auto-generated method stub
		
	}


	/**
	 * 
	 */
	@Override
	public HandlerRegistration addItemAddHandler (ItemAddHandler handler)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 
	 * @return SimpleNavCell
	 */
	protected SimpleNavCell getCell ()
	{
		return (SimpleNavCell) super.getCell();
	}

}
