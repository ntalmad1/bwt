package com.talmadge.bwt.mobile.client.securestorage;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * 
 *
 */
public class SecureStorage 
{
	/**
	 */
	private JavaScriptObject storage;
	
	
	/**
	 * 
	 * @param namespace String
	 */
	public SecureStorage (String namespace) 
	{
		this.storage = this._createStorage(namespace);
	}
	
	
	/**
	 * 
	 */
	public void clear ()
	{
		this._clear(this.storage);
	}


	/**
	 * 
	 * @param key String
	 * @return String
	 */
	public String get (String key)
	{
		return this._get(this.storage, key);
	}
	
	
	
	/**
	 * 
	 * @return List<String>
	 */
	public List<String> keys ()
	{
		String[] nativeKeys = this._keys(this.storage);
		return Arrays.asList(nativeKeys);
	}
	
	
	/**
	 * 
	 * @param key String
	 * @param value String
	 */
	public void put (String key, String value)
	{
		this._put(this.storage, key, value);
	}
	
	
	/**
	 * 
	 * @param key String
	 * @return String
	 */
	public void remove (String key)
	{
		this._remove(this.storage, key);
	}
	
	
	//-------------------------------------------------------------------
	
	
	/**
	 * 
	 */
	private native void _clear (JavaScriptObject storage) /*-{
		
		storage.clear(
    	    function () { 
    	    		$wnd.console.log('Cleared'); 
    		},
    	    function (error) { 
    	    		$wnd.console.log('Error: ' + error); 
    	    });
	    	    
	}-*/;


	/**
	 * 
	 * @param namespace String
	 * @return JavaScriptObject
	 */
	private native JavaScriptObject _createStorage (String namespace) /*-{
		
		return new $wnd.cordova.plugins.SecureStorage(
    	    function () { 
    	    	// $wnd.console.log('Success')
	    	},
    	    function (error) { 
    	    	$wnd.console.log('Error: ' + error); 
	    	},
    	    namespace);
		
	}-*/;
	
	
	/**
	 * 
	 * @param storage JavaScriptObject
	 * @param key String
	 * @return String
	 */
	private native String _get (JavaScriptObject storage, String key) /*-{
		
		var returnValue;
	
		storage.get(
    	    function (value) { 
    	    	returnValue = value;
    	    	
    	    	// $wnd.console.log('Success, got ' + value);
	    	},
    	    function (error) { 
    	    	$wnd.console.log('Error: ' + error); 
    	    },
    	    key);
    	
    	return returnValue;
	    	    
	}-*/;

	
	/**
	 * 
	 * @param storage JavaScriptObject
	 */
	private native String[] _keys (JavaScriptObject storage) /*-{
		
		var returnValue;
		
		storage.keys(
    	    function (keys) { 
    	    	returnValue = keys;
    	    	
    	    	// $wnd.console.log('Got keys ' + keys.join(', ')); 
    	    },
    	    function (error) { 
    	    	$wnd.console.log('Error: ' + error); 
    	    });
    	    
    	 
    	 return returnValue;
		
	}-*/;


	/**
	 * 
	 * @param storage JavaScriptObject
	 * @param key String
	 * @param value String
	 */
	private native void _put (JavaScriptObject storage, String key, String value) /*-{
		
		storage.set(
    	    function (key) { 
    	    	// $wnd.console.log('Set ' + key); 
	    	},
    	    function (error) { 
    	    	$wnd.console.log('Error: ' + error); 
	    	},
    	    key, value);
		
	}-*/;


	//-------------------------------------------------------------------
	
	
	/**
	 * 
	 * @param storage JavaScriptObject
	 * @param key String
	 */
	private native void _remove (JavaScriptObject storage, String key) /*-{
	
		storage.remove(
    	    function (key) { 
    	    	// $wnd.console.log('Removed: ' + key); 
    	    },
    	    function (error) { 
    	    	$wnd.console.log('Error: ' + error); 
    	    },
    	    key);
    	    
	}-*/;

}
