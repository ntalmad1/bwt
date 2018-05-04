package com.talmadge.bwt.core.client.ui.widget.layout.panel;

import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface BwtPanelAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 * @param widget IsWidget
	 */
	void add (Widget widget);
		
	/**
	 * 
	 * @param widget IsWidget
	 * @param margins Margins
	 */
	void add (Widget widget, Margins margins);
	
	/**
	 * 
	 */
	void clear ();
	
	/**
	 * 
	 * @param widget Widget
	 * @return true if the widget exists
	 */
	boolean remove (Widget widget);
	
    /**
     * 
     * @param padding Padding
     */
	void setPadding (Padding padding);
}
