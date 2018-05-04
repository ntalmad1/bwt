package com.talmadge.bwt.core.client.ui.widget.container.dialog;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultBwtDialogAppearance extends DefaultBwtWidgetContainerAppearance implements BwtDialogAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultBwtDialogAppearance ()
	{
		super(Document.get().createDivElement());
	}

	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.ensureCssName("modal");
		this.getElement().setAttribute("tabindex", "-1");
	}

}
