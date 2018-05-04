package com.talmadge.bwt.core.client.history;

import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.history.BwtHistory.MatchMode;
import com.talmadge.bwt.core.client.ui.Bwt;

/**
 * 
 *
 */
public class HistoryMatcher
{
    /**
     */
    private MatchMode mode;  
    
    
    /**
     * Constructor
     * 
     */
    public HistoryMatcher ()
    {
        this(MatchMode.ENDS_WITH);
    }
    
    
    /**
     * 
     * @param mode MatchMode
     */
    public HistoryMatcher (MatchMode mode)
    {
        this.mode = mode;
    }
    
    
    /**
     * 
     * @return MatchMode
     */
    public MatchMode getMode ()
    {
        return this.mode;
    }

    
    /**
     * 
     * @param href String
     * @param token String
     * @return boolean
     */
    public boolean matches (String href, String token)
    {
    	if (Bwt.isDebugMode())
    	{
    		Bwt.debug("HistoryMatcher.matches(" + href + ", " + token + ")");
    	}
    	
        if (token == null)
        {
            token = "";
        }
        
        if (token.startsWith("/"))
        {
            if (BwtHistory.getInstance().getBaseUrl().endsWith("/"))
            {
                token = token.substring(1);
            }
            
            token = BwtHistory.getInstance().getBaseUrl() + token;
        }
        
        if (BwtHistory.getInstance().getBaseUrl().equals("/") && href.contains(Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/"))
		{
			href = "/" + href.substring((Window.Location.getProtocol() + "//" + Window.Location.getHost() + "/").length());
		}
		else if (href.startsWith(BwtHistory.getInstance().getBaseUrl()))
	    {
	        href = "/" + href.substring(BwtHistory.getInstance().getBaseUrl().length());
	    }
        
        
        if (!token.isEmpty() && this.getMode().equals(MatchMode.BEGINS_WITH))
        {
            return href.startsWith(token);
        }
        else if (!token.isEmpty() && this.getMode().equals(MatchMode.EQUALS))
        {
            return href.equals(token);
        }
        else if (!token.isEmpty() && this.getMode().equals(MatchMode.ENDS_WITH))
        {
            return href.endsWith(token);
        }
        
        return false;
    }

    
    
    /**
     * 
     * @param matchMode MatchMode
     */
    public void setMatchMode (MatchMode matchMode)
    {
        this.mode = matchMode;
    }
}
