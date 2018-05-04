package com.talmadge.bwt.demo.client.lib.example;

import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 * @author Noah
 *
 */
public abstract class BwtExamplePresenter extends BwtExampleGroup
{
    
    /**
     * Constructor
     * 
     */
    public BwtExamplePresenter ()
    { 
       super();        
    }
    
    
	/**
	 * 
	 * @return BwtExampleView
	 */
	public BwtExampleView getView ()
	{
		return (BwtExampleView) super.getView(); 
	}
	
	
	/**
	 * 
	 * @return NavItem
	 */
	public NavItem getNavItem ()
	{
	    if (!this.getView().hasId())
	    {
	        this.getView().setId(BwtWidgetUtils.uniqueId());
	    }
	    
		return new NavItem(
				  this.getView().getId()
				, this.getView().getHeader().getText());
	}
}
