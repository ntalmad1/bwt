package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.sizes;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class ButtonSizesPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ButtonSizesPresenter ()
	{
		super();
		
		this.setView(new ButtonSizesView(this));
	}

	
	/**
	 * 
	 * @return ButtonsViews
	 */
	public ButtonSizesView getView ()
	{
		return (ButtonSizesView) super.getView();
	}
}
