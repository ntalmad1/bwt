package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.styles;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class ButtonStylesPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ButtonStylesPresenter ()
	{
		super();
		
		this.setView(new ButtonStylesView(this));
	}

	
	/**
	 * 
	 * @return ButtonsViews
	 */
	public ButtonStylesView getView ()
	{
		return (ButtonStylesView) super.getView();
	}
}
