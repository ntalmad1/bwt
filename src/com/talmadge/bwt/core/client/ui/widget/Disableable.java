package com.talmadge.bwt.core.client.ui.widget;

/**
 * 
 * @author Noah
 *
 */
public interface Disableable
{
	/**
	 * 
	 */
	void disable ();
	
	/**
	 * 
	 */
	void enable ();
	
	/**
	 * 
	 * @param isDisabled boolean
	 */
	void setDisabled (boolean isDisabled);
}
