package com.talmadge.bwt.demo.client.modules.main.controllers.tooltips.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * 
 *
 */
public interface TooltipsResources extends ClientBundle
{
	/**
	 */
	TooltipsResources INSTANCE = GWT.create(TooltipsResources.class);
	
	/**
	 * 
	 * @return ImageResource
	 */
	@Source("images/watermellonBoy.jpg")
	ImageResource watermellonBoy ();
}
