package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.vertical;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class VerticalPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public VerticalPresenter ()
	{
		super();
		
		this.setView(new VerticalView(this));
	}

	
	/**
	 * 
	 * @return VerticalView
	 */
	public VerticalView getView ()
	{
		return (VerticalView) super.getView();
	}
}
