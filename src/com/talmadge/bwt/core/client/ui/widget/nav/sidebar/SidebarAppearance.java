package com.talmadge.bwt.core.client.ui.widget.nav.sidebar;

import com.talmadge.bwt.core.client.ui.widget.nav.NavAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface SidebarAppearance extends NavAppearance
{
	/**
	 * 
	 * @param offset int
	 */
	void setOffsetBottom (int offset);

	/**
	 * 
	 * @param offset int
	 */
	void setOffsetTop (int offset);
}
