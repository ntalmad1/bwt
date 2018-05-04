/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.code;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.BwtHasText;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.pageheader.PageHeader;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah
 *
 */
public class CodeView extends BwtExampleView
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
		@Source("resources/loremIpsum.txt")
		TextResource loremIpsum ();
		
		
		/**
		 * 
		 * @return TextResource
		 */
		TextResource code ();
	}
	
	
	
	/**
	 * Constructor 
	 *
	 * @param presenter CodePresenter
	 */
	public CodeView (CodeExamples presenter)
	{
		super(presenter, "Code");
	}

	
	/**
	 * 
	 * @param header String
	 * @return Html
	 */
	protected BwtHasText createHeader (String header)
	{
		return new PageHeader(header);
		
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
		/* Inline */
		tab.add(Html.h3("Inline")); 
		
		tab.add(Html.div("For example, ").add(Html.code("&lt;section&gt;")).append(" should be wrapped as inline."));
		
		
		/* User input */
		tab.add(Html.h3("User input"));
		
		tab.add(Html.div("To switch directories, type ").add(Html.kbd("cd")).append(" followed by the name of the directory."));
		tab.add(Html.div("To edit settings, press ").add(Html.kbd("ctrl + ,")).append("."));
		
		
		/* Basic block */
		tab.add(Html.h3("Basic block"));
		tab.add(Html.pre("&lt;p&gt;Sample text here...&lt;/p&gt;"));
		
		/* Scrollable basic block */
		tab.add(Html.h3("Scrollable basic block"));
		tab.add(Html.pre(Resources.INSTANCE.loremIpsum().getText()).setScrollable(true));
		
		/* Variables */
		tab.add(Html.h3("Variables"));
		
		tab.add(Html.div()
				.add(Html.var("y"))
				.append(" = ")
				.add(Html.var("m"))
				.add(Html.var("x"))
				.append(" + ")
				.add(Html.var("b")));
		
		/* Sample output */
		tab.add(Html.h3("Sample output"));
		
		tab.add(Html.samp("This text is meant to be treated as sample output from a computer program."));
	
		
		//<=
	}
}