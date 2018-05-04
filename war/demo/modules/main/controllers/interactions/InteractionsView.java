package com.talmadge.bwt.demo.client.modules.main.controllers.interactions;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public class InteractionsView extends BwtView
{
	/**
	 * Constructor
	 * 
	 * @param controller InteractionsController
	 */
	public InteractionsView (InteractionsController controller)
	{
		super(controller);
	}

	
	/**
	 * 
	 */
	@Override
	protected void init ()
	{

		
	}


	/**
	 * 
	 */
	@Override
	public void go ()
	{
		this.clear();
		this.add(new Html("Interactions"));
		
	}
	
}
