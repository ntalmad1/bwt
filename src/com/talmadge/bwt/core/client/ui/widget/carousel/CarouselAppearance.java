package com.talmadge.bwt.core.client.ui.widget.carousel;

import java.util.List;

import com.talmadge.bwt.core.client.ui.widget.carousel.item.CarouselItem;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 *
 */
public interface CarouselAppearance extends BwtWidgetContainerAppearance
{
    /**
     * @param items List<CarouselItem>
     */
    void onItemAdded (List<CarouselItem> items);

    /**
     * @param index int
     */
    void setActive (int index);

    /**
     * @param id String
     */
    void setId (String id);
    
    /**
     * @param height int
     */
    void setHeight (int height);
}
