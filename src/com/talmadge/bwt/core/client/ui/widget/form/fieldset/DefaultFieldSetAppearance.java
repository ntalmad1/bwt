package com.talmadge.bwt.core.client.ui.widget.form.fieldset;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.widget.form.DefaultBwtFormAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultFieldSetAppearance extends DefaultBwtFormAppearance implements FieldSetAppearance
{
	/**
	 */
	private Element legend;
	
	/**
	 */
	private String label;
	
	
	/**
	 * 
	 */
	public DefaultFieldSetAppearance ()
	{
		this(DOM.createFieldSet());
	}

	/**
	 * 
	 * @param element Element
	 */
	protected DefaultFieldSetAppearance (Element element)
	{
		super(element);
	}

	/**
	 * 
	 */
	protected void build ()
	{
		this.ensureCssName("fieldset");
		
		this.legend = DOM.createLegend();
		this.ensureCssName(this.legend, "fieldset-legend");
		
		this.getElement().appendChild(this.legend);
	}


	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		this.label = label;
		
		this.legend.setInnerHTML(label);
	}

	/**
	 * 
	 * return String
	 */
	@Override
	public String getLabel ()
	{
		return this.label;
	}

}
