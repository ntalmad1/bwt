package com.talmadge.bwt.core.client.ui;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.talmadge.bwt.core.client.ui.util.BwtConsole;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.container.simple.SimpleWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.screenmask.ScreenMask;

/**
 * 
 *
 */
public final class Bwt
{
	/**
	 */
	private static boolean isDebugMode;
	
	/**
	 */
	private static ScreenMask screenMask;
	
	/**
	 */
	public static BwtConsole console = new BwtConsole();
	
	
	/**
	 * 
	 * @param message String
	 */
	public static void debug (String message)
	{
		if (!Bwt.isDebugMode())
		{
			return;
		}
		
		Bwt.log("[DEBUG]: " + message);		
	}

	
	/**
	 */
	private static Map<String, BwtWidgetContainer> panelWrappers = new HashMap<String, BwtWidgetContainer>();
	
	
	/**
	 * 
	 */
	public static BwtWidgetContainer getContainerById (String id)
	{
		if (!panelWrappers.containsKey(id))
		{
			panelWrappers.put(id, new SimpleWidgetContainer(RootPanel.get(id)));
		}
		
		return panelWrappers.get(id);
	}


	/**
	 * 
	 * @return JsArray<JavaScriptObject>
	 */
	public static native JsArray<JavaScriptObject> getNativeArray () /*-{
        
        return [];
        
    }-*/;


	/**
	 * 
	 * @return BwtWidgetContainer
	 * @throws Exception 
	 */
    public static BwtWidgetContainer getRootContainer () throws Exception
	{
    	 return BwtWidgetContainer.wrap(RootPanel.get());
	}


	/**
	 * 
	 * @return int
	 */
	public static native int getTopZIndex () /*-{
		
		var maxZ = Math.max.apply(null, $wnd.$.map($wnd.$('body *'), function(e,n) {
      		if ($wnd.$(e).css('position') != 'static')
        	return parseInt($wnd.$(e).css('z-index')) || 1;
  		}));
		
		return maxZ;
		
	}-*/;

	
	
	/**
	 * 
	 * @retirn boolean
	 */
	public static boolean isDebugMode () 
	{
		return Bwt.isDebugMode;
	}
	
	
	/**
	 * 
	 * @param message int
	 */
	public static void log (int message)
	{
		Bwt.log(message + "");		
	}


	/**
     * 
     * @param message String
     */
    public static void log (String message)
    {
        Bwt.console.log(message);
    }


    /**
	 * 
	 * @param exception Throwable
	 */
	public static void log (Throwable exception)
    {
	    Bwt.log(exception.getMessage(), exception);
    }
	
	
	/**
     * 
     * @param message String
     * @param exception Exception
     */
    public static void log (String message, Throwable exception)
    {
    //	GWT.log("HERE", new Throwable("HERE"));
    	
    //	GWT.log("HERE");
    	
    	GWT.log(message, exception);
    	
        
    	// Window.alert(GWT.isProdMode() + "");
        
        if (exception.getCause() != null)
        {
            Bwt.log("Caused by:", exception.getCause());
        }
    }


    /**
     * 
     * @param url String
     */
    public static void openNewTab (String url)
    {
        Window.open(url, "_blank", "");        
    }


    /**
	 * 
	 */
	public static void maskScreen () 
	{
		Bwt.maskScreen("");
	}
	
	
	/**
	 * 
	 * @param message String
	 */
	public static void maskScreen (String message) 
	{ 
		if (Bwt.screenMask == null)
		{
		    Bwt.screenMask = new ScreenMask();
		}
		
		Bwt.screenMask.show(message);
	}
	
	
	/**
	 * 
	 * @return boolean isDebugMode
	 */
	public static void setDebugMode (boolean isDebugMode)
	{
		Bwt.isDebugMode = isDebugMode;
	}
	
	
	/**
	 * 
	 */
	public static void unmaskScreen ()
	{
	    if (Bwt.screenMask != null)
	    {	    
	        Bwt.screenMask.hide();
	    }
	}

	
	/**
     * 
     */
    public static native void scrollToTop () /*-{
    
    	$wnd.$($wnd).scrollTo(0);
    	
    }-*/;


    /**
	 * Hidden Constructor
	 */
	private Bwt ()
	{
		
	}
}
