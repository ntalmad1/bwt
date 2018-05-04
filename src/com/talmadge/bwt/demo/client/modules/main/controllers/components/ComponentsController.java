package com.talmadge.bwt.demo.client.modules.main.controllers.components;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class ComponentsController extends BwtController
{
	/**
	 * 
	 */
	public ComponentsController ()
	{
		super();
		this.setView(new ComponentsView(this));
	}
}
