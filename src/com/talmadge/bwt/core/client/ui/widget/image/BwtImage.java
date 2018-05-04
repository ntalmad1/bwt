package com.talmadge.bwt.core.client.ui.widget.image;

import com.google.gwt.dom.client.Style.BorderStyle;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.Image;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;

/**
 * 
 * @author Noah
 *
 */
public class BwtImage extends Image
{
	/**
	 * 
	 * @param image Image
	 * @param isCircle boolean
	 */
	public static void setCircle (Image image, boolean isCircle)
	{
		BwtElementUtils.toggleCssName(image.getElement(), "img-circle", isCircle);
	}
	
	
	/**
	 * 
	 * @param image Image
	 * @param isResponsive boolean
	 */
	public static void setResponsive (Image image, boolean isResponsive)
	{
		BwtElementUtils.toggleCssName(image.getElement(), "img-responsive", isResponsive);
	}


	/**
	 * 
	 * @param image Image
	 * @param isRounded boolean
	 */
	public static void setRounded (Image image, boolean isRounded)
	{
		BwtElementUtils.toggleCssName(image.getElement(), "img-rounded", isRounded);
	}
	
	
	/**
	 * 
	 * @param image Image
	 * @param isThumbnail boolean
	 */
	public static void setThumbnail (Image image, boolean isThumbnail)
	{
		BwtElementUtils.toggleCssName(image.getElement(), "img-thumbnail", isThumbnail);
	}

	
	/**
	 */
    private boolean loaded;
	
	
	/**
	 * Constructor
	 *  
	 * @param url String
	 */
	public BwtImage (String url)
	{
		super(url);
		
		this.bind();
	}
	
	
	/**
	 * 
	 * @param image ImageResource
	 */
	public BwtImage (ImageResource image)
    {
	    this.setResource(image);
	    
	    this.bind();
    }


    /**
	 * 
	 * @return boolean
	 */
	public boolean isCircle ()
	{
		return this.getElement().hasClassName("img-circle");
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isLoaded ()
	{
	    return this.loaded;
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isResponsive ()
	{
		return this.getElement().hasClassName("img-responsive");
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isRounded ()
	{
		return this.getElement().hasClassName("img-rounded");
	}
	
	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isThumbnail ()
	{
		return this.getElement().hasClassName("img-thumbnail");
	}
	
	
	/**
	 * 
	 * @param color String
	 * @param style BorderStyle
	 * @param width int
	 * @param unit Unit
	 * @return BwtImage
	 */
	public BwtImage setBorder (String color, BorderStyle style, int width, Unit unit)
	{
		this.getElement().getStyle().setBorderColor(color);
		this.getElement().getStyle().setBorderStyle(style);
		this.getElement().getStyle().setBorderWidth(width, unit);
		
		return this;
	}
	
	
	/**
	 * 
	 * @param isCentered boolean
	 */
	public void setCenterBlock (boolean isCentered)
	{
	    BwtElementUtils.toggleCssName(this.getElement(), "center-block", isCentered);
	}
	
	
	/**
	 * 
	 * @param isCircle boolean
	 * @return BwtImage
	 */
	public BwtImage setCircle (boolean isCircle)
	{
		BwtImage.setCircle(this, isCircle);
		
		return this;
	}
	
	
	/**
	 * 
	 * @param isResponsive boolean
	 * @return BwtImage
	 */
	public BwtImage setResponsive (boolean isResponsive)
	{
		BwtImage.setResponsive(this, isResponsive);
		
		return this;
	}


	/**
	 * 
	 * @param isRounded boolean
	 * @return BwtImage
	 */
	public BwtImage setRounded (boolean isRounded)
	{
		BwtImage.setRounded(this, isRounded);
		
		return this;
	}
	
	
	/**
	 * 
	 * @param isThumbnail boolean
	 * @return BwtImage
	 */
	public BwtImage setThumbnail (boolean isThumbnail)
	{
		BwtImage.setThumbnail(this, isThumbnail);
		
		return this;
	}

	
	/**
	 * 
	 */
    protected void bind ()
    {
        this.addLoadHandler(new LoadHandler()
        {
            public void onLoad (LoadEvent event)
            {
                BwtImage.this._onImageLoad(event);
            }
        });        
    }

    
    /**
     * 
     * @param event LoadEvent
     */
    protected void onImageLoad (LoadEvent event)
    {
       
    }
    

    /**
     * 
     * @param event LoadEvent
     */
    private void _onImageLoad (LoadEvent event)
    {
        this.loaded = true;
        this.onImageLoad(event);
    }	
}
