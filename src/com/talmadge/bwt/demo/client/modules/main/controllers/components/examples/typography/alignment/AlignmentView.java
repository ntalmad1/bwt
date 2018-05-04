/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.alignment;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.TextWrap;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class AlignmentView extends BwtExampleView
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
	 * @param presenter AlignmentPresenter
	 */
	public AlignmentView (AlignmentPresenter presenter)
	{
		super(presenter, "Alignment");
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
		tab.add(Html.p("Left aligned text.").setTextAlign(TextAlign.LEFT));
		tab.add(Html.p("Center aligned text.").setTextAlign(TextAlign.CENTER));
		tab.add(Html.p("Right aligned text.").setTextAlign(TextAlign.RIGHT));
		tab.add(Html.p("Justified text.").setTextAlign(TextAlign.JUSTIFY));
		tab.add(Html.p("No wrap text.").setTextWrap(TextWrap.NO_WRAP));
		//<= 
	}
}