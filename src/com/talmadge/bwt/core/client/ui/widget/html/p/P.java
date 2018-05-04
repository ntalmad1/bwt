package com.talmadge.bwt.core.client.ui.widget.html.p;

import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.TextTransform;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.TextWrap;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class P extends Html
{
	/**
	 * Constructor 
	 *
	 */
	public P ()
	{
		this.setCell(new PCell());
		this.initWidget(this.getCell());
	}
	
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public P (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param isLead boolean
	 * @return P
	 */
	public P setLead (boolean isLead)
	{
		this.getCell().setLead(isLead);
		
		return this;
	}


	/**
	 * 
	 * @param align TextAlign
	 * @return P
	 */
	public P setTextAlign (TextAlign align)
	{	
		super.setTextAlign(align);
		
		return this;
	}
	
	
	/**
	 * 
	 * @param textTransform TextTransform
	 * @return P
	 */
	public P setTextTransform (TextTransform textTransform)
	{
		super.setTextTransform(textTransform);
		
		return this;
	}


	/**
	 * 
	 * @param textWrap TextWrap
	 * @return P
	 */
	public P setTextWrap (TextWrap textWrap)
	{
		super.setTextWrap(textWrap);
		
		return this;
	}
	
	
	/**
	 * 
	 * @return PCell
	 */
	protected PCell getCell ()
	{
		return (PCell) super.getCell();
	}
}
