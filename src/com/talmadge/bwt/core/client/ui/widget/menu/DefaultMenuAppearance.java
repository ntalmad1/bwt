package com.talmadge.bwt.core.client.ui.widget.menu;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.MenuAlign;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public class DefaultMenuAppearance extends DefaultBwtWidgetContainerAppearance implements MenuAppearance
{
	/**
	 * Constructor 
	 */
	public DefaultMenuAppearance ()
	{
		super(Document.get().createULElement());
	}
	
	
	/**
	 * 
	 */
	protected void build ()
	{
		
	}

	
	/**
	 * 
	 * @param menuAlign MenuAlign
	 */
	public void setMenuAlign (MenuAlign menuAlign)
	{
		this.removeCssNames(MenuAlign.values());
		this.ensureCssName(menuAlign);
	}

}
