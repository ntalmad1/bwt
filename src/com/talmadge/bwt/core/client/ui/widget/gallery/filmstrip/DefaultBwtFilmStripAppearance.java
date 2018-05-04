package com.talmadge.bwt.core.client.ui.widget.gallery.filmstrip;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultBwtFilmStripAppearance extends DefaultBwtWidgetContainerAppearance implements BwtFilmStripAppearance
{
	/**
	 * Constructor
	 * 
	 */
	protected DefaultBwtFilmStripAppearance ()
	{
		super(Document.get().createDivElement());
	}

	
	/**
	 * 
	 */
	@Override
	protected void build ()
	{
		this.ensureCssName("well");
		this.ensureCssName("bwt-filmstrip");
	}
}
