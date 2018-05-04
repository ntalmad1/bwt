package com.talmadge.bwt.core.client.ui.widget.html.a;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.talmadge.bwt.core.client.ui.widget.html.cell.HtmlCell;

/**
 * 
 * @author Noah
 *
 */
public class ACell extends HtmlCell implements HasClickHandlers
{
	/**
	 * Constructor 
	 *
	 */
	public ACell ()
	{
		this((DefaultAAppearance) GWT.create(DefaultAAppearance.class));
	}
	
	/**
	 * Constructor 
	 *
	 * @param html String
	 */
	public ACell (String html)
	{
		this();
		this.setInnerHtml(html);
	}
	
	
	/**
	 * 
	 * @param appearance AbbrCellAppearance
	 */
	protected ACell (AAppearance appearance)
	{
		super(appearance);
		
		this.bind();
	}
	
	
	/**
	 * 
	 * @param handler ClickHandler
	 */
	@Override
    public HandlerRegistration addClickHandler (ClickHandler handler)
    {
        return this.addHandler(handler, ClickEvent.getType());
    }

    /**
	 * 
	 * @return AbbrCellAppearance
	 */
	public AAppearance getAppearance ()
	{
		return (AAppearance) super.getAppearance();
	}

	
	/**
	 * 
	 * @param href String
	 */
	public void setHref (String href)
	{
		this.getAppearance().setHref(href);
	}

	
	/**
	 * 
	 */
    protected void bind ()
    {
        this.addDomHandler(new ClickHandler()
        {
            public void onClick (ClickEvent event)
            {
                ACell.this.onClick(event);
            }
        }, ClickEvent.getType());
    }
    
    
    /**
     * 
     * @param event ClickEvent
     */
    protected void onClick (ClickEvent event)
    {
        
    }
}
