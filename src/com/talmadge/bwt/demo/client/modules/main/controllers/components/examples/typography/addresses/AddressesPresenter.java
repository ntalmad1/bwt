package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.addresses;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class AddressesPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public AddressesPresenter ()
	{
		super();
		
		this.setView(new AddressesView(this));
	}

	
	/**
	 * 
	 * @return AddressesView
	 */
	public AddressesView getView ()
	{
		return (AddressesView) super.getView();
	}
}
