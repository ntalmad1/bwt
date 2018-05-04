package com.talmadge.bwt.installer.lib.resource.local;

import java.util.List;

import com.talmadge.bwt.installer.lib.resource.Resource;

/**
 * 
 *
 */
public abstract class LocalResource extends Resource
{
	/**
	 */
	private String dest;
	
	/**
	 */
	private boolean isIncludeOnly;

	/**
	 */
	private List<String> names;
	
	
	
	/**
	 * Hidden Constructor
	 * 
	 */
	protected LocalResource (ResourceType type)
	{
		super(type); 
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getDest ()
	{
		return this.dest;
	}
	
	
	/**
	 * 
	 * @return List<String>
	 */
	public List<String> getNames ()
	{
		return this.names;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean isIncludeOnly ()
	{
		return this.isIncludeOnly;
	}
	

	/**
	 * 
	 * @param dest String
	 */
	public void setDest (String dest)
	{
		this.dest = dest;
	}

	
	/**
	 * 
	 * @param names List<String> 
	 */
	public void setNames (List<String> names)
	{
		this.names = names;
	}

	
	/**
	 * 
	 * @param includeOnly boolean
	 */
	public void setIncludeOnly (boolean includeOnly)
	{
		this.isIncludeOnly = includeOnly;
	}
}
