package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.block;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class ButtonBlockPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ButtonBlockPresenter ()
	{
		super();
		
		this.setView(new ButtonBlockView(this));
	}

	
	/**
	 * 
	 * @return ButtonBlockView
	 */
	public ButtonBlockView getView ()
	{
		return (ButtonBlockView) super.getView();
	}
}
