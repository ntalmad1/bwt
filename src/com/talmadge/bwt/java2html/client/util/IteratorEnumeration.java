package com.talmadge.bwt.java2html.client.util;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * @author Markus Gebhard
 */
@SuppressWarnings("rawtypes")
public class IteratorEnumeration implements Enumeration
{
	/**
	 */
	private Iterator iterator;


	/**
	 * Constructor 
	 *
	 * @param iterator Iterator
	 */
	public IteratorEnumeration (Iterator iterator)
	{
		this.iterator = iterator;
	}

	
	/**
	 * 
	 * @return boolean
	 */
	public boolean hasMoreElements ()
	{
		return iterator.hasNext();
	}

	
	/**
	 * 
	 * @return Object
	 */
	public Object nextElement ()
	{
		return iterator.next();
	}
}
