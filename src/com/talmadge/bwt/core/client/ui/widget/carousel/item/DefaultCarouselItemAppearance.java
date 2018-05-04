package com.talmadge.bwt.core.client.ui.widget.carousel.item;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * 
 *
 */
public class DefaultCarouselItemAppearance extends DefaultBwtWidgetAppearance implements CarouselItemAppearance
{
    /**
     */
    private Element captionElement;
    
    /**
     */
    private Element imageElement; 
    
    
    /**
     * Constructor
     * 
     */
    protected DefaultCarouselItemAppearance ()
    {
        super(Document.get().createDivElement());
    }

    
    /**
     * 
     * @param url String
     */
    @Override
    public void setUrl (String url)
    {
        this.imageElement.setAttribute("src", url);
    }


    /**
     * 
     */
    @Override
    protected void build ()
    {
        this.ensureCssName("item");   
        
        this.imageElement = Document.get().createImageElement();
        this.ensureCssName(this.imageElement, "img-responsive");
        
        this.getElement().appendChild(this.imageElement);
        
        this.captionElement = Document.get().createDivElement();
        
        this.getElement().appendChild(this.captionElement);
    }
}
