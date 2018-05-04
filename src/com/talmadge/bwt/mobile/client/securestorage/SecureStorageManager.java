package com.talmadge.bwt.mobile.client.securestorage;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *
 */
public class SecureStorageManager 
{
	/**
	 */
	private static SecureStorageManager instance;
	
	
	/**
	 *  
	 * @return SecureStorageManager
	 */
	public static SecureStorageManager getInstance ()
	{
		if (instance == null)
		{
			instance = new SecureStorageManager();
		}
		
		return instance;
	}
	
	//------------------------------------------------------------
	
	
	/**
	 */
	private Map<String, SecureStorage> namespaces;
	
	
	
	/**
	 * Hidden Constructor 
	 */
	protected SecureStorageManager ()
	{
		this.namespaces = new HashMap<String, SecureStorage>();
	}


	/**
	 * 
	 * @param namespace String
	 * @return SecureStorage
	 */
	public SecureStorage get (String namespace) 
	{
		if (!this.namespaces.containsKey(namespace))
		{
			this.namespaces.put(namespace, new SecureStorage(namespace));
		}
		
		return this.namespaces.get(namespace);
	}
}
