package com.talmadge.bwt.demo.client.modules.main.controllers.tables;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class TablesController extends BwtController
{
	/**
	 * Constructor
	 * 
	 */
	public TablesController ()
	{
		super();
		this.setView(new TablesView(this));
	}
}
