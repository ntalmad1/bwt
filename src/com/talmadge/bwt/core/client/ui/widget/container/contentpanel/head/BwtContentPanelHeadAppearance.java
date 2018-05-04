package com.talmadge.bwt.core.client.ui.widget.container.contentpanel.head;

import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 *
 */
public interface BwtContentPanelHeadAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 * @param title String
	 */
	void setTitle (String title);
	
	/**
	 * 
	 * @param icon Glyphicon
	 */
	void setIcon (Glyphicon icon);
}
