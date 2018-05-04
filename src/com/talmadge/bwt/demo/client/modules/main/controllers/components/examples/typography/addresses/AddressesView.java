/* @bwtExample */
package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.addresses;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.address.Address;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.demo.client.lib.example.BwtExampleView;

/**
 * 
 * @author Noah  
 * 
 */
public class AddressesView extends BwtExampleView
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
	 * @param presenter AddressesPresenter
	 */
	public AddressesView (AddressesPresenter presenter)
	{
		super(presenter, "Addresses");
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
		Address address = new Address();
		address.add(Html.strong("Twitter, Inc.")).br(); 
		address.append("795 Folsom Ave, Suite 600").br();
		address.append("San Francisco, CA 94107").br();
		address.add(Html.abbr("P:", "Phone")).nbsp().append("(123) 456-7890").br();
		address.add(Html.a("first.last@example.com").setHref("mailto:#"));
		
		tab.add(address);
		//<= 
	}
}