package com.talmadge.bwt.core.client.ui.widget.carousel;

import com.talmadge.bwt.core.client.ui.widget.carousel.item.CarouselItem;
import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;

/**
 * 
 * @author noaht
 *
 */
public class Carousel extends BwtComposite
{
    /**
     */
    private CarouselCell cell;
    
    
    
    /**
     * Constructor
     * 
     */
    public Carousel ()
    {
        super();
        
        this.cell = new CarouselCell();
        
        this.initWidget(this.cell);
    }

    
    /**
     * 
     * @param item CarouselItem
     */
    private void add (CarouselItem item)
    {
        this.getCell().add(item);        
    }



    /**
     * 
     * @param url String
     */
    public void add (String url)
    {
        this.add(new CarouselItem(url));        
    }
    
    
    /**
     * 
     * @param centered boolean
     */
    public void setCentered (boolean centered)
    {
        this.getCell().setCentered(centered);
    }


    /**
     * 
     * @param height int
     */
    public void setHeight (int height)
    {
        this.getCell().setHeight(height);
    }


    /**
     * 
     * @param width int
     */
    public void setMaxWidth (int width)
    {
        this.getCell().setMaxWidth(width);
    }


    /**
     * 
     * @param width int
     */
    public void setWidth (int width)
    {
        this.getCell().setWidth(width);        
    }

    
    /**
     * 
     * @return CarouselCell
     */
    protected CarouselCell getCell ()
    {
        return this.cell;
    }
}
