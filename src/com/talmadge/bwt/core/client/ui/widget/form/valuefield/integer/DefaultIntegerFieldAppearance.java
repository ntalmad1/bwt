package com.talmadge.bwt.core.client.ui.widget.form.valuefield.integer;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.talmadge.bwt.core.client.ui.widget.form.valuefield.DefaultValueFieldAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultIntegerFieldAppearance extends DefaultValueFieldAppearance implements IntegerFieldAppearance
{
	/**
	 * Constructor
	 *  
	 */
	public DefaultIntegerFieldAppearance ()
	{
		super();
	}
	
	
	/**
	 * 
	 * @return InputElement 
	 */
	protected InputElement createInputElement ()
	{
		InputElement input = Document.get().createTextInputElement();
		
		//input.setPropertyString("type", "number");
		//input.setPropertyInt("step", 1);
		
		return input;
	}
}
