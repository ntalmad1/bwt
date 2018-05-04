package com.talmadge.bwt.core.client.ui.widget.html.list;

import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.html.cell.DefaultHtmlAppearance;

/**
 * 
 * @author Noah
 *
 */
public abstract class DefaultAbstractListAppearance extends DefaultHtmlAppearance implements AbstractListAppearance
{
	/**
	 * Constructor 
	 *
	 * @param element Element
	 */
	protected DefaultAbstractListAppearance (Element element)
	{
		super(element);
	}
	
	
	/**
	 * 
	 * @param isInline boolean
	 */
	public void setInline (boolean isInline)
	{
		this.toggleCssName("list-inline", isInline);
	}
	
	
	/**
	 * 
	 * @param isStyled boolean
	 */
	public void setStyled (boolean isStyled)
	{
		this.toggleCssName("list-unstyled", !isStyled);
	}
}
