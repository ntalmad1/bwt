package com.talmadge.bwt.core.client.ui.widget.button;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ButtonSize;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.appearance.HasIcon;
import com.talmadge.bwt.core.client.ui.widget.button.interfaces.HasButtonStyle;

/**
 * 
 * @author Noah
 *
 */
public interface ButtonAppearance extends BwtWidgetAppearance, HasButtonStyle, HasIcon
{
	/**
	 * @param pressed boolean
	 */
	void setPressed (boolean pressed);

	/**
	 * @param block boolean
	 */
	void setBlock (boolean block);

	/**
	 * 
	 * @param size ButtonSize
	 */
	void setButtonSize (ButtonSize size);
	
	/**
	 * @param disabled boolean
	 */
	void setDisabled (boolean disabled);

	/**
	 * 
	 * @param string String
	 */
	void setText (String string);
}
