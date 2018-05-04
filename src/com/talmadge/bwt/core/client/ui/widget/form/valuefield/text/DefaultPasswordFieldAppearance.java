package com.talmadge.bwt.core.client.ui.widget.form.valuefield.text;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.DefaultValueFieldAppearance;

/**
 * 
 *
 */
public class DefaultPasswordFieldAppearance extends DefaultValueFieldAppearance implements PasswordFieldAppearance
{
	/**
	 * Constructor
	 *  
	 */
	public DefaultPasswordFieldAppearance ()
	{
		super();
	}
	
	
	/**
	 * 
	 * @return InputElement
	 */
	protected InputElement createInputElement ()
	{
		InputElement element = Document.get().createTextInputElement();
		element.setAttribute("type", "password");
		
		return element;		
	}
}
