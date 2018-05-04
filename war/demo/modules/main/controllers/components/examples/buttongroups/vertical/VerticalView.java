/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.vertical;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margin;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.button.group.VerticalButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.menu.item.MenuItem;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class VerticalView extends BwtExampleView
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
	 * @param presenter DirectionPresenter
	 */
	public VerticalView (VerticalPresenter presenter)
	{
		super(presenter, "Vertical variation");
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
		ButtonGroup group = new VerticalButtonGroup();
		
		group.add(new Button("Button"));
		group.add(new Button("Button"));
		
		DropdownButton dropdownOne = new DropdownButton("Dropdown");
		dropdownOne.add(new MenuItem("Dropdown link"));
		dropdownOne.add(new MenuItem("Dropdown link"));
		
		group.add(dropdownOne);
		
		group.add(new Button("Button"));
		group.add(new Button("Button"));
		
		DropdownButton dropdownTwo = new DropdownButton("Dropdown");
		dropdownTwo.add(new MenuItem("Dropdown link"));
		dropdownTwo.add(new MenuItem("Dropdown link"));
		
		DropdownButton dropdownThree = new DropdownButton("Dropdown");
		dropdownThree.add(new MenuItem("Dropdown link"));
		dropdownThree.add(new MenuItem("Dropdown link"));
		
		DropdownButton dropdownFour = new DropdownButton("Dropdown");
		dropdownFour.add(new MenuItem("Dropdown link"));
		dropdownFour.add(new MenuItem("Dropdown link"));
		
		group.add(dropdownTwo);
		group.add(dropdownThree);
		group.add(dropdownFour);
		
		tab.add(group, Margin.left(5));
		//<=
		
	}
}