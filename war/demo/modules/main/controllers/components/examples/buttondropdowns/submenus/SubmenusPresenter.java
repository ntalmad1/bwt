package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.submenus;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class SubmenusPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public SubmenusPresenter ()
	{
		super();
		
		this.setView(new SubmenusView(this));
	}

	
	/**
	 * 
	 * @return SubmenusView
	 */
	public SubmenusView getView ()
	{
		return (SubmenusView) super.getView();
	}
}
