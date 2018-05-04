package com.talmadge.bwt.core.client.ui.widget.menu;

import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.MenuAlign;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface MenuAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * @param menuAlign MenuAlign
	 */
	void setMenuAlign (MenuAlign menuAlign);
}
