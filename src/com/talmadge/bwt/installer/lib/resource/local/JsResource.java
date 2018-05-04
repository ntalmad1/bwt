package com.talmadge.bwt.installer.lib.resource.local;

import java.util.ArrayList;
import java.util.Arrays;

public class JsResource extends LocalResource
{
	/**
	 * Hidden Constructor
	 * 
	 */
	protected JsResource ()
	{
		super(ResourceType.JS);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param src String
	 * @param dest String
	 * @param names String[]
	 */
	public JsResource (String src, String dest, String...names)
	{
		this();
		
		this.setSrc(src);
		this.setDest(dest);
		this.setNames(new ArrayList<String>(Arrays.asList(names))); 
	}
}
