package com.talmadge.bwt.java2html.client.util.proxy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Noah
 *
 */
public class StringTokenizerProxy
{
	/**
	 */
	private int pointer = 0;

	/**
	 */
	private List<String> tokens;
	
	
	
	/**
	 * Constructor 
	 *
	 * @param string String
	 * @param delimiters String
	 * @param includeDelimiters boolean
	 */
	public StringTokenizerProxy (String string, String delimiters, boolean includeDelimiters)
	{
		this.tokens = new ArrayList<String>();
		
		int last = 0;	
		
		int i;
		
		for (i = 0; i < string.length(); ++i)
		{
			String current = string.substring(i, i + 1);
			
			if (delimiters.contains(current))
			{
				String token = string.substring(last, i);
				
				tokens.add(token);
				
				if (includeDelimiters)
				{
					tokens.add(current);
				}
				
				last = i + 1;
			}
		}
		
		if (last < i)
		{
			tokens.add(string.substring(last, i));
		}
	}


	/**
	 * 
	 * @return boolean
	 */
	public boolean hasMoreTokens ()
	{
		return this.pointer < this.tokens.size();
	}

	
	/**
	 * 
	 * @return String
	 */
	public String nextToken ()
	{
		String token = this.tokens.get(this.pointer);
		
		this.pointer++;
		
		return token;
	}

}
