package com.talmadge.bwt.core.client.ui.widget.nav.navbar;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavBarFixedStyle;
import com.talmadge.bwt.core.client.ui.widget.nav.NavAppearance;

/**
 * 
 *
 */
public interface NavBarAppearance extends NavAppearance
{
	/**
	 * 
	 * @param style NavBarFixedStyle
	 */
	void setFixed (NavBarFixedStyle style);
		
	/**
	 * 
	 * @param isInverse boolean
	 */
	void setInverse (boolean isInverse);

}
