package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.headings;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class HeadingsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public HeadingsPresenter ()
	{
		super();
		
		this.setView(new HeadingsView(this));
	}

	
	/**
	 * 
	 * @return ButtonBlockView
	 */
	public HeadingsView getView ()
	{
		return (HeadingsView) super.getView();
	}
}
