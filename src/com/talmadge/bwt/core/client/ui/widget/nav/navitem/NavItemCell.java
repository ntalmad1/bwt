package com.talmadge.bwt.core.client.ui.widget.nav.navitem;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasText;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navgroup.NavGroup;

/**
 * 
 * @author Noah
 *
 */
public class NavItemCell extends BwtWidgetContainer implements HasText, HasClickHandlers
{
	/**
	 * Isolate events from the build in handler manager
	 */
	private HandlerManager handlerManager;
	
	/**
	 */
	private NavGroup navGroup;
	
	/**
     */
    private NavItem navItem;

    /**
	 */
	private String target;

	/**
	 */
	private String text;
	
	
	
	/**
     * Constructor
     * 
     */
    public NavItemCell ()
    {
        this((NavItemAppearance) GWT.create(DefaultNavItemAppearance.class));
    }
	
	
	/**
	 * Constructor
	 * 
	 * @param navItem NavItem
	 */
	public NavItemCell (NavItem navItem)
	{
		this();
		
		this.navItem = navItem;
	}
	
	
	/**
	 * 
	 * @param appearance Appearance
	 */
	protected NavItemCell (BwtWidgetAppearance appearance)
	{
		super(appearance);
		
		this.handlerManager = new HandlerManager(this);
		
		this.bind();
	}

	
	/**
	 * 
	 * @param navItem NavItem
	 */
	public void add (NavItem navItem)
	{
		if (this.navGroup == null)
		{
			this.setNavGroup(new NavGroup());
		}
		
		this.getNavGroup().add(navItem);
	}
	
	
	/**
	 * 
	 * @param clickHandler ClickHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addClickHandler (ClickHandler clickHandler)
	{
		return this.handlerManager.addHandler(ClickEvent.getType(), clickHandler);
	}

	
	/**
	 * 
	 * @param selectHandler SelectHandler<NavItem>
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addSelectHandler (SelectHandler<NavItem> selectHandler)
    {
        return this.handlerManager.addHandler(SelectEvent.getType(), selectHandler);
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
	 * @return String
	 */
	public String getTarget ()
	{
		return this.target;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getText ()
	{
		return this.text;
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
	public boolean isScrollTo ()
	{
	    return this.getAppearance().isScrollTo();
	}
	
	
	/**
	 * 
	 */
	public void removeNavGroup ()
	{
		if (this.hasNavGroup())
		{
			this.getChildren().remove(this.navGroup);
			
			this.getAppearance().removeNavGroup();
			
			if (this.isAttached())
		    {
		        this.detachChild(this.navGroup);
		    }
			
			this.navGroup = null;
		}
	}


	/**
	 * 
	 * @param active boolean
	 */
	public void setActive (boolean active)
	{
		this.getAppearance().setActive(active);		
	}

	
	/**
	 *  
	 * @param navGroup NavGroup
	 */
	public void setNavGroup (NavGroup navGroup)
	{
		if (this.hasNavGroup())
		{
			this.removeNavGroup();
		}
		
		this.getChildren().add(navGroup);
		
	 	this.getAppearance().setNavGroup(navGroup);	
		
		if (this.isAttached())
	    {
	        this.attachChild(navGroup);
	    }
		
		this.navGroup = navGroup;
		
	}

	
	/**
	 * 
	 * @param navItem NavItem
	 */
	public void setNavItem (NavItem navItem)
    {
       this.navItem = navItem;
    }


    /**
     * 
     * @param isScrollTo boolean
     */
    public void setScrollTo (boolean isScrollTo)
    {
    	this.getAppearance().setScrollTo(isScrollTo);
    	
    	if (this.hasNavGroup())
    	{
    		this.getNavGroup().setScrollTo(isScrollTo);
    	}
    	
    }


    /**
	 * 
	 * @param target String
	 */
	public void setTarget (String target)
	{
		this.target = target;
		
		this.getAppearance().setTarget(target);
	}


	/**
	 * 
	 * @param text String
	 */
	public void setText (String text)
	{
		this.text = text;
		
		this.getAppearance().setText(text);		
	}


	/**
	 * 
	 * @return NavItemAppearance
	 */
	protected NavItemAppearance getAppearance ()
	{
		return (NavItemAppearance) super.getAppearance();
	}


	/**
	 * 
	 */
	protected void onLoad ()
	{
		this.getAppearance().attach();
	}
	
	
	/**
	 * 
	 */
	protected void onUnload ()
	{
		this.getAppearance().detach();
	}
	
	
	/**
	 * 
	 */
	protected void bind ()
	{
		this.getAppearance().getHasClickHandlers().addClickHandler(new ClickHandler()
		{
			public void onClick (ClickEvent event)
			{
				NavItemCell.this._click();				
			}
		});
		
	}

	
	/**
	 * 
	 * @param event ClickEvent
	 */
	protected void onClick (ClickEvent event)
	{

		
	}
	
	
	/**
     * 
     * @param event SelectEvent<NavItem>
     */
    protected void onSelect (SelectEvent<NavItem> event)
    {
       
        
    }


	/**
	 * 
	 */
	protected void _click ()
	{
		ClickEvent event = new ClickEvent()	{ };
		
		this.handlerManager.fireEvent(event);
		this.onClick(event);
		
		this._select();
	}
	
	
	/**
     * 
     */
    protected void _select ()
    {
        SelectEvent<NavItem> event = new SelectEvent<NavItem>(this.navItem);
        
        this.handlerManager.fireEvent(event);
        this.onSelect(event);
    }

}
