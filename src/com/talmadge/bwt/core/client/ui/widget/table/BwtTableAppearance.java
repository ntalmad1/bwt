package com.talmadge.bwt.core.client.ui.widget.table;

import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;

/**
 * 
 *
 */
public interface BwtTableAppearance extends BwtWidgetContainerAppearance
{
    /**
     * 
     * @param bordered boolean
     */
    void setBordered (boolean bordered);
    
    /**
     * 
     * @param striped boolean
     */
    void setStriped (boolean striped);
}
