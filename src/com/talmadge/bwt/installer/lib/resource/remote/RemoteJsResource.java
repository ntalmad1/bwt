package com.talmadge.bwt.installer.lib.resource.remote;

/**
 * 
 *
 */
public class RemoteJsResource extends RemoteResource
{
	/**
	 * Hidden Constructor
	 * 
	 */
	protected RemoteJsResource ()
	{
		super(ResourceType.REMOTE_JS);
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param src String
	 */
	public RemoteJsResource (String src)
	{
		this();
		
		this.setSrc(src);
	}
}
