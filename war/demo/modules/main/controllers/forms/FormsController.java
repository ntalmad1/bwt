package com.talmadge.bwt.demo.client.modules.main.controllers.forms;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class FormsController extends BwtController
{
    /**
     * Constructor
     * 
     */
    public FormsController ()
    {
       super();
       this.setView(new FormsView(this));
    }
}
