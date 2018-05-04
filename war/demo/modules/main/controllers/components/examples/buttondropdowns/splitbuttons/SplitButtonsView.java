/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.splitbuttons;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.MarginLeft;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonStyle;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Mode;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.SplitDropdownButton;
import com.talmadge.bwt.core.client.ui.widget.button.splitdropdown.styled.DefaultSplitDropdownButton;
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
public class SplitButtonsView extends BwtExampleView
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
	 * @param presenter SplitButtonsPresenter
	 */
	public SplitButtonsView (SplitButtonsPresenter presenter)
	{
		super(presenter, "Split button dropdowns");
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
		/* Single button */
		SplitDropdownButton dropdownButton = new DefaultSplitDropdownButton("Defualt");
		dropdownButton.setMode(Mode.HOVER);
		
		dropdownButton.add(new MenuHeader("Dropdown header"));
		dropdownButton.add(new MenuItem("Action"));
		dropdownButton.add(new MenuItem("Another action"));
		dropdownButton.add(new MenuItem("Something else here"));
		dropdownButton.add(new MenuSeparator()); 
		dropdownButton.add(new MenuItem("Separated link"));
		
		tab.add(dropdownButton);
    	//<=
		
		tab.add(this.createSingleButton("Primary", ButtonStyle.PRIMARY), new MarginLeft(5));
		tab.add(this.createSingleButton("Success", ButtonStyle.SUCCESS), new MarginLeft(5));
		tab.add(this.createSingleButton("Info",    ButtonStyle.INFO),    new MarginLeft(5));
		tab.add(this.createSingleButton("Warning", ButtonStyle.WARNING), new MarginLeft(5));
		tab.add(this.createSingleButton("Danger",  ButtonStyle.DANGER),  new MarginLeft(5));
	}	


	
	/**
	 * 
	 * @param text String
	 * @param style ButtonStyle
	 * @return DropdownButton
	 */
	private DropdownButton createSingleButton (String text, ButtonStyle style)
	{
		DropdownButton dropdownButton = new SplitDropdownButton(text);
		dropdownButton.setStyle(style); 
		
		dropdownButton.add(new MenuHeader("Dropdown header"));
		dropdownButton.add(new MenuItem("Action"));
		dropdownButton.add(new MenuItem("Another action"));
		dropdownButton.add(new MenuItem("Something else here"));
		dropdownButton.add(new MenuSeparator()); 
		dropdownButton.add(new MenuItem("Separated link"));
		
		return dropdownButton;
	}
}