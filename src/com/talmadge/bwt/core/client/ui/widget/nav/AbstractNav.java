package com.talmadge.bwt.core.client.ui.widget.nav;

import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;
import com.talmadge.bwt.core.client.ui.widget.nav.scrollspy.ScrollSpy;

/**
 * 
 * @author Noah
 *
 */
public abstract class AbstractNav extends BwtComposite implements Nav
{
	/**
	 */
	private NavCell cell;
	
	
	/**
	 */
	private ScrollSpy scrollSpy;
	
	
	/**
	 * Constructor 
	 * 
	 * @param cell NavCell
	 */
	protected AbstractNav (NavCell cell)
	{
		super();
		
		this.cell = cell;
		
		this.initWidget(cell);
	}

	
	/**
     * 
     */
    public void removeAll ()
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
    public boolean hasScrollSpy ()
    {
        return !(this.getScrollSpy() == null);
    }
    
    
    /**
     * 
     * @return ScrollSpy
     */
    public ScrollSpy getScrollSpy ()
    {
        return this.scrollSpy;
    }
    
    
    /**
     * 
     * @return boolean
     */
    public boolean isAffix ()
    {
        return false;
    }


    /**
     * 
     * @param offset int 
     */
    public void setOffsetBottom (int offset)
    {
      
    }


    /**
     * 
     * @param offset int 
     */
    public void setOffsetTop (int offset)
    {
       
    }
    
    
    /**
     * 
     * @param scrollSpy ScrollSpy
     */
    public void setScrollSpy (ScrollSpy scrollSpy)
    {
        this.scrollSpy = scrollSpy;
        this.scrollSpy.setNav(this);
    }


    /**
     * 
     * @return SidebarCell
     */
    protected NavCell getCell ()
    {
    	return this.cell;
    }
}
