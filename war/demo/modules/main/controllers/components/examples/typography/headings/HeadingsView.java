/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.headings;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.pageheader.PageHeader;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class HeadingsView extends BwtExampleView
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
	 * @param presenter HeadingsPresenter
	 */
	public HeadingsView (HeadingsPresenter presenter)
	{
		super(presenter, "Headings");
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
		tab.add(new PageHeader("Page Header"));
		
		tab.add(Html.h1("h1. Bootstrap heading").append("&nbsp;<small>Secondary text</small>"));
		tab.add(Html.h2("h2. Bootstrap heading").append("&nbsp;<small>Secondary text</small>"));
		tab.add(Html.h3("h3. Bootstrap heading").append("&nbsp;<small>Secondary text</small>"));
		tab.add(Html.h4("h4. Bootstrap heading").append("&nbsp;<small>Secondary text</small>"));
		tab.add(Html.h5("h5. Bootstrap heading").append("&nbsp;<small>Secondary text</small>"));
		tab.add(Html.h6("h6. Bootstrap heading").append("&nbsp;<small>Secondary text</small>"));
		//<= 
	}
}