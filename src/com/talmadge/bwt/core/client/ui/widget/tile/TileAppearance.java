package com.talmadge.bwt.core.client.ui.widget.tile;

import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.appearance.HasIcon;


/**
 * @author Noah
 *
 */
public interface TileAppearance extends BwtWidgetAppearance, HasIcon
{
	/**
	 * 
	 * @param text String
	 */
	void setText (String text);
}
