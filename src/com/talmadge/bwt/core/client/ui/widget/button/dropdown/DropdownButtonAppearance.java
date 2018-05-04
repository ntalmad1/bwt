package com.talmadge.bwt.core.client.ui.widget.button.dropdown;

import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.dropdown.DropdownButton.Direction;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroupAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface DropdownButtonAppearance extends ButtonGroupAppearance 
{	
	/**
	 * 
	 * @return String
	 */
	String getText ();

	/**
	 * 
	 * @param button Button
	 */
	void setButton (Button button);

	/**
	 * 
	 * @param direction Direction
	 */
	void setDirection (Direction direction);
	
	/**
	 * 
	 * @param text String
	 */
	void setText (String text);
}
