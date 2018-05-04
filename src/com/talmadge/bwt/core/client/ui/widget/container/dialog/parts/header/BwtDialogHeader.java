package com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.header;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.close.CloseButton;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class BwtDialogHeader extends BwtWidgetContainer
{
	/**
	 */
	private CloseButton closeButton;


	/**
	 * Constructor
	 * 
	 */
	public BwtDialogHeader ()
	{
		this((BwtDialogHeaderAppearance) GWT.create(DefaultBwtDialogHeaderAppearance.class));
	}
	
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance BwtContentPanelAppearance
	 */
	protected BwtDialogHeader (BwtDialogHeaderAppearance appearance)
	{
		super(appearance);
		
		this.closeButton = new CloseButton();
		this.insertWidget(this.closeButton, 0);
	}
	
	
	/**
	 * 
	 * @return Button
	 */
	public Button getCloseButton ()
	{
		return this.closeButton;
	}


	/**
	 * 
	 * @param icon Glyphicon
	 */
	public void setIcon (Glyphicon icon)
	{
		this.getAppearance().setIcon(icon);		
	}


	/**
	 * 
	 * @param title String
	 */
	public void setTitle (String title)
	{
		this.getAppearance().setTitle(title);
	}
	
	
	/**
	 * 
	 * @return BwtContentPanelHeadAppearance
	 */
	protected BwtDialogHeaderAppearance getAppearance ()
	{
		return (BwtDialogHeaderAppearance) super.getAppearance();
	}

}
