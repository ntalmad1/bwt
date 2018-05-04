package com.talmadge.bwt.mobile.client.app;

import com.talmadge.bwt.core.client.app.BwtApplication;

/**
 * 
 *
 */
public abstract class BwtMobileApp extends BwtApplication
{
	
	private boolean isModuleReady;
	private boolean isDeviceReady;


	/**
     * Constructor
     * 
     */
    public BwtMobileApp ()
    {
    	super();
    	
    	this.exportDeviceReadyListener(this);
    }	
	
	
	
	/**
     * 
     */
    @Override
    public void onModuleLoad ()
    {
    	this.isModuleReady = true;
    	this.checkReady();
    }

    
    /**
     * 
     */
    private void checkReady () 
    {
    	if (this.isModuleReady && this.isDeviceReady)
    	{
	    	try
	        {
	            this.run();
	            
	        }
	        catch (Exception e)
	        {
	           this.onException(e);
	        }
    	}
	}



	/**
     * 
     */
    private void _onDeviceReady ()
    {
    	this.isDeviceReady = true;
    	this.checkReady();
    }
    
    
    /**
     * 
     */
	private native void exportDeviceReadyListener (BwtMobileApp app) /*-{
		
		$doc.addEventListener("deviceready", function(){
			app.@com.talmadge.bwt.mobile.client.app.BwtMobileApp::_onDeviceReady()();
		}, false);
		
	}-*/;

}