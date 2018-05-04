package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.typography.alignment;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class AlignmentPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public AlignmentPresenter ()
	{
		super();
		
		this.setView(new AlignmentView(this));
	}

	
	/**
	 * 
	 * @return AlignmentView
	 */
	public AlignmentView getView ()
	{
		return (AlignmentView) super.getView();
	}
}
