/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.sizing;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margin;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;
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
public class SizingView extends BwtExampleView
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
	 * @param presenter SizingPresenter
	 */
	public SizingView (SizingPresenter presenter)
	{
		super(presenter, "Sizing");
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
		/* Large button */
		DropdownButton lgButton = new DropdownButton("Large button");
		lgButton.setButtonSize(ButtonSize.LARGE);
		
		lgButton.add(new MenuHeader("Dropdown header"));
		lgButton.add(new MenuItem("Action"));
		lgButton.add(new MenuItem("Another action"));
		lgButton.add(new MenuItem("Something else here"));
		lgButton.add(new MenuSeparator()); 
		lgButton.add(new MenuItem("Separated link"));
		
		tab.add(new BwtFlowPanel(lgButton));
		
		/* Normal button */
		DropdownButton button = new DropdownButton("Normal button");
		
		button.add(new MenuHeader("Dropdown header"));
		button.add(new MenuItem("Action"));
		button.add(new MenuItem("Another action"));
		button.add(new MenuItem("Something else here"));
		button.add(new MenuSeparator()); 
		button.add(new MenuItem("Separated link"));
		
		tab.add(new BwtFlowPanel(button), Margin.top(10));
		
		/* Small button */
		DropdownButton smButton = new DropdownButton("Small button");
		smButton.setButtonSize(ButtonSize.SMALL);
		
		smButton.add(new MenuHeader("Dropdown header"));
		smButton.add(new MenuItem("Action"));
		smButton.add(new MenuItem("Another action"));
		smButton.add(new MenuItem("Something else here"));
		smButton.add(new MenuSeparator()); 
		smButton.add(new MenuItem("Separated link"));
		
		tab.add(new BwtFlowPanel(smButton), Margin.top(10));
		
		/* Extra small button */
		DropdownButton xsButton = new DropdownButton("Extra small button");
		xsButton.setButtonSize(ButtonSize.XSMALL);
		
		xsButton.add(new MenuHeader("Dropdown header"));
		xsButton.add(new MenuItem("Action"));
		xsButton.add(new MenuItem("Another action"));
		xsButton.add(new MenuItem("Something else here"));
		xsButton.add(new MenuSeparator()); 
		xsButton.add(new MenuItem("Separated link"));
		
		tab.add(new BwtFlowPanel(xsButton), Margin.top(10));
		
    	//<=
		
	}
}