package com.talmadge.bwt.core.client.app;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.app.endpoint.EndpointProvider;
import com.talmadge.bwt.core.client.app.router.Route;
import com.talmadge.bwt.core.client.app.router.Router;
import com.talmadge.bwt.core.client.app.router.Router.MatchMethod;
import com.talmadge.bwt.core.client.app.session.BwtSession;
import com.talmadge.bwt.core.client.config.ini.Config;
import com.talmadge.bwt.core.client.config.ini.IniConfig;
import com.talmadge.bwt.core.client.history.BwtHistory;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeEvent;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeHandler;
import com.talmadge.bwt.core.client.ui.Bwt;

/**
 * 
 *
 */
public abstract class BwtApplication implements EntryPoint
{
	/**
	 * 
	 * @return String
	 */
	public static String getAppUrl ()
	{
	    String appUrl = BwtApplication._getAppUrl();
	    if (appUrl == null || appUrl.isEmpty())
	    {
	    	return "/";
	    }
	    else
	    {
	    	return appUrl;
	    }
	}


	/**
	 * 
	 * @return String
	 */
	private native static String _getAppUrl () /*-{
	    return $wnd.appUrl;
	}-*/;


	/**
     */
    private Config config;
    
    /**
     */
    private Route _404Route;

    /**
	 */
	private Router router;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public BwtApplication ()
	{
	    BwtHistory.init(getAppUrl());
	    BwtHistory.getInstance().addHistoryStateChangeHandler(new HistoryStateChangeHandler()
	    {
            public void onHistoryStateChange (HistoryStateChangeEvent event)
            {
                BwtApplication.this.onHistoryStateChange(event);
            }
	    });
	    
	    this.router = new Router(getAppUrl());	   
	    this.config = new IniConfig();
	    
	    try
	    {
	    	this.setup();
	    }
	    catch (Exception e)
	    {
	    	this.onException(e);
	    }
	}
	
	
	/**
	 * 
	 * @param matchMethod MatchMethod
	 * @param path String
	 * @param endpointProvider EndpointProvider
	 * @return Route
	 */
	public Route addRoute (MatchMethod matchMethod, String path, EndpointProvider endpointProvider)
	{
		return this.router.add(matchMethod, path, endpointProvider);
	}
	
	
	/**
     * 
     * @return Config
     */
    public Config getConfig ()
    {
        return this.config;
    }


    //	/**
	//	 * 
	//	 * @param e Exception
	//	 */
	//	public void handleException (Exception e)
	//	{
	//		if (e instanceof JsonRequestException)
	//		{
	//			Window.alert(((JsonRequestException) e).getRawResponseText());
	//		}
	//		else
	//		{
	//			Window.alert(e.getMessage());
	//		}
	//	}
		
	
    /**
	 * 
	 * @return Route
	 */
	public Route get404Route ()
	{
		return this._404Route;
	}


	/**
	 * 
	 * @return BwtHistory
	 */
	public BwtHistory getHistory ()
	{
		return BwtHistory.getInstance();
	}


	/**
	 * 
	 * @return Router
	 */
	public Router getRouter ()
	{
		return this.router;
	}
	
	
//	/**
//	 * 
//	 * @param e Exception
//	 */
//	public void handleException (Exception e)
//	{
//		if (e instanceof JsonRequestException)
//		{
//			Window.alert(((JsonRequestException) e).getRawResponseText());
//		}
//		else
//		{
//			Window.alert(e.getMessage());
//		}
//	}
	
    
    /**
     * 
     */
    @Override
    public void onModuleLoad ()
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
    

	/**
	 * 
	 * @throws ApplicationException e
	 */
	public void run () throws ApplicationException
	{
		try
		{
			String path = Window.Location.getHref();
			this.routePath(path);
		}
		catch (Exception e)
		{
			throw new ApplicationException(e);
		}
        	
	}

	
	/**
	 * 
	 * @return BwtSession
	 */
	public BwtSession session ()
	{
		return BwtSession.getInstance();
	}

	
	/**
	 * 
	 * @param _404Endpoint EndpointProvider
	 */
	public void set404EndpointProvider (EndpointProvider _404Endpoint)
	{
		this._404Route = new Route(_404Endpoint);
	}

	
	/**
	 * 
	 * @param router Router
	 */
	public void setRouter (Router router)
	{
		this.router = router;
	}

	   
	//	/**
	//	 * 
	//	 * @param e Exception
	//	 */
	//	public void handleException (Exception e)
	//	{
	//		if (e instanceof JsonRequestException)
	//		{
	//			Window.alert(((JsonRequestException) e).getRawResponseText());
	//		}
	//		else
	//		{
	//			Window.alert(e.getMessage());
	//		}
	//	}
		
		
		/**
	     * 
	     * @param e Exception
	     */
	    public void onException (Exception e)
	    {
	        Bwt.log(e);
	    }


	/**
	 * 
	 * @param event HistoryStateChangeEvent
	 */
	protected void onHistoryStateChange (HistoryStateChangeEvent event)
    {
	    try
	    {
	        String url = event.getUrl();
	        this.routePath(url);
	    }
	    catch (Exception e)
	    {
	        ApplicationException appException = new ApplicationException(e);
	        Bwt.log(appException);
	    }
    }


    /**
     * 
     * @param path String
     * @throws Exception 
     */
    protected void routePath (String path) throws Exception
    {
    	try
 		{
    		this.getRouter().route(this, path);    		
 		}
		catch (Exception e)
		{
			throw e;
		}
    }


    /**
     * @throws Exception 
	 * 
	 */
	abstract protected void setup () throws Exception;
}
