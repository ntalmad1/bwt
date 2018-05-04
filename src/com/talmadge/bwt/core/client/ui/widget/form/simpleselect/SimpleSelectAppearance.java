package com.talmadge.bwt.core.client.ui.widget.form.simpleselect;

import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElementAppearance;
import com.talmadge.bwt.core.client.ui.widget.form.option.select.SelectOption;

/**
 * 
 * @author Noah
 *
 */
public interface SimpleSelectAppearance extends FormElementAppearance
{
	/**
	 * 
	 * @param option SelectOption<?>
	 */
	void addOption (SelectOption<?> option);
	
	/**
	 */
	void clear ();

	/**
	 *
	 * @return Element
	 */
	Element getSelectElement ();

	/**
	 * 
	 * @return boolean
	 */
	boolean hasPlaceholder ();

	/**
	 * 
	 * @param disabled boolean
	 */
	void setDisabled (boolean disabled);
	
	/**
	 * 
	 * @param hasSelection boolean
	 */
	void setHasSelection (boolean hasSelection);

	/**
	 * 
	 * @param selected boolean
	 */
	void setPlaceholderSelected (boolean selected);

	/**
	 * 
	 * @param placeholder String
	 */
	void setPlaceholder (String placeholder);

}
