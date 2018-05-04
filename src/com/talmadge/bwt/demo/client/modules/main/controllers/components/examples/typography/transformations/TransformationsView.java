/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.transformations;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.TextTransform;
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
public class TransformationsView extends BwtExampleView
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
	 * @param presenter TransformationsPresenter
	 */
	public TransformationsView (TransformationsPresenter presenter)
	{
		super(presenter, "Transformations");
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
		tab.add(Html.p("Lowercased text.").setTextTransform(TextTransform.LOWERCASE));
		tab.add(Html.p("Uppercased text.").setTextTransform(TextTransform.UPPERCASE));
		tab.add(Html.p("Capitalized text.").setTextTransform(TextTransform.CAPITALIZE));
		//<= 
	}
}