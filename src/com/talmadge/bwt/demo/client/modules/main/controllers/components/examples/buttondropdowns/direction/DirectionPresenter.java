package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttondropdowns.direction;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class DirectionPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public DirectionPresenter ()
	{
		super();
		
		this.setView(new DirectionView(this));
	}

	
	/**
	 * 
	 * @return DirectionView
	 */
	public DirectionView getView ()
	{
		return (DirectionView) super.getView();
	}
}
