package com.talmadge.bwt.core.client.config.javascriptobject;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *
 */
public class JavaScriptObjectParameter
{
	/**
	 */
	private JavaScriptObject value;
	
	
	/**
	 * Hidden Constructor
	 * 
	 */
	protected JavaScriptObjectParameter ()
	{
		
	}


	/**
	 * Constructor
	 * 
	 * @param value JavaScriptObject
	 */
	public JavaScriptObjectParameter (JavaScriptObject value)
	{
		this.value = value;
	}
	
	
	/**
	 * 
	 * @return JavaScriptObject
	 */
	public JavaScriptObject getValue ()
	{
		return this.value;
	}
	
	
	/**
	 * 
	 * @param value JavaScriptObject
	 */
	protected void setValue (JavaScriptObject value)
	{
		this.value = value;
	}
}
