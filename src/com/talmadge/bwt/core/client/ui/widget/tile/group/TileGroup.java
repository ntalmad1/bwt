package com.talmadge.bwt.core.client.ui.widget.tile.group;

import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.tile.Tile;

/**
 * 
 * @author Noah
 *
 */
public class TileGroup extends BwtComposite
{
	/**
	 */
	private TileGroupCell cell;
	

	/**
	 * 
	 */
	public TileGroup ()
	{
		super();
		
		this.cell = new TileGroupCell();
		
		this.initWidget(this.cell);
	}
	
	
	/**
	 * 
	 * @param tile Tile
	 */
	public void add (Tile tile)
	{
		this.cell.add(tile);
	} 
	
	
	/**
	 * 
	 * @param tile Tile
	 * @return boolean true if the tile exists
	 */
	public boolean remove (Tile tile)
	{
		return this.cell.remove(tile);
	} 

}
