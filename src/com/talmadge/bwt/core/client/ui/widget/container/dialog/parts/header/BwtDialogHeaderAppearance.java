package com.talmadge.bwt.core.client.ui.widget.container.dialog.parts.header;

import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 *
 */
public interface BwtDialogHeaderAppearance extends BwtWidgetContainerAppearance
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
