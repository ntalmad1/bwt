package com.talmadge.bwt.core.client.ui.widget.layout.row;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;


/**
 * 
 * @author Noah
 *
 */
public class ClearFix 
{
	/**
	 */
	private Element element;
	
	
	/**
	 * Constructor
	 * 
	 * @param size Size
	 */
	public ClearFix (Size size)
	{
		this.element = Document.get().createDivElement();
		
		
		String colSize = "";
		
		switch (size)
		{
			case XS:
				colSize = "xs";
				break;
				
			case SM:
				colSize = "sm";
				break;
				
			case MD:
				colSize = "md";
				break;
				
			case LG:
				colSize = "lg";
				break;
			default:
				break;		
		}
		
		
		this.element.addClassName("clearfix");
		this.element.addClassName("visible-" + colSize + "-block");
	}
	
	
	/**
	 * 
	 * @return Element
	 */
	public Element getElement ()
	{
		return this.element;
	}
}
