package com.talmadge.bwt.core.client.ui.widget.form.option;

import com.google.gwt.json.client.JSONValue;
import com.talmadge.bwt.core.client.json.HasJsonValue;
import com.talmadge.bwt.core.client.json.JsonUtils;

/**
 * 
 * @author Noah
 *
 * @param <T>
 */
public class Item<T> implements HasJsonValue
{
	/**
	 */
	private String name;
	
	/**
	 */
	private T value;
	
	
	/**
	 * Constructor
	 * 
	 * @param name String
	 * @param value T
	 */
	public Item (String name, T value)
	{
		this.setName(name);
		this.setValue(value);
	}

	
	/**
	 * 
	 * @return JSONValue
	 */
	public JSONValue asJsonValue ()
	{
		return JsonUtils.asJSONValue(this.getValue());
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getName ()
	{
		return this.name;
	}

	
	/**
	 * 
	 * @return T
	 */
	public T getValue ()
	{
		return this.value;
	}

	
	/**
	 * 
	 * @param name String
	 */
	public void setName (String name)
	{
		this.name = name;
	}

	
	/**
	 * 
	 * @param value T
	 */
	public void setValue (T value)
	{
		this.value = value;
	}
	
}
