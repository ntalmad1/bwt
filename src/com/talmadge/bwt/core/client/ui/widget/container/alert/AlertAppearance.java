package com.talmadge.bwt.core.client.ui.widget.container.alert;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.AlertStyle;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public interface AlertAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 * @param style AlertStyle
	 */
	void setStyle (AlertStyle style);
}
