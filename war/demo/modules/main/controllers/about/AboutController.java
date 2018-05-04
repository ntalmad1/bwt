package com.talmadge.bwt.demo.client.modules.main.controllers.about;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class AboutController extends BwtController
{
	/**
	 * Constructor
	 *  
	 */
	public AboutController ()
	{
		super();
		this.setView(new AboutView(this));
	}
}
