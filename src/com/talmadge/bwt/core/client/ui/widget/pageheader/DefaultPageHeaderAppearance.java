package com.talmadge.bwt.core.client.ui.widget.pageheader;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.SubtextAlign;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;


/**
 * @author Noah
 *
 */
public class DefaultPageHeaderAppearance extends DefaultBwtWidgetAppearance implements PageHeaderAppearance
{
    /**
     */
    private Element headerElement;

    /**
     */
    private Element subElement;
    
    

    /**
     * Constructor
     */
    public DefaultPageHeaderAppearance ()
    {
        super(Document.get().createDivElement());
    }


    /**
     *
     * @param subtext String
     */
    public void setSubtext (String subtext)
    {
        this.subElement.setInnerHTML(subtext);

        if (!this.subElement.hasParentElement())
        {
            this.headerElement.appendChild(this.subElement);
        }
    }


    /**
     *
     * @param align BwtStyle.SubtextAlign
     */
    public void setSubtextAlign (BwtStyle.SubtextAlign align)
    {
        if (align.equals(SubtextAlign.BELOW))
        {
        	this.removeCssName(this.subElement, "bwt-subtext-align-right");
         	this.subElement.getStyle().setDisplay(Display.BLOCK);
        	this.ensureCssName(this.subElement, "bwt-subtext-align-below");
        }
        else
        {
        	this.removeCssName(this.subElement, "bwt-subtext-align-below");
            this.subElement.getStyle().setDisplay(Display.INLINE);
            this.ensureCssName(this.subElement, "bwt-subtext-align-right");
        }
    }


    /**
     *
     * @param text String
     */
    public void setText (String text)
    {
        this.headerElement.setInnerHTML(text);

        if (this.subElement.getInnerHTML() != null && !this.subElement.getInnerHTML().isEmpty())
        {
            this.headerElement.appendChild(this.subElement);
        }
    }



	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("page-header");

		this.subElement = DOM.createElement("small");

		this.headerElement = Document.get().createHElement(1);
		this.headerElement.appendChild(subElement);

		this.getElement().appendChild(this.headerElement);
		
		this.setSubtextAlign(BwtStyle.SubtextAlign.RIGHT);

	}
}
