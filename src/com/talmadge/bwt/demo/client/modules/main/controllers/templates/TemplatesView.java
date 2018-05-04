package com.talmadge.bwt.demo.client.modules.main.controllers.templates;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public class TemplatesView extends BwtView
{

	/**
	 * 
	 * @param controller LayoutsPresenter
	 */
	public TemplatesView (TemplatesController controller)
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
		this.add(new Html("Templates"));		
	}
	
}
