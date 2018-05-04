package com.talmadge.bwt.core.client.ui.widget.tabpanel.tab;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Noah
 *
 */
public class TabGroup
{
	/**
	 */
	private String headerText;
	
	/**
	 */
	private List<Tab> tabs;
	
	
	
	/**
	 * Constructor 
	 *
	 */
	public TabGroup ()
	{
		this.tabs = new ArrayList<Tab>();
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param headerText HeaderText 
	 */
	public TabGroup (String headerText)
	{
		this();
		
		this.setHeaderText(headerText);
	}


	/**
	 * 
	 * @param tab Tab
	 */
	public void add (Tab tab)
	{
		this.tabs.add(tab);
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
	 * @return List<Tab>
	 */
	public List<Tab> getTabs ()
	{
		return this.tabs;
	}
	
	
	/**
	 * 
	 * @param text String
	 */
	public void setHeaderText (String text)
	{
		this.headerText = text;
	}
}
