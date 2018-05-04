package com.talmadge.bwt.demo.client.modules.main.controllers.templates;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class TemplatesController extends BwtController
{
	/**
	 * Constructor
	 * 
	 */
	public TemplatesController ()
	{
		super();
		this.setView(new TemplatesView(this));
	}
}
