package com.talmadge.bwt.core.client.ui.dom.layout;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;

/**
 * @author Noah
 *
 */
public final class LayoutUtils
{
	/**
	 * 
	 * @param widget Widget
	 * @param margins margins
	 */
	public static void applyMargins (Widget widget, Margins margins)
	{
		if (margins.getTop() != null)
		{
			widget.getElement().getStyle().setMarginTop(margins.getTop(), Unit.PX);
		}
		
		if (margins.getRight() != null)
		{
			widget.getElement().getStyle().setMarginRight(margins.getRight(), Unit.PX);
		}
		
		if (margins.getBottom() != null)
		{
			widget.getElement().getStyle().setMarginBottom(margins.getBottom(), Unit.PX);
		}
		
		if (margins.getLeft() != null)
		{
			widget.getElement().getStyle().setMarginLeft(margins.getLeft(), Unit.PX);
		}
	}
	
	
	/**
	 * Hidden Constuctor
	 * 
	 */
	private LayoutUtils ()
	{
		
	}

	
	/**
	 * 
	 * @param widget Widget
	 * @param padding Padding
	 */
	public static void applyPadding (Widget widget, Padding padding)
	{
		LayoutUtils.applyPadding(widget.getElement(), padding);
	}

	
	/**
	 * 
	 * @param element Element
	 * @param padding Padding
	 */
	public static void applyPadding (Element element, Padding padding)
	{
		if (padding.getTop() != null)
		{
			element.getStyle().setPaddingTop(padding.getTop(), Unit.PX);
		}
		
		if (padding.getRight() != null)
		{
			element.getStyle().setPaddingRight(padding.getRight(), Unit.PX);
		}
		
		if (padding.getBottom() != null)
		{
			element.getStyle().setPaddingBottom(padding.getBottom(), Unit.PX);
		}
		
		if (padding.getLeft() != null)
		{
			element.getStyle().setPaddingLeft(padding.getLeft(), Unit.PX);
		}
	}
}
