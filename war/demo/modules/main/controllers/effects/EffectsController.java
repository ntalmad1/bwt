package com.talmadge.bwt.demo.client.modules.main.controllers.effects;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class EffectsController extends BwtController
{
	/**
	 * Constructor
	 * 
	 */
	public EffectsController ()
	{
		super();
		this.setView(new EffectsView(this));
	}
}
