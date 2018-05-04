package com.talmadge.bwt.core.client.ui.widget.layout.container;

import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;


/**
 * 
 * @author Noah
 *
 */
public interface LayoutContainerAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * @return boolean
	 */
	boolean isFluid ();
	
	/**
	 * @param color String
	 */
	void setBackgroundColor (String color);

	/**
	 * @param fluid boolean
	 */
	void setFluid (boolean fluid);
	
	/**
	 * @param height int
	 */
	void setMinHeight (int height);

	/**
	 * @param padding int
	 */
	void setPaddingBottom (int padding);	
	
	/**
	 * 
	 * @param align VerticalAlign
	 */
	void setVerticalAlign (VerticalAlign align);
}
