package com.talmadge.bwt.core.client.ui.widget.nav.navitem;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.event.select.HasSelectHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;

/**
 * 
 * @author Noah
 *
 */
public class NavItem extends BwtComposite implements HasClickHandlers, HasSelectHandlers<NavItem>
{
	/**
	 */
	private NavItemCell cell;
	
	/**
	 */
	private boolean wasScrollToSet;
	
	
	/**
	 * Constructor 
	 *  
	 */
	public NavItem ()
	{
		this(new NavItemCell());
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param cell NavItemCell
	 */
	public NavItem (NavItemCell cell)
	{
	    super();
        
	    this.cell = cell;
	    this.cell.setNavItem(this);
	    this.initWidget(this.cell);
	}
	
	
	/**
	 * 
	 * @param text String
	 */
	public NavItem (String text)
	{
		this();
		
		this.setText(text);
	}

	
	/**
	 * Constructor 
	 *
	 * @param target String
	 * @param text String
	 */
	public NavItem (String target, String text)
	{
		this(text);
		this.setTarget(target);
	}

	
	/**
	 * 
	 * @param navItem NavItem
	 */
	public void add (NavItem navItem)
	{
		this.getCell().add(navItem);		
	}


	/**
	 * 
	 * @param clickHandler ClickHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addClickHandler (ClickHandler clickHandler)
	{
		return this.getCell().addClickHandler(clickHandler);		
	}
	
	
	/**
	 * 
	 * @param selectHandler SelectHandler<NavItem>
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSelectHandler (SelectHandler<NavItem> selectHandler)
    {
        return this.getCell().addSelectHandler(selectHandler);      
    }

	
	/**
	 * 
	 * @return boolean
	 */
    public boolean wasScrollToSet ()
    {
        return this.wasScrollToSet;
    }
    
    
    /**
     * 
     * @return boolean
     */
    public boolean isScrollTo ()
    {
        return this.getCell().isScrollTo();
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
	 * @return String
	 */
	public String getTarget ()
	{
		return this.getCell().getTarget();
	}


	/**
	 * 
	 * @return String
	 */
	public String getText ()
	{
		return this.getCell().getText();
	}


	/**
	 * 
	 * @param active boolean
	 */
	public void setActive (boolean active)
	{
		this.getCell().setActive(active);		
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
	 * @param isScrollTo boolean
	 */
	public void setScrollTo (boolean isScrollTo)
	{
	    this.wasScrollToSet = true;
	    
		this.getCell().setScrollTo(isScrollTo);
	}


	/**
	 * 
	 * @param id String
	 */
	public void setTarget (String id)
	{
		 this.getCell().setTarget(id);		
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.getCell().setText(text);
	}


	/**
	 * 
	 * @return NavItemCell
	 */
	protected NavItemCell getCell ()
	{
		return this.cell;
	}
}
