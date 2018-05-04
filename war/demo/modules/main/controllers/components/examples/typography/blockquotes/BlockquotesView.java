/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.blockquotes;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.blockquote.Blockquote;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class BlockquotesView extends BwtExampleView
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
	 * @param presenter BlockquotesPresenter
	 */
	public BlockquotesView (BlockquotesPresenter presenter)
	{
		super(presenter, "Blockquotes");
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
		Blockquote blockquoteExp1 = new Blockquote();
		blockquoteExp1.add(Html.p(Resources.INSTANCE.loremIpsum().getText()));
		blockquoteExp1.add(Html.footer("Someone famous in").nbsp().add(Html.cite("Source Title")));
		
		tab.add(blockquoteExp1);
		
		Blockquote blockquoteExp2 = new Blockquote();
		blockquoteExp2.add(Html.p(Resources.INSTANCE.loremIpsum().getText()));
		blockquoteExp2.add(Html.footer("Someone famous in").nbsp().add(Html.cite("Source Title")));
		
		blockquoteExp2.setReverse(true);
		
		tab.add(blockquoteExp2);
		//<= 
	}
}