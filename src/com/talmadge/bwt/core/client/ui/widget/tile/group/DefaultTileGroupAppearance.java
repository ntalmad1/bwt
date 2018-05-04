package com.talmadge.bwt.core.client.ui.widget.tile.group;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.tile.Tile;

/**
 * @author Noah
 *
 */
public class DefaultTileGroupAppearance extends DefaultBwtWidgetContainerAppearance implements TileGroupAppearance
{
    /**
     * Constructor
     *
     */
    public DefaultTileGroupAppearance ()
    {
        super(Document.get().createULElement());
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
	 * @param tile Tile
	 */
	public void remove (Tile tile)
	{
		super.remove(tile);		
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("bwt-tile-group");
	}
}
