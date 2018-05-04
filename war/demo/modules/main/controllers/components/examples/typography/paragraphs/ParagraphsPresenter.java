package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.paragraphs;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class ParagraphsPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ParagraphsPresenter ()
	{
		super();
		
		this.setView(new ParagraphsView(this));
	}

	
	/**
	 * 
	 * @return ParagraphsView
	 */
	public ParagraphsView getView ()
	{
		return (ParagraphsView) super.getView();
	}
}
