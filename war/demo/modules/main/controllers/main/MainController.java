package com.talmadge.bwt.demo.client.modules.main.controllers.main;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class MainController extends BwtController
{
	/**
	 * 
	 */
	public MainController ()
	{
		super();
		this.setView(new MainView(this));
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void setup ()
	{
		
				
	}



}
