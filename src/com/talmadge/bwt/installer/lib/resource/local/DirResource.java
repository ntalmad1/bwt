package com.talmadge.bwt.installer.lib.resource.local;

public class DirResource extends LocalResource
{
	/**
	 * Hidden Constructor
	 * 
	 */
	protected DirResource ()
	{
		super(ResourceType.DIR);
	}
	
	/**
	 * 
	 * @param src String
	 * @param dest String
	 */
	public DirResource (String src, String dest)
	{
		this();
		
		this.setSrc(src);
		this.setDest(dest);
	}
}
