package com.talmadge.bwt.core.client.ui.widget.nav.navgroup;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupOrientation;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.NavGroupStyle;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface NavGroupAppearance extends BwtWidgetContainerAppearance
{	
	/**
	 * @return boolean
	 */
	boolean isAffix ();

	/**
	 * 
	 * @param affix boolean
	 */
	void setAffix (boolean affix);

	/** 
	 * @param justified boolean
	 */
	void setJustified (boolean justified);

	/**
	 * @param style NavGroupStyle 
	 */
	void setNavGoupStyle (NavGroupStyle style);
	
	/**
	 * @param offset int
	 */
	void setOffsetBottom (int offset);

	/**
	 * @param offset int
	 */
	void setOffsetTop (int offset);

	/**
	 * @param orientation NavGroupOrientation
	 */
	void setOrientaion (NavGroupOrientation orientation);
}
