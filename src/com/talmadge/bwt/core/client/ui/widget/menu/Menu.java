package com.talmadge.bwt.core.client.ui.widget.menu;

import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.MenuAlign;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.menu.header.MenuHeader;
import com.talmadge.bwt.core.client.ui.widget.menu.item.MenuItem;
import com.talmadge.bwt.core.client.ui.widget.menu.separator.MenuSeparator;

/**
 * 
 * @author Noah
 *
 */
public class Menu extends BwtComposite
{
	
	
	
	/**
	 */
	private MenuCell cell;
	
	
	/**
	 * Constructor 
	 */
	public Menu ()
	{
		super();
		
		this.cell = new MenuCell();
		
		this.initWidget(this.cell);
	}
	
	
	/**
	 * 
	 * @param menuHeader MenuHeader
	 */
	public void add (MenuHeader menuHeader)
	{
		this.getCell().add(menuHeader);
	}
	
	
	/**
	 * 
	 * @param menuSeparator MenuSeparator
	 */
	public void add (MenuSeparator menuSeparator)
	{
		this.getCell().add(menuSeparator);
	}
	
	
	/**
	 * 
	 * @param menuItem MenuItem
	 */
	public void add (MenuItem menuItem)
	{
		this.getCell().add(menuItem);
	}
	
	
	/**
	 * 
	 * @param menuAlign MenuAlign
	 */
	public void setMenuAlign (MenuAlign menuAlign)
	{
		this.getCell().setMenuAlign(menuAlign);		
	}


	/**
	 * 
	 * @return MenuCell
	 */
	protected MenuCell getCell ()
	{
		return this.cell;
	}
}
