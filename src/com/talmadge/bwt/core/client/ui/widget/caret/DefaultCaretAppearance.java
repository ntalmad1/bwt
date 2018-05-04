package com.talmadge.bwt.core.client.ui.widget.caret;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultCaretAppearance extends DefaultBwtWidgetAppearance implements CaretAppearance
{
	/**
	 * Constructor
	 * 
	 */
	public DefaultCaretAppearance ()
	{
		super(Document.get().createSpanElement());
	}

	
	/**
	 * 
	 */
	protected void build ()
	{
		this.ensureCssName("caret");
	}
}
