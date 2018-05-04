package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.buttons.states;

import com.talmadge.bwt.demo.client.lib.example.BwtExamplePresenter;

/**
 * 
 * @author Noah
 *
 */
public class ButtonStatesPresenter extends BwtExamplePresenter
{
	/**
	 * Constructor
	 * 
	 */
	public ButtonStatesPresenter ()
	{
		super();
		
		this.setView(new ButtonStatesView(this));
	}

	
	/**
	 * 
	 * @return ButtonsViews
	 */
	public ButtonStatesView getView ()
	{
		return (ButtonStatesView) super.getView();
	}
}
