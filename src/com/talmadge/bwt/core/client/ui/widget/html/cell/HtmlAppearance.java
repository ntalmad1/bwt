package com.talmadge.bwt.core.client.ui.widget.html.cell;

import com.google.gwt.dom.client.Style.FontStyle;
import com.google.gwt.dom.client.Style.FontWeight;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.TextTransform;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.Context;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.TextWrap;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public interface HtmlAppearance extends BwtWidgetContainerAppearance
{
	/**
	 * @param html String
	 */
	void append (String html);

	/**
	 * @return String
	 */
	String getInnerHtml ();
	
	/**
	 * @param key String
	 * @param value String
	 */
	void setAttribute (String key, String value);
	
	/**
	 * 
	 * @param isBold
	 */
	void setBold (boolean isBold);

	
	/**
	 * @param context Context
	 */
	void setBgContext (Context context);

	/**
	 * @param size int
	 */
	void setFontSize (int size);

	/**
	 * @param fontStyle FontStyle
	 */
	void setFontStyle (FontStyle fontStyle);

	/**
	 * @param fontWeight FontWeight
	 */
	void setFontWeight (FontWeight fontWeight);

	/**
	 * @param innerHtml String
	 */
	void setInnerHtml (String innerHtml);
	
	/**
	 * @param textAlign TextAlign
	 */
	void setTextAlign (TextAlign textAlign);
	
	/**
	 * 
	 * @param context Context
	 */
	void setTextContext (Context context);

	/**
	 * 
	 * @param textTransform TextTransform
	 */
	void setTextTransform (TextTransform textTransform);

	/**
	 * 
	 * @param textWrap TextWrap
	 */
	void setTextWrap (TextWrap textWrap);
	
	/**
	 * 
	 * @param align VerticalAlign
	 */
	void setVerticalAlign (VerticalAlign align);
}
