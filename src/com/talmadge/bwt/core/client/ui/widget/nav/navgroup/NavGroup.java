package com.talmadge.bwt.core.client.ui.widget.nav.navgroup;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupOrientation;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupStyle;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 * @author Noah
 *
 */
public class NavGroup extends BwtComposite
{
	/**
	 */
	private NavGroupCell cell;
	
	
	/**
	 * 
	 */
	public NavGroup ()
	{
		super();
		
		this.cell = new NavGroupCell();
		
		this.initWidget(this.cell);
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
	 */
	public void clear ()
    {
        this.getCell().clear();        
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
	 * @return NavItem
	 */
	public NavItem getFirstItem ()
	{
		return this.getCell().getFirstItem();
	}


	/**
	 * 
	 * @param itemToSetActive NavItem
	 */
	public  void setActiveItem (NavItem itemToSetActive)
	{
		this.getCell().setActiveItem(itemToSetActive);
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
	 * @param justified boolean
	 */
	public void setJustified (boolean justified)
	{
		this.getCell().setJustified(justified);		
	}


	/**
	 * 
	 * @param style NavGroupStyle
	 */
	public void setNavGroupStyle (NavGroupStyle style)
	{
		this.getCell().setNavGroupStyle(style);		
	}
	
	
	/**
	 * 
	 * @param orientation NavGroupOrientation
	 */
	public void setOrientation (NavGroupOrientation orientation)
	{
		this.getCell().setOrientation(orientation);
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
	 * @param isScrollTo boolean
	 */
	public void setScrollTo (boolean isScrollTo)
	{
		this.getCell().setScrollTo(isScrollTo);		
	}


	/**
	 * 
	 * @return NavGroupCell
	 */
	protected NavGroupCell getCell ()
	{
		return this.cell;
	}
}
