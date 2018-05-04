package com.talmadge.bwt.core.client.ui.widget.html.cell;

import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.TextTransform;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.Context;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.TextWrap;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.html.HtmlTag;

/**
 * 
 * @author Noah
 *
 */
public class HtmlCell extends BwtWidgetContainer
{
	/**
	 * Constructor 
	 *
	 * @param tag HtmlTag
	 */
	public HtmlCell (HtmlTag tag)
	{
		this(new DefaultHtmlAppearance(tag));
	}


	/**
	 * Constructor
	 * 
	 * @param tag HtmlTag
	 * @param innerHtml String
	 */
	public HtmlCell (HtmlTag tag, String innerHtml)
	{
		this(tag);
		
		this.setInnerHtml(innerHtml);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param appearance HtmlWidgetAppearance
	 */
	protected HtmlCell (HtmlAppearance appearance)
	{
		super(appearance);
	}
	
	
	/**
	 * 
	 * @param string String
	 * @return Html
	 */
	public HtmlCell append (String string)
	{
		this.getAppearance().append(string);
		
		return this;
		
	}


	/**
	 * 
	 * @return String
	 */
	public String getInnerHtml ()
	{
		return this.getAppearance().getInnerHtml();	
	}

	
	/**
	 * 
	 * @param key String
	 * @param value String
	 */
	public void setAttribute (String key, String value)
	{
		this.getAppearance().setAttribute(key, value);		
	}


	/**
	 * 
	 * @param context Context
	 */
	public void setBgContext (Context context)
	{
		this.getAppearance().setBgContext(context);
		
	}

	
	/**
	 * 
	 * @param isBold boolean
	 * @return Html
	 */
	public void setBold (boolean isBold)
	{
		this.getAppearance().setBold(isBold);
	}


	/**
	 * 
	 * @param context Context
	 */
	public void setContext (Context context)
	{
		this.setTextContext(context);
		this.setBgContext(context);
	}

	
	/**
	 * 
	 * @param size int
	 */
	public void setFontSize (int size)
	{
		this.getAppearance().setFontSize(size);		
	}


	/**
	 * 
	 * @param fontStyle FontStyle
	 */
	public void setFontStyle (FontStyle fontStyle) 
	{
		this.getAppearance().setFontStyle(fontStyle);
	}


	/**
	 * 
	 * @param fontWeight FontWeight
	 */
	public void setFontWeight (FontWeight fontWeight)
	{
		this.getAppearance().setFontWeight(fontWeight);
	}


	/**
	 * 
	 * @param innerHtml String
	 */
	public void setInnerHtml (String innerHtml)
	{
		this.getAppearance().setInnerHtml(innerHtml);		
	}
	
	
	/**
	 * 
	 * @param textAlign TextAlign
	 */
	public void setTextAlign (TextAlign textAlign)
	{
		this.getAppearance().setTextAlign(textAlign);
	}
	

	/**
	 * 
	 * @param context Context
	 */
	public void setTextContext (Context context)
	{
		this.getAppearance().setTextContext(context);
	}


	/**
	 * 
	 * @param textTransform TextTransform
	 */
	public void setTextTransform (TextTransform textTransform)
	{
		this.getAppearance().setTextTransform(textTransform);		
	}


	/**
	 * 
	 * @param textWrap TextWrap
	 */
	public void setTextWrap (TextWrap textWrap)
	{
		this.getAppearance().setTextWrap(textWrap);		
	}

	
	/**
	 * 
	 * @param align
	 */
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getAppearance().setVerticalAlign(align);
	}


	/**
	 * 
	 * @return HtmlWidgetAppearance
	 */
	protected HtmlAppearance getAppearance ()
	{
		return (HtmlAppearance) super.getAppearance();
	}
}
