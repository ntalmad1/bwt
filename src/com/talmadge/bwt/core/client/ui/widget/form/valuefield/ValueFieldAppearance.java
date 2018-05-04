package com.talmadge.bwt.core.client.ui.widget.form.valuefield;

import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.form.constant.AddonPos;
import com.talmadge.bwt.core.client.ui.widget.form.element.FormElementAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface ValueFieldAppearance extends FormElementAppearance
{
	/**
	 */
	void clear ();

	/**
	 * 
	 * @return InputElement
	 */
	InputElement getInputElement ();


	/**
	 * 
	 * @return String
	 */
	String getInputGroupId ();

	/**
	 * 
	 * @return String
	 */
	String getValue ();


	/**
	 */
	void focus ();

	
	/**
	 * 
	 * @param icon Glyphicon
	 * @param pos AddonPos
	 */
	void setAddon (Glyphicon icon, AddonPos pos);
	
	
	/**
	 * 
	 * @param string String
	 * @param pos AddonPos
	 */
	void setAddon (String string, AddonPos pos);
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param pos AddonPos
	 */
	void setAddon (Widget widget, AddonPos pos);
	
	
	/**
	 * 
	 * @param string String
	 */
	void setInputGroupId (String string);


	/**
	 * 
	 * @param placeholder String
	 */
	void setPlaceholder (String placeholder);

	
	/**
	 * 
	 * @param maxLength int
	 */
	void setMaxLength (int maxLength);
}
