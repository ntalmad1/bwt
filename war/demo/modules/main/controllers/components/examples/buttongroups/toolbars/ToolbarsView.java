/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.toolbars;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margin;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.button.toolbar.ButtonToolbar;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class ToolbarsView extends BwtExampleView
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
	 * @param presenter ToolbarsPresenter
	 */
	public ToolbarsView (ToolbarsPresenter presenter)
	{
		super(presenter, "Button toolbar");
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
		ButtonGroup groupA = new ButtonGroup();
		groupA.add(new Button("1"));
		groupA.add(new Button("2"));
		groupA.add(new Button("3"));
		groupA.add(new Button("4"));
		
		ButtonGroup groupB = new ButtonGroup();
		groupB.add(new Button("5"));
		groupB.add(new Button("6"));
		groupB.add(new Button("7"));
		
		ButtonToolbar toolbar = new ButtonToolbar();
		toolbar.add(groupA);
		toolbar.add(groupB);
		toolbar.add(new Button("8"));
		
		tab.add(toolbar, Margin.left(5));
		//<=
		
	}
}