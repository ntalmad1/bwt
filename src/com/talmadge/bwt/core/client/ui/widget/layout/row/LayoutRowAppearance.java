package com.talmadge.bwt.core.client.ui.widget.layout.row;

import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public interface LayoutRowAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * @param clearFix BwtClearFix
	 */
	void add (ClearFix clearFix);

	/**
	 * @param clearFix BwtClearFix
	 */
	void remove (ClearFix clearFix);
	
	/**
	 * @param height int
	 */
	void setMinHeight (int height);
	
	/**
	 * 
	 * @param align VerticalAlign
	 */
	void setVerticalAlign (VerticalAlign align);
}
