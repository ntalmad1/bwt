package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips;

import com.talmadge.bwt.core.client.app.endpoint.presenter.controller.BwtController;

/**
 * 
 *
 */
public class TooltipsController extends BwtController
{
    /**
     * Constructor
     * 
     */
    public TooltipsController ()
    {
       super();
       this.setView(new TooltipsView(this));
    }
}
