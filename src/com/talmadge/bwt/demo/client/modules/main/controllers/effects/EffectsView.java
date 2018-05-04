package com.talmadge.bwt.demo.client.modules.main.controllers.effects;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public class EffectsView extends BwtView
{

	/**
	 * 
	 * @param controller EffectsController
	 */
	public EffectsView (EffectsController controller)
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
		this.add(new Html("Effects"));		
	}
	
}
