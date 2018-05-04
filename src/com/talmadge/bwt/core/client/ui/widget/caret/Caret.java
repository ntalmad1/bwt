package com.talmadge.bwt.core.client.ui.widget.caret;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 */
public class Caret extends BwtWidget
{
	/**
	 * Constructor
	 * 
	 */
	public Caret ()
	{
		this((CaretAppearance) GWT.create(DefaultCaretAppearance.class));
	}
	
	/**
	 * Constructor
	 * 
	 * @param appearance CaretAppearance
	 */
	protected Caret (CaretAppearance appearance)
	{
		super(appearance);
	}
}
