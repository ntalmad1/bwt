package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.splitbuttons;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class SplitButtonsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public SplitButtonsPresenter ()
	{
		super();
		
		this.setView(new SplitButtonsView(this));
	}

	
	/**
	 * 
	 * @return SplitButtonsView
	 */
	public SplitButtonsView getView ()
	{
		return (SplitButtonsView) super.getView();
	}
}
