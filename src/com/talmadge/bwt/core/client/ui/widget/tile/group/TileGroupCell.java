package com.talmadge.bwt.core.client.ui.widget.tile.group;

import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.tile.Tile;

/**
 * @author Noah
 *
 */
class TileGroupCell extends BwtWidgetContainer
{
    /**
     * Constructor
     *
     */
    TileGroupCell ()
    {
        this(new DefaultTileGroupAppearance());
    }

    
    /**
     * Constructor 
     * 
     * @param appearance TileGroupAppearance
     */
    protected TileGroupCell (TileGroupAppearance appearance)
    {
    	super(appearance);
    	
    	this.bind();
    }

    

    /**
     * 
     * @param tile Tile
     */
    public void add (Tile tile)
    {
        super.add(tile);
    }


    /**
     *
     * @return TileGroupAppearance
     */
    public TileGroupAppearance getAppearance ()
    {
        return (TileGroupAppearance) super.getAppearance();
    }
    
    
    /**
     * 
     * @param tile Tile
     * @return boolean
     */
    public boolean removeTile (Tile tile)
    {
    	return super.remove(tile);
    }

    /**
     *
     */
    protected void bind ()
    {

    }
}
