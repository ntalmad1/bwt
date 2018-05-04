/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.inline;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class InlineElementsView extends BwtExampleView
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
	 * @param presenter InlineElementsPresenter
	 */
	public InlineElementsView (InlineElementsPresenter presenter)
	{
		super(presenter, "Inline Elements");
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
		tab.setPaddingLeft(20);
		
		//=>
		tab.add(new BwtFlowPanel(Html.mark("Hello World!"))); 
		tab.add(new BwtFlowPanel(Html.del("Hello World!")));
		tab.add(new BwtFlowPanel(Html.s("Hello World!")));
		tab.add(new BwtFlowPanel(Html.ins("Hello World!")));
		tab.add(new BwtFlowPanel(Html.u("Hello World!")));
		tab.add(new BwtFlowPanel(Html.small("Hello World!")));
		tab.add(new BwtFlowPanel(Html.strong("Hello World!")));
		tab.add(new BwtFlowPanel(Html.em("Hello World!")));
		//<= 
	}
}