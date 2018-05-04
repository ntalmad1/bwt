package com.talmadge.bwt.demo.client.modules.main.controllers.layouts;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class LayoutsController extends BwtController
{
	/**
	 * 
	 */
	public LayoutsController ()
	{
		super();
		this.setView(new LayoutsView(this));
	}
}
