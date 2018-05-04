package com.talmadge.bwt.core.client.ui.widget.layout.column;

import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.layout.column.layoutdata.AbstractColumnData;


/**
 * 
 * @author Noah
 *
 */
public interface LayoutColumnAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 * @param layoutData BwtColumnLayoutData
	 */
	void addLayoutData (AbstractColumnData layoutData);
		
	/**
	 * 
	 * @param height int
	 */
	void setMinHeight (int height);
		
	/**
	 * 
	 * @param align VerticalAlign
	 */
	void setVerticalAlign (VerticalAlign align);
}
