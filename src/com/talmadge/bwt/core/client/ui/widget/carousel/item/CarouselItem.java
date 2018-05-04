package com.talmadge.bwt.core.client.ui.widget.carousel.item;

import com.google.gwt.dom.client.Element;

/**
 * 
 *
 */
public class CarouselItem 
{
    /**
     */
    private CarouselItemAppearance appearance;
    
    
    
    /**
     * Constructor 
     * 
     */
    public CarouselItem ()
    {
        this.appearance = new DefaultCarouselItemAppearance();
    }
    
    
    /**
     * Constructor
     * 
     * @param url String
     */
    public CarouselItem (String url)
    {
        this();
        this.getAppearance().setUrl(url);
    }
    
    
    /**
     * 
     * @return Element
     */
    public Element getElement ()
    {
        return this.getAppearance().getElement();
    }
    
    
    /**
     * 
     * @return CarouselItemAppearance
     */
    protected CarouselItemAppearance getAppearance ()
    {
        return this.appearance;
    }
}
