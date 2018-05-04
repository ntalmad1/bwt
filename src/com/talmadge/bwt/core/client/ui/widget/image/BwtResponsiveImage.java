package com.talmadge.bwt.core.client.ui.widget.image;

/**
 * 
 *
 */
public class BwtResponsiveImage extends BwtImage
{
	/**
	 * Constructor
	 *  
	 * @param url String
	 */
	public BwtResponsiveImage (String url)
	{
		super(url);
		
		this.setResponsive(true);		
	}
}
