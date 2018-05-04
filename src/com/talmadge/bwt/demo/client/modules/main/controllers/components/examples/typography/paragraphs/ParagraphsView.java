/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.paragraphs;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class ParagraphsView extends BwtExampleView
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
		
		/**
		 * 
		 * @return TextResource
		 */
		@Source("resources/loremIpsum.txt")
		TextResource loremIpsum ();
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param presenter ParagraphsPresenter
	 */
	public ParagraphsView (ParagraphsPresenter presenter)
	{
		super(presenter, "Paragraphs");
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
		tab.add(Html.p(Resources.INSTANCE.loremIpsum().getText()));
		
		tab.add(Html.p(Resources.INSTANCE.loremIpsum().getText()).setLead(true));
		//<= 
	}
}