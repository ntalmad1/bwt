package com.talmadge.bwt.demo.client.modules.main.controllers.components.examples.glyphicons.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * 
 * @author Noah
 *
 */
public interface GlyphiconsResources extends ClientBundle
{
	/**
	 */
	GlyphiconsResources INSTANCE = GWT.create(GlyphiconsResources.class);
	
	
	/**
	 * 
	 * @return TextResource
	 */
	@Source("glyphiconsBlurb.html")
	TextResource blurb ();
}
