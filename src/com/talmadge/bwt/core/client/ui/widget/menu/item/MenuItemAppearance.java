package com.talmadge.bwt.core.client.ui.widget.menu.item;

import com.talmadge.bwt.core.client.ui.widget.appearance.HasIcon;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.menu.Menu;

/**
 * 
 * @author Noah
 *
 */
public interface MenuItemAppearance extends BwtWidgetContainerAppearance, HasIcon
{	
	/**
	 * 
	 * @return A
	 */
	A getAnchor ();

	/**
	 * 
	 * @param menu Menu
	 */
	void setMenu (Menu menu);

	/**
	 * @param text String
	 */
	void setText (String text);

}
