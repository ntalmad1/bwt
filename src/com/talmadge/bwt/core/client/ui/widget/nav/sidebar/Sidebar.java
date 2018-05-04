package com.talmadge.bwt.core.client.ui.widget.nav.sidebar;

import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.nav.AbstractNav;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 * @author Noah
 *
 */
public class Sidebar extends AbstractNav
{
	/**
	 * Constructor 
	 * 
	 */
	public Sidebar ()
	{
		this(new NavGroup());
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param navGroup NavGroup
	 */
	public Sidebar (NavGroup navGroup)
	{
		super(new SidebarCell());
		
		
		this.setNavGroup(navGroup);
		
	}

	
	/**
	 * 
	 * @param navItem NavItem
	 */
	public void add (NavItem navItem)
	{
	    if (this.hasScrollSpy() && !navItem.wasScrollToSet())
        {
            navItem.setScrollTo(true);
        }
	    
		this.getCell().add(navItem);	
	}

	
	/**
	 * 
	 * @param handler ItemAddHandler
	 * @return HandlerRegistration
	 */
    public HandlerRegistration addItemAddHandler (ItemAddHandler handler)
    {
        return this.getCell().addItemAddHandler(handler);
    }


    /**
	 * 
	 */
	public void clear ()
    {
	    this.getCell().clear();
    }


    /**
	 * 
	 * @return NavItem
	 */
	public NavItem getFirstItem ()
	{
		return this.getCell().getFirstItem();
	}


	/**
	 * 
	 * @return boolean 
	 */
	public boolean isAffix ()
	{
		return this.getCell().isAffix();
	}


    /**
	 * 
	 * @param navItem NavItem
	 */
	public void setActive (NavItem navItem)
	{
		this.getCell().setActive(navItem);		
	}


	/**
	 * 
	 * @param affix boolean
	 */
	public void setAffix (boolean affix)
	{
		this.getCell().setAffix(affix);
	}


	/**
	 * 
	 * @param navGroup NavGroup
	 */
	public void setNavGroup (NavGroup navGroup)
	{
		this.getCell().setNavGroup(navGroup);
	}

	
	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetBottom (int offset)
	{
		this.getCell().setOffsetBottom(offset);		
	}
	

	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetTop (int offset)
	{
		this.getCell().setOffsetTop(offset);		
	}


	/**
	 * 
	 * @return String
	 */
	public String getId ()
	{
		return this.getCell().getId();
	}


	/**
	 * 
	 * @return SidebarCell
	 */
	protected SidebarCell getCell ()
	{
		return (SidebarCell) super.getCell();
	}
}
