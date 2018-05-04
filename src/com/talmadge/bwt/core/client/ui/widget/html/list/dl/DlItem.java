package com.talmadge.bwt.core.client.ui.widget.html.list.dl;

import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class DlItem
{
	/**
	 */
	private Html name;
	
	/**
	 */
	private Html description;
	
	
	
	/**
	 * Constructor 
	 *
	 * @param name String
	 * @param description String
	 */
	public DlItem (String name, String description)
	{
		this.setName(name);
		this.setDescription(description);
	}
	
	
	/**
	 * 
	 * @return Html
	 */
	public Html getName ()
	{
		return this.name;
	}
	
	
	/**
	 * 
	 * @return Html
	 */
	public Html getDescription ()
	{
		return this.description;
	}
	
	
	/**
	 * 
	 * @param descriptionText String
	 */
	public void setDescription (String descriptionText)
	{
		if (this.description == null)
		{
			this.description = Html.dd();
		}
		
		this.description.setInnerHtml(descriptionText);
	}
	
	
	/**
	 * 
	 * @param nameText String
	 */
	public void setName (String nameText)
	{
		if (this.name == null)
		{
			this.name = Html.dt();
		}
		
		this.name.setInnerHtml(nameText);
	}
}
