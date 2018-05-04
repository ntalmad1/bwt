package com.talmadge.bwt.core.client.ui.util;

import com.google.gwt.event.dom.client.KeyCodes;

/**
 * 
 *
 */
final public class BwtEventUtils
{
	/**
	 * 
	 * @param keyCode int
	 * @return booelan
	 */
	public static boolean isNavKeyPress (int keyCode)
	{
		return (keyCode >= 33 && keyCode <= 40) 
			 || keyCode == KeyCodes.KEY_ESCAPE 
			 || keyCode == KeyCodes.KEY_ENTER 
			 || keyCode == KeyCodes.KEY_TAB;
	}

	
	/**
	 * 
	 * @param keyCode int
	 * @return boolean
	 */
	public static boolean isSpecialKey (int keyCode)
	{
		return BwtEventUtils.isNavKeyPress(keyCode) 
			|| keyCode == KeyCodes.KEY_BACKSPACE 
			|| keyCode == KeyCodes.KEY_CTRL 
			|| keyCode == KeyCodes.KEY_SHIFT 
			|| keyCode == KeyCodes.KEY_ALT 
			|| (keyCode >= 19 && keyCode <= 20) 
			|| (keyCode == 46);
	}

	
	/**
	 * Hidden Constructor
	 * 
	 */
	private BwtEventUtils ()
	{
		
	}
}
