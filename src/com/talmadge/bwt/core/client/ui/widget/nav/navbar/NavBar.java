package com.talmadge.bwt.core.client.ui.widget.nav.navbar;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.ImageResource;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.nav.AbstractNav;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class NavBar extends AbstractNav
{
    /**
     * Constructor
     * 
     */
    public NavBar ()
    {
        this(new NavBarCell());
    }
    
    
    /**
     * Hidden Constructor
     * 
     * @param cell NavBarCell
     */
    protected NavBar (NavBarCell cell)
    {
        super(cell);
    }

    /**
     * 
     * @param navGroup NavGroup
     */
    public void add (NavGroup navGroup)
    {
        this.getCell().add(navGroup);
    }


    /**
     * 
     * @param navItem NavItem
     */
    @Override
    public void add (NavItem navItem)
    {
        NavGroup navGroup = new NavGroup();
        BwtElementUtils.ensureCssName(navGroup.getElement(), "navbar-nav");
        
        navGroup.add(navItem);
        
        this.add(navGroup);
    }

    
    /**
     * 
     * @param handler ItemAddHandler
     * @return HandlerRegistration
     */
    @Override
    public HandlerRegistration addItemAddHandler (ItemAddHandler handler)
    {
        return this.getCell().addItemAddHandler(handler);
    }

    
    /**
     * 
     * @return A
     */
    public A getBrand ()
    {
        return this.getCell().getBrand();
    }


    /**
     * 
     * @return String
     */
    @Override
    public String getId ()
    {
        return super.getCell().getId();
    }


    
    @Override
    public void setActive (NavItem navItem)
    {
        // TODO Auto-generated method stub
        
    }
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadius (int radius)
    {
    	this.getCell().setCornerRadius(0);
    }
    
    
    /**
     * 
     * @param topLeft int
     * @param topRight int 
     * @param bottomRight int
     * @param bottomLeft int 
     */
    public void setCornerRadius (int topLeft, int topRight, int bottomRight, int bottomLeft)
	{
		this.getCell().setCornerRadius(topLeft, topRight, bottomRight, bottomLeft);
	}
    
    
    /**
     * 
     * @param style NavBarFixedStyle
     */
    public void setFixed (BwtStyle.NavBarFixedStyle style) 
    {
    	this.getCell().setFixed(style);
    }

    
    /**
     * 
     * @param isFluid boolean
     */
    public void setFluid (boolean isFluid)
    {
        this.getCell().setFluid(isFluid);        
    }

    

    /**
     * 
     * @param height int
     */
    public void setHeight (int height)
    {
        this.getCell().setHeight(height);        
    }

    
    /**
     * 
     * @param isInverse boolean
     */
    public void setInverse (boolean isInverse)
	{
		this.getCell().setInverse(isInverse);		
	}


	/**
     * 
     * @param image ImageResource
     */
    public void setIcon (ImageResource image)
    {
        this.getCell().setIcon(image);        
    }

    
    /**
     * 
     * @param id String
     */
    public void setId (String id)
    {
        this.getCell().setId(id);        
    }

    
    /**
     * 
     * @param margin int
     */
    public void setMarginBottom (int margin)
	{
    	this.getCell().setMarginBottom(0);		
	}


	/**
     * 
     * @return NavBarCell
     */
    protected NavBarCell getCell ()
    {
        return (NavBarCell) super.getCell();
    }	
}
