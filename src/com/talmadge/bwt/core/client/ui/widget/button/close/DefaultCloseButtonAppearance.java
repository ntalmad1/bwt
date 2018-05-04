package com.talmadge.bwt.core.client.ui.widget.button.close;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.button.DefaultButtonAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultCloseButtonAppearance extends DefaultButtonAppearance implements CloseButtonAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultCloseButtonAppearance ()
	{
		super(Document.get().createPushButtonElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("close");
		
		this.getElement().addClassName("bwt-context-button");
	}

}
