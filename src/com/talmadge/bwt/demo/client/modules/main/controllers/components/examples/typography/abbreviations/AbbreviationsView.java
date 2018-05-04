/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.abbreviations;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margin;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class AbbreviationsView extends BwtExampleView
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
	 * @param presenter AbbreviationsView
	 */
	public AbbreviationsView (AbbreviationsPresenter presenter)
	{
		super(presenter, "Abbreviations");
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
		Html abbrExp1 = new Html("An abbreviation of the word attribute is ");
		abbrExp1.append(Html.abbr("attr", "attribute"));
		
		tab.add(abbrExp1);
		
		Html abbrExp2 = new Html("An abbreviation of the word attribute is ");
		abbrExp2.append(Html.abbr("attr", "attribute").setInitialism(true));
		
		tab.add(abbrExp2, Margin.top(20));
		//<= 
	}
}