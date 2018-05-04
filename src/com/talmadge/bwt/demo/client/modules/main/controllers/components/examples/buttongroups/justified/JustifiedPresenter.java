package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttongroups.justified;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class JustifiedPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public JustifiedPresenter ()
	{
		super();
		
		this.setView(new JustifiedView(this));
	}

	
	/**
	 * 
	 * @return JustifiedView
	 */
	public JustifiedView getView ()
	{
		return (JustifiedView) super.getView();
	}
}
