package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.singlebuttons;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class SingleButtonsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public SingleButtonsPresenter ()
	{
		super();
		
		this.setView(new SingleButtonsView(this));
	}

	
	/**
	 * 
	 * @return SingleButtonsView
	 */
	public SingleButtonsView getView ()
	{
		return (SingleButtonsView) super.getView();
	}
}
