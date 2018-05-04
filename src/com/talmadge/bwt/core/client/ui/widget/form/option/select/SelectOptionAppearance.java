package com.talmadge.bwt.core.client.ui.widget.form.option.select;

import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface SelectOptionAppearance extends BwtWidgetAppearance
{
	/**
	 * 
	 * @param label String
	 */
	void setLabel (String label);
	
	/**
	 * 
	 * @param selected boolean
	 */
	void setSelected (boolean selected);
}
