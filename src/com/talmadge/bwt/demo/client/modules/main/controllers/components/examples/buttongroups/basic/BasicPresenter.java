package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.basic;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class BasicPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public BasicPresenter ()
	{
		super();
		
		this.setView(new BasicView(this));
	}

	
	/**
	 * 
	 * @return BasicView
	 */
	public BasicView getView ()
	{
		return (BasicView) super.getView();
	}
}
