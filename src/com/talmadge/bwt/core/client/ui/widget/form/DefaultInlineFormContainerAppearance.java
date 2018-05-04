package com.talmadge.bwt.core.client.ui.widget.form;

public class DefaultInlineFormContainerAppearance extends DefaultFormContainerAppearance implements InlineFormContainerAppearance
{
	/**
	 * 
	 */
	public DefaultInlineFormContainerAppearance ()
	{
		super();
	}
	
	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		super.build();
		
		this.ensureCssName("form-inline");
	} 
}
