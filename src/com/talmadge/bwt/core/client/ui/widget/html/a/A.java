package com.talmadge.bwt.core.client.ui.widget.html.a;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.html.Html;

/**
 * 
 * @author Noah
 *
 */
public class A extends Html implements HasClickHandlers
{
	/**
	 * Constructor 
	 *
	 */
	public A ()
	{
		this.setCell(new ACell());
		this.initWidget(this.getCell());
	}
	

	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public A (String html)
	{
		this();
		this.setInnerHtml(html);
	}

	
	/**
	 * 
	 * @param clickHandler ClickHandler
	 * @return HandlerRegistration
	 */
    public HandlerRegistration addClickHandler (ClickHandler clickHandler)
    {
        return this.getCell().addClickHandler(clickHandler);        
    }


    /**
	 * 
	 * @param href String
	 * @return A
	 */
	public A setHref (String href)
	{
		this.getCell().setHref(href);
		
		return this;
	}


	/**
	 * 
	 * @param html String
	 */
	public void setInnerHTML (String html)
	{
		this.getCell().setInnerHtml(html);
	}


	/**
	 * 
	 * @return AbbrCell
	 */
	protected ACell getCell ()
	{
		return (ACell) super.getCell();
	}
}
