package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.lists;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class ListsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ListsPresenter ()
	{
		super();
		
		this.setView(new ListsView(this));
	}

	
	/**
	 * 
	 * @return ListsView
	 */
	public ListsView getView ()
	{
		return (ListsView) super.getView();
	}
}
