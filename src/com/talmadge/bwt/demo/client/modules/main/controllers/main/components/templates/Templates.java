package com.talmadge.bwt.demo.client.modules.main.controllers.main.components.templates;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * 
 * @author Noah
 *
 */
public interface Templates extends ClientBundle 
{
	/**
	 */
	Templates INSTANCE = GWT.create(Templates.class);
	
	/**
	 * 
	 * @return TextResource
	 */
	@Source("html/masterHead.html")
	TextResource masterHead ();
}
