package com.talmadge.bwt.core.client.ui.widget.nav.navbar;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavBarFixedStyle;
import com.talmadge.bwt.core.client.ui.widget.nav.DefaultNavAppearance;

/**
 * 
 *
 */
public class DefaultNavBarAppearance extends DefaultNavAppearance implements NavBarAppearance
{
    /**
     * Constructor
     * 
     */
    public DefaultNavBarAppearance ()
    {
        super();
    }
    
    
    /**
	 * 
	 * @param style NavBarFixedStyle
	 */
	@Override
	public void setFixed (NavBarFixedStyle style)
	{
		this.removeCssNames(NavBarFixedStyle.values());
		this.ensureCssName(style);		
	}

	
	/**
	 * 
	 */
	@Override
	public void setInverse (boolean isInverse)
	{
		if (isInverse)
		{
			this.toggleCssName("navbar-default", !isInverse);
			this.toggleCssName("navbar-inverse", isInverse);
		}
		else
		{
			this.toggleCssName("navbar-default", isInverse);
			this.toggleCssName("navbar-inverse", !isInverse);
		}		
	}


	/**
     * 
     */
    @Override
    protected void build ()
    {
    	this.ensureCssName("bwt-navbar");
        this.ensureCssName("navbar");
        this.ensureCssName("navbar-default");
    }
}
