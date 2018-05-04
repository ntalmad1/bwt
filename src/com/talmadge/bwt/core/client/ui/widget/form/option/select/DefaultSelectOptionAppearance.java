package com.talmadge.bwt.core.client.ui.widget.form.option.select;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultSelectOptionAppearance extends DefaultBwtWidgetAppearance implements SelectOptionAppearance
{
	/**
	 * 
	 * @param element Element
	 */
	protected DefaultSelectOptionAppearance (Element element)
	{
		super(element);
	}
	
	
	/**
	 * 
	 */
	public DefaultSelectOptionAppearance ()
	{
		this(DOM.createOption());
	}


	/**
	 * 
	 */
	protected void build ()
	{
		
		
	}


	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		this.getElement().setInnerHTML(label);		
	}
	
	
	/**
	 * 
	 * @param selected boolean
	 */
	public void setSelected (boolean selected)
	{
		if (selected)
		{
			this.getElement().setAttribute("selected", "");
		}
		else
		{
			if (this.getElement().hasAttribute("selected"))
			{
				this.getElement().removeAttribute("selected");
			}
		}
	}
}

