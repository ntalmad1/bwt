package com.talmadge.bwt.core.client.ui.widget.component;

import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;

/**
 * 
 *
 */
public abstract class BwtComponent extends BwtComposite
{
	/**
	 */
	private BwtComponentView view;
	
	
	/**
	 * 
	 * @return BwtComponentView
	 */
	protected BwtComponentView getView ()
	{
		return this.view;
	}
	
	
	/**
	 * 
	 * @param view BwtComponentView
	 */
	protected void setView (BwtComponentView view)
	{
		this.view = view;
		
		this.initWidget(view.asWidget());
	}
}
