package com.talmadge.bwt.core.client.ui.widget.carousel;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.widget.carousel.item.CarouselItem;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;

/**
 * 
 *
 */
public class CarouselCell extends BwtWidgetContainer
{
    /**
     */
    private List<CarouselItem> items;
    
    
    
    /**
     * Constructor
     * 
     */
    public CarouselCell ()
    {
        this((CarouselAppearance) GWT.create(DefaultCarouselAppearance.class));
    }
    
    
    /**
     * Constructor
     * 
     * @param appearance NavGroupAppearance
     */
    protected CarouselCell (CarouselAppearance appearance)
    {
        super(appearance);
        
        this.items = new ArrayList<CarouselItem>();
        
        this.getAppearance().setId(this.getId());
    }
    
    
    /**
     * 
     * @param item CarouselItem
     */
    public void add (CarouselItem item)
    {
        this.items.add(item);
        this.getAppearance().onItemAdded(this.items);        
    }


    /**
     * 
     * @param index int
     */
    public void setActive (int index)
    {
        this.getAppearance().setActive(index);        
    }
    
    
    
    /**
     * 
     * @param height int
     */
    public void setHeight (int height)
    {
        super.setHeight(height);
        this.getAppearance().setHeight(height);
    }


    /**
     * 
     * @return CarouselAppearance
     */
    protected CarouselAppearance  getAppearance ()
    {
        return (CarouselAppearance) super.getAppearance();
    }
    
    
    /**
     * 
     */
    protected void onAttach ()
    {
        super.onAttach();
        
        this.setActive(0);
    }
}
