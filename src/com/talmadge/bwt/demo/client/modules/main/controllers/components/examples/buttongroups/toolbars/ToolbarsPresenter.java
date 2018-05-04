package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.toolbars;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class ToolbarsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ToolbarsPresenter ()
	{
		super();
		
		this.setView(new ToolbarsView(this));
	}

	
	/**
	 * 
	 * @return ToolbarsView
	 */
	public ToolbarsView getView ()
	{
		return (ToolbarsView) super.getView();
	}
}
