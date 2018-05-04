package com.talmadge.bwt.installer.lib.resource.local;

import java.util.ArrayList;
import java.util.Arrays;

public class CssResource extends LocalResource
{
	/**
	 * Hidden Constructor
	 * 
	 */
	protected CssResource ()
	{
		super(ResourceType.CSS);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param src String
	 * @param dest String
	 * @param names String[]
	 */
	public CssResource (String src, String dest, String...names)
	{
		this();
		
		this.setSrc(src);
		this.setDest(dest);
		this.setNames(new ArrayList<String>(Arrays.asList(names))); 
	}
}
