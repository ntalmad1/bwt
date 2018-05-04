package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.inline;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class InlineElementsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public InlineElementsPresenter ()
	{
		super();
		
		this.setView(new InlineElementsView(this));
	}

	
	/**
	 * 
	 * @return InlineElementsView
	 */
	public InlineElementsView getView ()
	{
		return (InlineElementsView) super.getView();
	}
}
