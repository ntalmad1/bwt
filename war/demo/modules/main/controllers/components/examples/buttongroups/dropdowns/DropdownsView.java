/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.dropdowns;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margin;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;
import com.talmadge.bwt.core.client.ui.widget.menu.item.MenuItem;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class DropdownsView extends BwtExampleView
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
	 * @param presenter DropdownsPresenter
	 */
	public DropdownsView (DropdownsPresenter presenter)
	{
		super(presenter, "Dropdowns in button groups");
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
		// Dropdown
		ButtonGroup groupA = new ButtonGroup();
		
		groupA.add(new Button("1"));
		groupA.add(new Button("2"));
		
		DropdownButton dropdownButton = new DropdownButton("Dropdown");
		dropdownButton.add(new MenuItem("Dropdown link"));
		dropdownButton.add(new MenuItem("Dropdown link"));
		
		groupA.add(dropdownButton);
		
		tab.add(groupA, Margin.left(5));
		
		// Split Dropdown
		ButtonGroup groupB = new ButtonGroup();
		
		groupB.add(new Button("3"));
		groupB.add(new Button("4"));
		
		SplitDropdownButton splitDropdown = new SplitDropdownButton("Split dropdown");
		splitDropdown.add(new MenuItem("Dropdown link"));
		splitDropdown.add(new MenuItem("Dropdown link"));
		
		groupB.add(splitDropdown);
		
		tab.add(groupB, Margin.left(10));
		//<=
		
	}
}