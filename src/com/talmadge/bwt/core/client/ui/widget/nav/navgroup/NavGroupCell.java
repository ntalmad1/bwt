package com.talmadge.bwt.core.client.ui.widget.nav.navgroup;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupOrientation;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupStyle;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 * @author Noah
 *
 */
public class NavGroupCell extends BwtWidgetContainer
{
	/**
	 */
	private List<NavItem> navItems;
	
	
	
	/**
	 * Constructor 
	 * 
	 */
	public NavGroupCell ()
	{
		this((NavGroupAppearance) GWT.create(DefaultNavGroupAppearance.class));
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param appearance NavGroupAppearance
	 */
	protected NavGroupCell (NavGroupAppearance appearance)
	{
		super(appearance);
		
		this.navItems = new ArrayList<NavItem>();
		
		this.bind();
	}
	
	
	/**
	 * 
	 * @param item NavItem
	 */
	public void add (NavItem item)
	{
		super.add(item);
		
		this.getNavItems().add(item);
		
		this.bindItem(item);
	}
	
	
	/**
	 * 
	 * @return NavGroupAppearance
	 */
	public NavGroupAppearance getAppearance ()
	{
		return (NavGroupAppearance) super.getAppearance();
	}
	
	/**
	 * 
	 * @return NavItem
	 */
	public NavItem getFirstItem ()
	{
		if (this.getNavItems().isEmpty())
		{
			return null;
		}
		
		return this.getNavItems().get(0);
	}


	/**
	 * 
	 * @return List<NavItem>
	 */
	public List<NavItem> getNavItems ()
	{
		return this.navItems;
	}
	
	
	/**
	 * 
	 * @param itemToSetActive NavItem
	 */
	public void setActiveItem (NavItem itemToSetActive)
	{
		for (NavItem item : this.getNavItems())
		{
			if (item.getId().equals(itemToSetActive.getId()))
			{
				item.setActive(true);
			}
			else
			{
				item.setActive(false);
			}
		}
	}

	
	/**
	 * 
	 * @param affix boolean
	 */
	public void setAffix (boolean affix)
	{
		this.getAppearance().setAffix(affix);		
	}


	/**
	 * 
	 * @param justified boolean
	 */
	public void setJustified (boolean justified)
	{
		this.getAppearance().setJustified(justified);		
	}


	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetBottom (int offset)
	{
		this.getAppearance().setOffsetBottom(offset);		
	}


	/**
	 * 
	 * @param offset int
	 */
	public void setOffsetTop (int offset)
	{
		this.getAppearance().setOffsetTop(offset);		
	}


	/**
	 * 
	 * @param style NavGroupStyle
	 */
	public void setNavGroupStyle (NavGroupStyle style)
	{
		this.getAppearance().setNavGoupStyle(style);
	}

	
	/**
	 * 
	 * @param orientation NavGroupOrientation
	 */
	public void setOrientation (NavGroupOrientation orientation)
	{
		this.getAppearance().setOrientaion(orientation);		
	}


	/**
	 * 
	 */
	protected void bind ()
	{
		
	}


	/**
	 * 
	 * @param item NavItem
	 */
	protected void bindItem (final NavItem item)
	{
		item.addClickHandler(new ClickHandler()
		{
			public void onClick (ClickEvent event)
			{
				NavGroupCell.this.setActiveItem(item);
			}
		});
	}

	
	/**
	 * 
	 * @param isScrollTo boolean
	 */
	public void setScrollTo (boolean isScrollTo)
	{
		for (NavItem navItem : this.getNavItems())
		{
			navItem.setScrollTo(isScrollTo);
		}
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isAffix ()
	{
		return this.getAppearance().isAffix();
	}
}
