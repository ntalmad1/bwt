package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.sizing;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class SizingPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public SizingPresenter ()
	{
		super();
		
		this.setView(new SizingView(this));
	}

	
	/**
	 * 
	 * @return SizingView
	 */
	public SizingView getView ()
	{
		return (SizingView) super.getView();
	}
}
