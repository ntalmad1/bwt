package com.talmadge.bwt.core.client.ui.widget.container.well;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.WellSize;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public interface WellAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * @param size WellSize
	 */
	void setWellSize (WellSize size);
	
}
