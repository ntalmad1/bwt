package com.talmadge.bwt.core.client.ui.widget.tabpanel;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;
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
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.TabGroup;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tabheader.TabHeader;


/**
 * @author Noah
 *
 */
public class TabPanel extends BwtWidget implements 
	  HasBeforeTabHideHandlers
	, HasBeforeTabShowHandlers
	, HasTabHideHandlers
	, HasTabShowHandlers
{
    /**
     */
    private boolean fxFade = true;

    /**
     */
    private TabPanelJQueryBridge eventBridge;

	/**
     */
    private List<TabHeader> tabHeaders;

    
    
	/**
     * Constructor
     *
     */
    public TabPanel ()
    {
        this(new DefaultTabPanelAppearance());

        
    }
    
    
    /**
     * Constructor
     * 
     * @param appearance TabPanelAppearance
     */
    protected TabPanel (TabPanelAppearance appearance)
    {
    	super(appearance);
    	
    	this.tabHeaders = new ArrayList<TabHeader>();
    	this.eventBridge = new TabPanelJQueryBridge(this);
    	
    	this.bind();
    }


    /**
     * @param tab Tab
     */
    public void add (Tab tab)
    {
        tab.setFxFade(this.fxFade);

        TabHeader tabHeader = new TabHeader(tab);

        this.tabHeaders.add(tabHeader);
        
        this.getAppearance().add(tabHeader);
    }


	/**
     * 
     * @param group TabGroup
     */
    public void add (TabGroup group)
	{
    	TabHeader tabHeader = new TabHeader(group.getHeaderText());
    	
    	for (Tab tab : group.getTabs())
    	{
    		tab.setFxFade(this.fxFade);
    		tabHeader.add(tab);
    	}
    	
    	this.tabHeaders.add(tabHeader);
        this.getAppearance().add(tabHeader);
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
     * @return Tab
     */
    public Tab getActiveTab ()
    {
        Element activeTab = this.getAppearance().getActiveTab();

        if (activeTab != null)
        {
	        for (Tab tab : this.getTabs())
	        {
	            if (tab.getId().equals(activeTab.getId()))
	            {
	                return tab;
	            }
	        }
        }

        return null;
    }


    /**
     * 
     * @return TabPanelAppearance
     */
    public TabPanelAppearance getAppearance ()
    {
        return (TabPanelAppearance) super.getAppearance();
    }

    
    /**
     * 
     * @param id String
     * @return Tab
     */
    public Tab getTabById (String id)
	{
		for (TabHeader tabHeader : this.getTabHeaders())
		{
			if (tabHeader.contains(id))
			{
				return tabHeader.getTabById(id);
			}
		}
		
		return null;
	}


	/**
     *
     * @param tabToMakeActive Tab
     */
    public void setActiveTab (Tab tabToMakeActive)
    {
    	for (TabHeader tabHeader : this.getTabHeaders())
    	{
    		if (tabHeader.contains(tabToMakeActive))
    		{
    			tabToMakeActive.setActive(true);
                tabHeader.setActive(true);
    		}
    		else
    		{
    			tabHeader.setActive(false);
    		}
    	}
    }


    /**
	 *
	 * @param height int
	 */
	public void setBodyHeight (int height)
	{
	    this.getAppearance().setBodyHeight(height);
	}

	/**
	 * 
	 * @param padding int
	 */
	public void setBodyPadding (int padding)
	{
		this.setBodyPadding(new Padding(0));
	}
	
	
	/**
	 * 
	 * @param padding Padding
	 */
	public void setBodyPadding (Padding padding)
	{
		this.getAppearance().setBodyPadding(padding);
	}


	/**
     *
     * @param fade boolean
     */
    public void setFade (boolean fade)
    {
        this.fxFade = fade;
    }


    /**
     *
     */
    protected void bind ()
    {
    	
    }


    /**
     *
     * @return List<Tab>
     */
    protected List<Tab> getTabs ()
    {
        ArrayList<Tab> tabs = new ArrayList<Tab>();
        
        for (TabHeader tabHeader : this.getTabHeaders())
        {
        	tabs.addAll(tabHeader.getTabs());
        }
        
        return tabs;
    }


    /**
     *
     * @return List<TabHeader>
     */
    protected List<TabHeader> getTabHeaders ()
    {
        return this.tabHeaders;
    }


    /**
     *
     */
    protected void onInitialAttach ()
    {
    	if (this.getActiveTab() == null && !this.getTabs().isEmpty())
        {
            this.setActiveTab(this.getTabs().get(0));
        }
    	
    	BwtWidgetUtils.attachWidget(this.getActiveTab());
    }
    
    
    /**
     * 
     */
    protected  void onLoad ()
    {
    	this.eventBridge.attach();
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
    
    
    /**
     * 
     */
    protected  void onUnload ()
    {
    	this.eventBridge.detach();
    }
    
    
	/**
	 *
	 * @param id String
	 */
	protected void _beforeHide (String id)
	{
		Tab tab = this.getTabById(id);
		
		BeforeTabHideEvent event = new BeforeTabHideEvent(tab);
		
		tab.fireEvent(event);
		this.fireEvent(event);		
		this.onBeforeTabHide(event);
	}


	/**
	 *
	 * @param id String
	 */
	protected void _beforeShow (String id)
	{
		Tab tab = this.getTabById(id);
		
		BeforeTabShowEvent event = new BeforeTabShowEvent(tab);
		
		tab.fireEvent(event);
		this.fireEvent(event);		
		this.onBeforeTabShow(event);
	}


	/**
	 *
	 * @param id String
	 */
	protected void _hide (String id)
	{
		Tab tab = this.getTabById(id);
		
		BwtWidgetUtils.detachWidget(tab);
		
		TabHideEvent event = new TabHideEvent(tab);
		
		tab.fireEvent(event);
		this.fireEvent(event);		
		this.onTabHide(event);
	}


	/**
	 *
	 * @param id String
	 */
	protected void _show (String id)
	{
		Tab tab = this.getTabById(id);
		
		BwtWidgetUtils.attachWidget(tab);
		
		TabShowEvent event = new TabShowEvent(tab);
		
		tab.fireEvent(event);		
		this.fireEvent(event);		
		this.onTabShow(event);
	}
}
