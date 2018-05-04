package com.talmadge.bwt.core.client.ui.widget.nav.sidebar;

import com.talmadge.bwt.core.client.ui.widget.nav.DefaultNavAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultSidebarAppearance extends DefaultNavAppearance implements SidebarAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultSidebarAppearance ()
	{
		super();
	}

	
	/**
	 * 
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("bwt-sidebar");
		
	}
	
	
	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetBottom (int offset)
	{
		this.getElement().setAttribute("data-offset-bottom", "" + offset);		
	}
	

	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetTop (int offset)
	{
		this.getElement().setAttribute("data-offset-top", "" + offset);		
	}

}
