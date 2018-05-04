package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.transformations;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class TransformationsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public TransformationsPresenter ()
	{
		super();
		
		this.setView(new TransformationsView(this));
	}

	
	/**
	 * 
	 * @return TransformationsView
	 */
	public TransformationsView getView ()
	{
		return (TransformationsView) super.getView();
	}
}
