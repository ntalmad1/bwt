package com.talmadge.bwt.core.client.ui.util;

/**
 * 
 *
 */
public class BwtConsole
{
	/**
	 * Constructor
	 * 
	 */
	public BwtConsole ()
	{
		
	}
	
	
	/**
	 * 
	 * @param string String
	 */
	public void log (String message)
	{
		// GWT.log(message);
		this._log(message);
	}
	
	
	/**
	 * 
	 * @param message String
	 */
	protected native void _log (String message) /*-{
		
		$wnd.console.log(message);
		
	}-*/;
}
