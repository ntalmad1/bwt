package com.talmadge.bwt.core.client.ui.widget.screenmask;

import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;

/**
 * 
 *
 */
public interface ScreenMaskAppearance extends BwtWidgetAppearance
{
    /**
     * 
     * @param message String
     */
    void setText (String message);
    
    
    /**
     * 
     */
    void layout ();

}
