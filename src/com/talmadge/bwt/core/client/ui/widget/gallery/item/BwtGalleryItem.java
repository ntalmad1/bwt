package com.talmadge.bwt.core.client.ui.widget.gallery.item;

import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;

/**
 *
 */
public class BwtGalleryItem
{
    /**
     */
    private String description;
    
    /**
     */
    private BwtImage img;

    /**
     */
    private String thumbUrl;
    
    /**
     */
    private String title;
    
    /**
     */
    private String url;

    
    
    /**
     * Constructor
     * 
     */
    public BwtGalleryItem ()
    {
        
    }
    
    
    /**
     * Constructor
     * 
     * @param url String
     * @param thumbUrl String
     */
    public BwtGalleryItem (String url, String thumbUrl)
    {
        this.url = url;
        this.thumbUrl = thumbUrl;
    }


    /**
     * 
     * @return String
     */
    public String getDescription ()
    {
        return this.description;
    }

    
    /**
     * 
     * @return BwtImage
     */
    public BwtImage getImg ()
    {
        return this.img;
    }
    

    /**
     * 
     * @return String
     */
    public String getThumbUrl ()
    {
        return this.thumbUrl;
    }

    
    /**
     * @return String
     */
    public String getTitle ()
    {
        return this.title;
    }

    
    /**
     * 
     * @return String
     */
    public String getUrl ()
    {
        return this.url;
    }


    /**
     * 
     * @param description String
     */
    public void setDescription (String description)
    {
        this.description = description;
    }

    
    /**
     * 
     * @param img BwtImage
     */
    public void setImg (BwtImage img)
    {
        this.img = img;        
    }


    /**
     * 
     * @param thumbUrl String
     */
    public void setThumbUrl (String thumbUrl)
    {
        this.thumbUrl = thumbUrl;
    }

    
    /**
     * 
     * @param title String
     */
    public void setTitle (String title)
    {
        this.title = title;
    }

    
    /**
     * 
     * @param url String
     */
    public void setUrl (String url)
    {
        this.url = url;
    }
}
