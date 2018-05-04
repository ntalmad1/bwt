package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.abbreviations;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class AbbreviationsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public AbbreviationsPresenter ()
	{
		super();
		
		this.setView(new AbbreviationsView(this));
	}

	
	/**
	 * 
	 * @return ParagraphsView
	 */
	public AbbreviationsView getView ()
	{
		return (AbbreviationsView) super.getView();
	}
}
