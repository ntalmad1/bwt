package com.talmadge.bwt.core.client.ui.widget.button.close;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.button.Button;

/**
 * 
 * @author Noah
 *
 */
public class CloseButton extends Button
{
	/**
	 * Constructor
	 * 
	 */
	public CloseButton ()
	{
		this((CloseButtonAppearance) GWT.create(DefaultCloseButtonAppearance.class));
	}
	
	
	/**
	 * 
	 * @param appearance CloseButtonAppearance
	 */
	protected CloseButton (CloseButtonAppearance appearance)
	{
		super(appearance);
		
		this.setIcon(Glyphicon.REMOVE);
	}
}
