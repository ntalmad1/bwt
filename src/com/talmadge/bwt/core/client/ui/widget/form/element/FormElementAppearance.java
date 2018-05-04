package com.talmadge.bwt.core.client.ui.widget.form.element;

import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.FormElementSize;
import com.talmadge.bwt.core.client.ui.util.Position;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface FormElementAppearance extends BwtWidgetAppearance
{
	/**
	 * 
	 * @return String
	 */
	String getLabel ();

	/**
	 * 
	 */
	void removeLabel ();

	/**
	 * 
	 * @param label String
	 */
	void setLabel (String label);
	
	/**
	 * @param position Position
	 */
	void setMessagePosition (Position position);

	/**
	 * 
	 * @param size FormElementSize
	 */
	void setSize (FormElementSize size);
	
	/**
	 * 
	 * @param state FormElement.State
	 */
	void setState (FormElement.State state);
	
	/**
	 * 
	 * @param state FormElement.State
	 * @param message String
	 */
	void setState (FormElement.State state, String message);
	
	/**
	 * 
	 * @param isRequired
	 */
	void setRequired (boolean isRequired);
}
