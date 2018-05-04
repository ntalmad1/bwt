/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.direction;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margin;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Direction;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.MenuAlign;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.styled.PrimaryDropdownButton;
import com.talmadge.bwt.core.client.ui.widget.menu.header.MenuHeader;
import com.talmadge.bwt.core.client.ui.widget.menu.item.MenuItem;
import com.talmadge.bwt.core.client.ui.widget.menu.separator.MenuSeparator;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class DirectionView extends BwtExampleView
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
	public DirectionView (DirectionPresenter presenter)
	{
		super(presenter, "Direction");
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
		/* Dropup button */
		DropdownButton dropupButton = new DropdownButton("Dropup");
		dropupButton.setDirection(Direction.UP);
		
		dropupButton.add(new MenuHeader("Dropdown header"));
		dropupButton.add(new MenuItem("Action"));
		dropupButton.add(new MenuItem("Another action"));
		dropupButton.add(new MenuItem("Something else here"));
		dropupButton.add(new MenuSeparator()); 
		dropupButton.add(new MenuItem("Separated link"));
		
		tab.add(dropupButton);
		
		/* Dropup button with menu align right */
		DropdownButton rightDropupButton = new PrimaryDropdownButton("Right dropup");
		rightDropupButton.setDirection(Direction.UP);
		rightDropupButton.setMenuAlign(MenuAlign.RIGHT);
		
		rightDropupButton.add(new MenuHeader("Dropdown header"));
		rightDropupButton.add(new MenuItem("Action"));
		rightDropupButton.add(new MenuItem("Another action"));
		rightDropupButton.add(new MenuItem("Something else here"));
		rightDropupButton.add(new MenuSeparator()); 
		rightDropupButton.add(new MenuItem("Separated link"));
		
		tab.add(rightDropupButton, Margin.left(5));
		//<=
		
	}
}