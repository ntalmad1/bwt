package com.talmadge.bwt.core.client.ui.widget.html.pre;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.TextTransform;
import com.google.gwt.user.client.ui.HTML;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.TextWrap;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class Pre extends Html
{
	/**
	 * Constructor 
	 *
	 */
	public Pre ()
	{
		this.setCell(new PreCell());
		this.initWidget(this.getCell());
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param html HTML
	 */
	public Pre (HTML html)
	{
		this();
		this.add(html);
	}


	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public Pre (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param isScrollable boolean
	 * @return P
	 */
	public Pre setScrollable (boolean isScrollable)
	{
		this.getCell().setScrollable(isScrollable);
		
		return this;
	}


	/**
	 * 
	 * @param align TextAlign
	 * @return P
	 */
	public Pre setTextAlign (TextAlign align)
	{	
		super.setTextAlign(align);
		
		return this;
	}
	
	
	/**
	 * 
	 * @param textTransform TextTransform
	 * @return P
	 */
	public Pre setTextTransform (TextTransform textTransform)
	{
		super.setTextTransform(textTransform);
		
		return this;
	}


	/**
	 * 
	 * @param textWrap TextWrap
	 * @return P
	 */
	public Pre setTextWrap (TextWrap textWrap)
	{
		super.setTextWrap(textWrap);
		
		return this;
	}
	
	
	/**
	 * 
	 * @return PCell
	 */
	protected PreCell getCell ()
	{
		return (PreCell) super.getCell();
	}
}
