package com.talmadge.bwt.core.client.ui.widget.gallery.filmstrip;

import com.talmadge.bwt.core.client.ui.widget.composite.BwtComposite;
import com.talmadge.bwt.core.client.ui.widget.gallery.item.BwtGalleryItem;

/**
 * 
 *
 */
public class BwtFilmStrip extends BwtComposite
{
	/**
	 */
	private BwtFilmStripCell cell;
	

	
	/**
	 * Constructor
	 * 
	 */
	public BwtFilmStrip ()
	{
		super();
		
		this.cell = new BwtFilmStripCell();
		
		this.initWidget(this.cell);
	}
	
	
	
	/**
	 * 
	 * @param item BwtGalleryItem
	 */
	public void add (BwtGalleryItem item)
    {
	    this.getCell().add(item);
    }

	
	/**
	 * 
	 * @param viewerHeight int
	 */
    public void layout (int viewerHeight)
    {
        this.getCell().layout(viewerHeight);
    }


    /**
	 * 
	 * @return BwtFilmStripCell
	 */
	protected BwtFilmStripCell getCell ()
	{
		return this.cell;
	}
}
