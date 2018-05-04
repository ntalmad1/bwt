package com.talmadge.bwt.core.client.ui.widget.nav.sidebar;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.nav.NavCell;
import com.talmadge.bwt.core.client.ui.widget.nav.event.ItemAddEvent;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 * @author Noah
 *
 */
public class SidebarCell extends NavCell
{
	/**
	 */
	private NavGroup navGroup;
	
	
	
	/**
	 * Constructor 
	 * 
	 */
	public SidebarCell ()
	{
		this((SidebarAppearance) GWT.create(DefaultSidebarAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param appearance Appearance
	 */
	protected SidebarCell (BwtWidgetAppearance appearance)
	{
		super(appearance);		
		
		this.bind();
	}
	
	
	/**
	 * 
	 * @param navItem NavItem
	 */
	public void add (NavItem navItem)
	{
		this.navGroup.add(navItem);
		
		this.fireEvent(new ItemAddEvent(navItem)); 
	}
	
	
	/**
	 * 
	 */
	public void clear ()
	{
	    this.getNavGroup().clear();
	}
	
	
	/**
     * 
     * @return NavItem
     */
    public NavItem getFirstItem ()
    {
    	return this.getNavGroup().getFirstItem();
    }


    /**
	 * 
	 * @return NavGroup
	 */
	public NavGroup getNavGroup ()
	{
		return this.navGroup;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasNavGroup ()
	{
		return this.navGroup != null;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isAffix ()
	{
		return this.getNavGroup().isAffix();
	}


	/**
	 * 
	 */
	public void removeNavGroup ()
	{
		if (this.hasNavGroup())
		{
			this.getChildren().remove(this.navGroup);
			
			this.getAppearance().remove(this.navGroup);
			
			if (this.isAttached())
			{
				BwtWidgetUtils.detachWidget(this.navGroup);
			}
			
			this.navGroup = null;
		}
		
	}

	
	/**
	 * 
	 * @param navItem NavItem
	 */
	public void setActive (NavItem navItem)
	{
		this.getNavGroup().setActiveItem(navItem);		
	}


	/**
	 * 
	 * @param affix boolean
	 */
	public void setAffix (boolean affix)
	{
		this.getNavGroup().setAffix(affix);		
	}

	
	/**
	 * 
	 * @param offset int 
	 */
	public void setOffsetBottom (int offset)
	{
		//this.getAppearance().setOffsetBottom(offset); 
		this.getNavGroup().setOffsetBottom(offset);
	}


	/**
	 * 
	 * @param offset int 
	 */
	public void setOffsetTop (int offset)
	{
		//this.getAppearance().setOffsetTop(offset); 
		this.getNavGroup().setOffsetTop(offset);
	}


	/**
	 * 
	 * @param navGroup NavGroup
	 */
	public void setNavGroup (NavGroup navGroup)
	{
		this.removeNavGroup();
		
		this.getChildren().add(navGroup);
		
		this.getAppearance().add(navGroup);
		
		if (this.isAttached())
		{
			BwtWidgetUtils.attachWidget(navGroup);
		}
		
		this.navGroup = navGroup;
	}


	/**
	 * 
	 */
	protected void bind ()
	{
		
	}


	/**
	 * 
	 * @return SidebarAppearance
	 */
	protected SidebarAppearance getAppearance ()
	{
		return (SidebarAppearance) super.getAppearance();
	}

}
