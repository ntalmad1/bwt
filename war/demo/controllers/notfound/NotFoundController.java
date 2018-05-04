package com.talmadge.bwt.demo.client.controllers.notfound;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class NotFoundController extends BwtController
{
    public NotFoundController ()
    {
    	super();
    	this.setView(new NotFoundView(this));
    }
}
