package com.talmadge.bwt.core.client.ui.widget.form.option.select;

import com.google.gwt.core.client.GWT;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;

/**
 * 
 * @author Noah
 *
 * @param <T>
 */
public class SelectOption<T> extends BwtWidget
{
	/**
	 */
	private String name;
	
	/**
	 */
	private T value;
	
	/**
	 * Hidden Constructor
	 * 
	 * @param appearance SelectOptionAppearance
	 */
	protected SelectOption (SelectOptionAppearance appearance)
	{
		super(appearance);
	}
	
	/**
	 * Constructor
	 * 
	 */
	public SelectOption ()
	{
		this((SelectOptionAppearance) GWT.create(DefaultSelectOptionAppearance.class));
	}
	
	/**
	 * Constructor
	 * 
	 * @param name String
	 * @param value T
	 */
	public SelectOption (String name, T value)
	{
		this();
		this.setName(name);
		this.setValue(value);
	}
	
	
	/**
	 * 
	 * @return SelectOptionAppearance
	 */
	public SelectOptionAppearance getAppearance ()
	{
		return (SelectOptionAppearance) super.getAppearance();
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
		this.getAppearance().setLabel(name);
		
		this.name = name;
	}
	
	/**
	 * 
	 * @param selected boolean
	 */
	public void setSelected (boolean selected)
	{
		this.getAppearance().setSelected(selected);
		
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
