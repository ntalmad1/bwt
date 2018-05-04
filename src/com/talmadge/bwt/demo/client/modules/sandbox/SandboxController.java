package com.talmadge.bwt.demo.client.modules.sandbox;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class SandboxController extends BwtController
{
	/**
	 * Constructor
	 * 
	 */
	public SandboxController ()
	{
		super();
		this.setView(new SandboxView(this));
	}
}









