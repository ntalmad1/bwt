package com.talmadge.bwt.core.client.ui.widget.button.toolbar;

import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface ButtonToolbarAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * 
	 * @param button Button
	 */
	void add (Button button);
	
	/**
	 * 
	 * @param buttonGroup ButtonGroup
	 */
	void add (ButtonGroup buttonGroup);
	
	/**
	 * 
	 * @param button Button
	 */
	void remove (Button button);
	
	/**
	 * 
	 * @param buttonGroup ButtonGroup
	 */
	void remove (ButtonGroup buttonGroup);
}
