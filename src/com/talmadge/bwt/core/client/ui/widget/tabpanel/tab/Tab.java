package com.talmadge.bwt.core.client.ui.widget.tabpanel.tab;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforehide.BeforeTabHideEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforehide.BeforeTabHideHandler;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforehide.HasBeforeTabHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforeshow.BeforeTabShowEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforeshow.BeforeTabShowHandler;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.beforeshow.HasBeforeTabShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.hide.HasTabHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.hide.TabHideEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.hide.TabHideHandler;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.show.HasTabShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.show.TabShowEvent;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.event.show.TabShowHandler;

/**
 * @author Noah
 *
 */
public class Tab extends BwtWidgetContainer implements
	  HasBeforeTabHideHandlers
	, HasBeforeTabShowHandlers
	, HasTabHideHandlers
	, HasTabShowHandlers
{
    /**
     */
    private String headerText;


    /**
     * Constructor
     */
    public Tab ()
    {
        this((TabAppearance) GWT.create(DefaultTabAppearance.class));
    }


    /**
     * Constructor
     *
     * @param headerText String
     */
    public Tab (String headerText)
    {
        this();

        this.setHeaderText(headerText);
    }
    
    
    /**
     * Constructor
     * 
     * @param appearance TabAppearance
     */
    public Tab (TabAppearance appearance)
    {
    	super(appearance);
    	
    	this.bind();
    }


    /**
     *
     * @param widget Widget
     */
    public void add (Widget widget)
    {
        this.add(widget, new Margins());
    }
    
    
    /**
	 * 
	 * @param isWidget Widget
	 * @param margins Margins
	 */
	public void add (IsWidget isWidget, Margins margins)
	{
		this.add(isWidget.asWidget(), margins);
	}
	
    
	/**
	 * 
	 * @param widget Widget
	 * @param margins Margins
	 */
	public void add (Widget widget, Margins margins)
	{
		this.getChildren().add(widget);
		
		this.getAppearance().add(widget, margins);
		
		if (this.isAttached())
	    {
	        this.attachChild(widget);
	    }
	}


    /**
	 * 
	 * @param handler BeforeTabHideHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBeforeTabHideHandler (BeforeTabHideHandler handler)
	{
		return this.addHandler(handler, BeforeTabHideEvent.getType());
	}


	/**
	 * 
	 * @param handler BeforeTabShowHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBeforeTabShowHandler (BeforeTabShowHandler handler)
	{
		return this.addHandler(handler, BeforeTabShowEvent.getType());
	}


	/**
	 * 
	 * @param handler TabHideHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addTabHideHandler (TabHideHandler handler)
	{
		return this.addHandler(handler, TabHideEvent.getType());
	}


	/**
	 * 
	 * @param handler TabShowHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addTabShowHandler (TabShowHandler handler)
	{
		return this.addHandler(handler, TabShowEvent.getType());
	}


	/**
     *
     * @return TabAppearance
     */
    public TabAppearance getAppearance ()
    {
        return (TabAppearance) super.getAppearance();
    }


    /**
     *
     * @return String
     */
    public String getHeaderText ()
    {
        return this.headerText;
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
     * @param fade boolean
     */
    public void setFxFade (boolean fade)
    {
        this.getAppearance().setFxFade(fade);
    }


    /**
     *
     * @param text String
     */
    public void setHeaderText (String text)
    {
        this.headerText = text;
    }

    /**
     * 
     * @param padding Padding
     */
    public void setPadding (Padding padding)
	{
		this.getAppearance().setPadding(padding);		
	}


	/**
	 * 
	 * @param paddingLeft int
	 */
	public void setPaddingLeft (int paddingLeft)
	{
		this.getAppearance().setPaddingLeft(paddingLeft);	
	}


	/**
     *
     */
    protected void bind ()
    {
    	this.addTabShowHandler(new TabShowHandler()
		{
			public void onTabShow (TabShowEvent event)
			{
				Tab.this.onTabShow(event);				
			}
		});
    	
    	
    	this.addTabHideHandler(new TabHideHandler()
		{
			public void onTabHide (TabHideEvent event)
			{
				Tab.this.onTabHide(event);				
			}
		});
    }


	/**
	 * 
	 * @param event BeforeTabHideEvent
	 */
	protected void onBeforeTabHide (BeforeTabHideEvent event)
	{
		
	}


	/**
	 * 
	 * @param event BeforeTabShowEvent
	 */
	protected void onBeforeTabShow (BeforeTabShowEvent event)
	{
		
	}


	/**
	 * 
	 * @param event TabHideEvent
	 */
	protected void onTabHide (TabHideEvent event)
	{
		
	}


	/**
	 * 
	 * @param event TabShowEvent
	 */
	protected void onTabShow (TabShowEvent event)
	{
		
	}
}
