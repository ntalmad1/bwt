package com.talmadge.bwt.core.client.ui.widget.html.cell;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.TextTransform;
import com.google.gwt.dom.client.Style.Unit;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.BwtTextAlign;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.Context;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.TextWrap;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.html.HtmlTag;

/**
 * 
 * @author Noah
 *
 */
public class DefaultHtmlAppearance extends DefaultBwtWidgetContainerAppearance implements HtmlAppearance
{
	/**
	 * Constructor 
	 * 
	 * @param tag HtmlTag
	 */
	protected DefaultHtmlAppearance (HtmlTag tag)
	{
		this(Document.get().createElement(tag.getTagName()));
	}

	
	/**
	 * Constructor 
	 *
	 * @param element Element
	 */
	protected DefaultHtmlAppearance (Element element)
	{
		super(element);
	}


	/**
	 * 
	 */
	protected void build ()
	{
		
	}


	/**
	 * 
	 * @param html String
	 */
	public void append (String html)
	{
		this.setInnerHtml(this.getInnerHtml() + html);
	}


	/**
	 * 
	 * @return String
	 */
	public String getInnerHtml ()
	{
		return this.getElement().getInnerHTML();
	}

	
	/**
	 * 
	 * @param isBold boolean
	 */
	public void setBold (boolean isBold)
	{
		this.setFontWeight(isBold ? FontWeight.BOLD : FontWeight.NORMAL);
	}
	
	
	/**
	 * 
	 * @param key String
	 * @param value String
	 */
	@Override
	public void setAttribute (String key, String value)
	{
		this.getElement().setAttribute(key, value);
	}


	/**
	 * 
	 * @param context Context
	 */
	public void setBgContext (Context context)
	{
		this.removeCssNames(Context.getBgContextValues());
		
		this.ensureCssName(context.getBgContext());		
	}

	
	/**
	 * 
	 * @param size int
	 */
	@Override
	public void setFontSize (int size)
	{
		this.getElement().getStyle().setFontSize(size, Unit.PX);		
	}


	/**
	 * 
	 * @param fontStyle FontStyle
	 */
	@Override
	public void setFontStyle (FontStyle fontStyle) 
	{
		this.getElement().getStyle().setFontStyle(fontStyle);
	}


	/**
	 * 
	 * @param fontWeight FontWeight
	 */
	public void setFontWeight (FontWeight fontWeight)
	{
		this.getElement().getStyle().setFontWeight(fontWeight);
		
	}


	/**
	 * 
	 * @param innerHtml String 
	 */
	public void setInnerHtml (String innerHtml)
	{
		this.getElement().setInnerHTML(innerHtml);		
	}


	/**
	 * 
	 * @param textAlign TextAlign
	 */
	public void setTextAlign (TextAlign textAlign)
	{
		BwtTextAlign bwtTextAlign = BwtTextAlign.getByTextAlign(textAlign);
		
		this.removeCssNames(BwtTextAlign.values());
		this.ensureCssName(bwtTextAlign);
	}
	
	
	/**
	 * 
	 * @param context Context
	 */
	public void setTextContext (Context context)
	{
		this.removeCssNames(Context.getTextContextValues());
		
		this.ensureCssName(context.getTextContext());		
	}


	/**
	 * 
	 * @param textTransform TextTransform
	 */
	public void setTextTransform (TextTransform textTransform)
	{
		this.getElement().getStyle().setTextTransform(textTransform);
	}


	/**
	 * 
	 * @param textWrap TextWrap
	 */
	public void setTextWrap (TextWrap textWrap)
	{
		this.removeCssNames(TextWrap.values());
		this.ensureCssName(textWrap);
	}
}
