package com.talmadge.bwt.core.client.ui.widget.button.group;

import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface ButtonGroupAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 * @param button Button
	 */
	void add (Button button);
	
	/**
	 * 
	 * @param button Button
	 */
	void remove (Button button);
	
	/**
	 * 
	 * @param isBlock boolean
	 */
	void setBlock (boolean isBlock);
	
	/**
	 * 
	 * @param isVertical boolean
	 */
	void setVertical (boolean isVertical);
}
