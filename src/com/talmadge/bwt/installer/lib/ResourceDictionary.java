package com.talmadge.bwt.installer.lib;

import java.util.ArrayList;
import java.util.List;

import com.talmadge.bwt.installer.lib.resource.Resource;
import com.talmadge.bwt.installer.lib.resource.local.LocalResource;

public class ResourceDictionary
{
	/**
	 */
	private List<Resource> resources = new ArrayList<Resource>();

	
	/**
	 * Constructor
	 * 
	 */
	public ResourceDictionary ()
	{
		
	}
	
	
	/**
	 * 
	 * @return List<Resource>
	 */
	public List<Resource> getResources ()
	{
		return this.resources;
	}

	
	/**
	 * 
	 * @param resource Resource
	 */
	public void add (Resource resource)
	{
		this.getResources().add(resource);
	}
	
	
	/**
	 *  
	 * @param resource LocalResource
	 */
	public void addIncludeOnly (LocalResource resource)
	{
		resource.setIncludeOnly(true);
		this.add(resource);			
	}

}
