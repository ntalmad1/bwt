package com.talmadge.bwt.core.client.ui.widget.nav.navbar;

import com.google.gwt.resources.client.ImageResource;
import com.talmadge.bwt.core.client.history.BwtHistory;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeEvent;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeHandler;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavBarFixedStyle;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.widget.container.collapse.Collapse;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.layout.container.FluidLayoutConatiner;
import com.talmadge.bwt.core.client.ui.widget.layout.container.LayoutContainer;
import com.talmadge.bwt.core.client.ui.widget.nav.NavCell;
import com.talmadge.bwt.core.client.ui.widget.nav.navbar.header.NavBarHeader;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class NavBarCell extends NavCell
{
    /**
     */
    private Collapse collapse;

    /**
     */
    private LayoutContainer container;
    
    /**
     */
    private NavBarHeader header;   
    
    
    
    /**
     * Constructor
     * 
     */
    public NavBarCell ()
    {
        this(new DefaultNavBarAppearance());
    }
    

    /**
     * Hidden Constructor
     * 
     * @param appearance NavBarAppearance
     */
    protected NavBarCell (NavBarAppearance appearance)
    {
        super(appearance);
        
        this.container = new FluidLayoutConatiner();
        this.add(this.container);
        
        this.header = new NavBarHeader();
        this.container.add(this.header);
        
        this.collapse = new Collapse();
        BwtElementUtils.ensureCssName(this.collapse.getElement(), "navbar-collapse");
        
        this.header.setToggleTarget(this.collapse.getId());
        
        this.container.add(this.collapse); 
        
        this.bind();
    }
    
    
    /**
     * 
     * @param item NavItem
     */
    public void add (NavItem item)
    {
        this.collapse.add(item);
    }
    
    
    /**
     * 
     * @param group NavGroup
     */
    public void add (NavGroup group)
    {
        this.collapse.add(group);
    }
    
    
    /**
     * 
     */
    protected void collapse ()
    {
        this.collapse.collapse();
    }


    /**
     * 
     *  @return A
     */
    public A getBrand ()
    {
        return this.header.getBrand();
    }


    /**
     * 
     * @param style NavBarFixedStyle
     */
    public void setFixed (NavBarFixedStyle style)
	{
		this.getAppearance().setFixed(style);
	}


	/**
     * 
     * @param isFluid boolean
     */
    public void setFluid (boolean isFluid)
    {
        this.container.setFluid(isFluid);        
    }


    /**
     * 
     * @param image ImageResource
     */
    public void setIcon (ImageResource image)
    {
        this.getHeader().setIcon(image); 
    }
    
    
    /**
     * 
     * @param isInverse
     */
    public void setInverse (boolean isInverse)
	{
		this.getAppearance().setInverse(isInverse);		
	}


	/**
     * 
     */
    protected void bind ()
    {
        BwtHistory.getInstance().addHistoryStateChangeHandler(new HistoryStateChangeHandler()
        {
            public void onHistoryStateChange (HistoryStateChangeEvent event)
            {
                NavBarCell.this.collapse();
            }
        });
    }


    /**
     * 
     * @return NavBarHeader
     */
    protected NavBarHeader getHeader ()
    {
        return this.header;
    }
    
    
    /**
     * 
     */
    protected void onAttach ()
    {   
        super.onAttach();
    }
    
    
    /**
     * 
     * @return NavBarAppearance
     */
    protected NavBarAppearance getAppearance ()
    {
    	return (NavBarAppearance) super.getAppearance();
    }
}
