package com.talmadge.bwt.core.client.ui.widget.form.valuefield.text;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.DefaultValueFieldAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultTextFieldAppearance extends DefaultValueFieldAppearance implements TextFieldAppearance
{
	/**
	 * Constructor
	 *  
	 */
	public DefaultTextFieldAppearance ()
	{
		super();
	}
	
	
	/**
	 * 
	 * @return InputElement
	 */
	protected InputElement createInputElement ()
	{
		return Document.get().createTextInputElement();
	}
}
