package com.talmadge.bwt.demo.client.modules.main.controllers.tables;

import com.talmadge.bwt.core.client.app.endpoint.presenter.view.BwtView;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 *
 */
public class TablesView extends BwtView
{

	/**
	 * 
	 * @param presenter LayoutsPresenter
	 */
	public TablesView (TablesController controller)
	{
		super(controller);
	}

	@Override
	protected void init ()
	{
		
		
	}

	
	@Override
	public void go ()
	{
		this.clear();
		this.add(new Html("Tables"));
	}
	
}
