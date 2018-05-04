package com.talmadge.bwt.core.client.ui.widget;

/**
 * 
 *
 */
public class BwtDimension
{
    /**
     */
    private int height;
    
    /**
     */
    private int width;

    
    /**
     * 
     * @param width int
     * @param height int
     */
    public BwtDimension (int width, int height)
    {
        this.setHeight(height);
        this.setWidth(width);
    }
    
    
    /**
     * 
     * @param compareTo BwtDimension
     * @return boolean
     */
    public boolean equals (BwtDimension compareTo)
    {
        return ((this.getWidth() == compareTo.getWidth()) && (this.getHeight() == compareTo.getHeight()));
    }


    /**
     * @return the height
     */
    public int getHeight ()
    {
        return height;
    }

    /**
     * @return the width
     */
    public int getWidth ()
    {
        return width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight (int height)
    {
        this.height = height;
    }

    /**
     * @param width the width to set
     */
    public void setWidth (int width)
    {
        this.width = width;
    }
    
}
