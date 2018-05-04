package com.talmadge.bwt.core.client.ui.widget.tile.group;

import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.tile.Tile;

/**
 * @author Noah
 *
 */
public interface TileGroupAppearance extends BwtWidgetContainerAppearance
{

    /**
     * @param tile Tile tile
     */
    void add (Tile tile);
    
    
    /**
     * @param tile Tile tile
     */
    void remove (Tile tile);

}
