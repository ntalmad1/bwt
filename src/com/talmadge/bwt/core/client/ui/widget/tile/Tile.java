package com.talmadge.bwt.core.client.ui.widget.tile;

import com.google.gwt.core.shared.GWT;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.IconAlign;
import com.talmadge.bwt.core.client.ui.glyphicon.Glyphicon;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * @author Noah
 *
 */
public class Tile extends BwtWidget
{
    /**
     * Constructor
     *
     */
    public Tile ()
    {
        this((DefaultTileAppearance) GWT.create(DefaultTileAppearance.class));
    }


    /**
	 * 
	 * @param text String
	 */
	public Tile (String text)
	{
		this();
		
		this.setText(text);
	}


	/**
     * Constructor
     * 
     * @param icon Glyphicons
     * @param text String
     */
    public Tile (Glyphicon icon, String text)
    {
        this(text);

        this.setIcon(icon);
    }

    
    /**
	 * Constructor
	 * 
	 * @param appearance DefaultTileAppearance
	 */
	protected Tile (DefaultTileAppearance appearance)
	{
		super(appearance);
		
		this.bind();
	}


	/**
     * 
     * @param icon Glyphicon
     */
    public void setIcon (Glyphicon icon)
    {
        this.getAppearance().setIcon(icon);

    }

    
    /**
     * 
     * @param iconAlign IconAlign
     */
    public void setIconAlign (IconAlign iconAlign)
	{
		this.getAppearance().setIconAlign(iconAlign);		
	}


	/**
     *
     * @param text String
     */
    public void setText (String text)
    {
        this.getAppearance().setText(text);
    }


    /**
	 *
	 * @return TileAppearance
	 */
	protected TileAppearance getAppearance ()
	{
	    return (TileAppearance) super.getAppearance();
	}


	/**
     *
     */
    protected void bind ()
    {

    }
}
