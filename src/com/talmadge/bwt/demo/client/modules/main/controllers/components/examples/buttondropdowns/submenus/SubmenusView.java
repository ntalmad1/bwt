/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.submenus;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Mode;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled.DefaultSplitDropdownButton;
import com.talmadge.bwt.core.client.ui.widget.menu.header.MenuHeader;
import com.talmadge.bwt.core.client.ui.widget.menu.item.MenuItem;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class SubmenusView extends BwtExampleView
{
	/**
	 */
	protected interface Resources extends ClientBundle, BwtExampleView.Resources
	{
		/**
		 */
		Resources INSTANCE = GWT.create(Resources.class); 
		
		/**
		 * 
		 * @return TextResource
		 */
		TextResource code ();
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param presenter SubmenusPresenter
	 */
	public SubmenusView (SubmenusPresenter presenter)
	{
		super(presenter, "Submenus");
	}

	

	/**
	 * 
	 * @return String
	 */
	protected String getCodeRawText ()
	{
		return Resources.INSTANCE.code().getText();
	}



	/**
	 * 
	 * @param tab Tab
	 */
	protected void populateExamplesTab (Tab tab)
	{
		//=>
		SplitDropdownButton dropdownButton = new DefaultSplitDropdownButton("Dropdown");
		dropdownButton.setMode(Mode.HOVER);
		
		dropdownButton.add(new MenuHeader("Dropdown header"));
		
		MenuItem actionItem = new MenuItem("Action submenu");
		actionItem.add(new MenuHeader("Action submenu header")); 
		actionItem.add(new MenuItem("Another action")); 
		
		MenuItem somethingItem = new MenuItem("Something else here");
		somethingItem.add(new MenuHeader("Something else here submenu"));
		somethingItem.add(new MenuItem("Something else action"));
		
		actionItem.add(somethingItem);
		
		dropdownButton.add(actionItem);
		
		tab.add(dropdownButton);
    	//<=
		
		
	}
}