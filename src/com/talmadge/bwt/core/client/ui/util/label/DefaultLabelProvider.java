package com.talmadge.bwt.core.client.ui.util.label;

/**
 * 
 */
public class DefaultLabelProvider implements LabelProvider
{
	/**
	 */
	private String label;
	
	
	/**
	 * Constructor
	 *  
	 * @param label String
	 */
	public DefaultLabelProvider (String label)
	{
		this.setLabel(label);
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String getLabel ()
	{
		return this.label;
	}
	
	
	/**
	 * 
	 * @param label String
	 */
	public void setLabel (String label)
	{
		this.label = label;
	}
	
	
	/**
	 * 
	 * @return String
	 */
	public String toString ()
	{
		return this.label;
	}
}
