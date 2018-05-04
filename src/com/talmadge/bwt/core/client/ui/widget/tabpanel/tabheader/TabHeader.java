package com.talmadge.bwt.core.client.ui.widget.tabpanel.tabheader;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;

/**
 * @author Noah
 *
 */
public class TabHeader extends BwtWidget
{	
	/**
	 */
	private List<Tab> tabs;
	
	/**
	 */
	private String text;
	
	
	
    /**
     * Constructor
     *
     */
    public TabHeader ()
    {
        this((TabHeaderAppearance) GWT.create(DefaultTabHeaderAppearance.class));
    }
    

	
    /**
     * Constructor 
     *
     * @param text String
     */
	public TabHeader (String text)
	{
		this();
		
		this.setText(text);
	}


	/**
     * Constructor 
     *
     * @param tab Tab
     */
    public TabHeader (Tab tab)
	{
		this();
		
		this.add(tab);
	}


    /**
	 * Constructor
	 * 
	 * @param appearance TabHeaderAppearance
	 */
	protected TabHeader (TabHeaderAppearance appearance)
	{
		super(appearance);
		
		this.tabs = new ArrayList<Tab>();
		
		this.bind();
	}

	
	/**
	 * 
	 * @param tab Tab
	 */
	public void add (Tab tab)
	{
		if (this.getTabs().isEmpty() && (this.text == null || this.text.isEmpty()))
		{
			this.setText(tab.getHeaderText());
			this.setTarget(tab.getElement());
		}
		else
		{
			this.getAppearance().setIsTabGroup(true);
			
			TabHeader tabHeader = new TabHeader(tab);
			this.getAppearance().add(tabHeader);
		}
		
		this.tabs.add(tab);
	}

	
	/**
	 * 
	 * @param id String
	 * @return boolean
	 */
	public boolean contains (String id)
	{
		for (Tab tab : this.getTabs())
		{
			if (tab.getId().equals(id))
			{
				return true;
			}
		}
		
		return false;
	}



	/**
	 * 
	 * @param tab Tab
	 * @return boolean
	 */
	public boolean contains (Tab tab)
	{
		return this.tabs.contains(tab);
	}


	/**
     *
     * @return TabHeaderAppearance
     */
    public TabHeaderAppearance getAppearance ()
    {
        return (TabHeaderAppearance) super.getAppearance();
    }

    
    /**
	 * 
	 * @param id String
	 * @return Tab
	 */
	public Tab getTabById (String id)
	{
		for (Tab tab : this.getTabs())
		{
			if (tab.getId().equals(id))
			{
				return tab;
			}
		}
		
		return null;
	}
    
    
    /**
     * 
     * @return List<Tab>
     */
    public List<Tab> getTabs ()
	{
		return this.tabs;
	}


	/**
     * @param active boolean
     */
    public void setActive (boolean active)
    {
        this.getAppearance().setActive(active);
    }


    /**
	 *
	 * @param target Element
	 */
	public void setTarget (Element target)
	{
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
     */
    protected void bind ()
    {

    }
}
