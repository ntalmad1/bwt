package com.talmadge.bwt.core.client.ui.widget.form;

import com.google.gwt.core.client.GWT;

/**
 * 
 *
 */
public class InlineFormContainer extends FormContainer
{
	/**
	 * Constructor
	 * 
	 */
	public InlineFormContainer ()
	{
		this((InlineFormContainerAppearance) GWT.create(DefaultInlineFormContainerAppearance.class));
	}
	
	
	/**
	 * 
	 * @param appearance
	 */
	protected InlineFormContainer (InlineFormContainerAppearance appearance)
	{
		super(appearance);
	}
}
