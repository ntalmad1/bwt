package com.talmadge.bwt.core.client.ui.widget.nav.navitem.history;

import com.google.gwt.user.client.Window;
import com.talmadge.bwt.core.client.history.BwtHistory;
import com.talmadge.bwt.core.client.history.BwtHistory.MatchMode;
import com.talmadge.bwt.core.client.history.HistoryMatcher;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeEvent;
import com.talmadge.bwt.core.client.history.event.HistoryStateChangeHandler;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectEvent;
import com.talmadge.bwt.core.client.ui.widget.event.select.SelectHandler;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItemCell;

/**
 *
 */
public class HistoryNavItemCell extends NavItemCell
{
    /**
     */
    private String historyToken;

    /**
     */
    private HistoryMatcher matcher;
    
    
    
    /**
	 * Constructor
	 * 
	 */
	public HistoryNavItemCell ()
	{
		super();
		
		this.matcher = new HistoryMatcher();
	}
	
	
	/**
     * @return String
     */
    public String getHistoryToken ()
    {
        return this.historyToken;
    }
    
    
    /**
     * 
     * @return HistoryMatcher
     */
    public HistoryMatcher getMatcher ()
    {
        return this.matcher;
    }


    /**
     * @param token String
     */
    public void setHistoryToken (String token)
    {
        this.historyToken = token;
    }
    
    
    /**
     * 
     * @param matchMode MatchMode
     */
    public void setMatchMode (MatchMode matchMode)
    {
        this.getMatcher().setMatchMode(matchMode);        
    }


    /**
     * 
     * @return HistoryMatcher
     */
    protected HistoryMatcher getHistoryMatcher ()
    {
        return this.matcher;
    }
    
    
    /**
     * 
     * @param event HistoryStateChangeEvent
     */
    protected void onHistoryStateChange (HistoryStateChangeEvent event)
    {
        this.setActive(this.getHistoryMatcher().matches(event.getUrl(), this.getHistoryToken()));
    }


    /**
     * 
     */
    protected void onAttach ()
    {
        super.onAttach();
        
        String currentHref = Window.Location.getHref();
        this.setActive(this.getHistoryMatcher().matches(currentHref, this.getHistoryToken()));	    
    }


    /**
     * 
     */
    protected void bind ()
    {
        super.bind();
        
        BwtHistory.getInstance().addHistoryStateChangeHandler(new HistoryStateChangeHandler()
        {
            public void onHistoryStateChange (HistoryStateChangeEvent event)
            {
                HistoryNavItemCell.this.onHistoryStateChange(event);                
            }
        });
        
        this.addSelectHandler(new SelectHandler<NavItem>()
        {
            public void onSelect (SelectEvent<NavItem> event)
            {
                HistoryNavItemCell.this.onSelect();             
            }
        });
    }

    
    /**
     * 
     */
	protected void onSelect ()
	{
		BwtHistory.getInstance().push(HistoryNavItemCell.this.getHistoryToken());   
	}
}
