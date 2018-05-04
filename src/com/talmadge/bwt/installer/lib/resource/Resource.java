package com.talmadge.bwt.installer.lib.resource;

/**
 * 
 *
 */
public abstract class Resource
{
	/**
	 */
	public enum ResourceType {
		
		/**
		 */
		CSS,
		
		/**
		 */
		DIR,
		
		/**
		 */
		JS,
		
		/**
		 */
		REMOTE_CSS,
		
		/**
		 */
		REMOTE_JS;
	}
	

	
	/**
	 */
	private ResourceType type;
	/**
	 */
	private String src;
	
	
	
	/**
	 * Hidden Constructor
	 * 
	 */
	protected Resource (ResourceType type)
	{
		this.type = type;
	}
	
	
	/**
	 * 
	 * @return ResourceType
	 */
	public ResourceType getType ()
	{
		return this.type;
	}


	/**
	 * 
	 * @return String
	 */
	public String getSrc ()
	{
		return this.src;
	}


	/**
	 * 
	 * @param src String
	 */
	public void setSrc (String src)
	{
		this.src = src;
	}
}
