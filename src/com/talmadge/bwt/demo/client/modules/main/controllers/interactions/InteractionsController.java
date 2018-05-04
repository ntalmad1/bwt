package com.talmadge.bwt.demo.client.modules.main.controllers.interactions;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class InteractionsController extends BwtController
{
	/**
	 * Constructor
	 * 
	 */
	public InteractionsController ()
	{
		super();
		this.setView(new InteractionsView(this));
	}
}
