package com.talmadge.bwt.core.client.ui.widget.nav.navitem.history;

import com.talmadge.bwt.core.client.history.BwtHistory.MatchMode;
import com.talmadge.bwt.core.client.ui.widget.nav.navitem.NavItem;

/**
 * 
 *
 */
public class HistoryNavItem extends NavItem
{
    /**
     * Constructor 
     */
    public HistoryNavItem () 
    {
       this(new HistoryNavItemCell());
    }
    

    /**
     * 
     * @param text String
     */
    public HistoryNavItem (String text)
    {
        this();
        
        this.setText(text);
    }
    
    
    /**
     * Constructor
     * 
     * @param historyToken String
     * @param text String
     */
    public HistoryNavItem (String historyToken, String text)
    {
        this();
        
        this.setHistoryToken(historyToken);
        this.setText(text);
    }

    
    /**
     * 
     * @param cell HistoryNavItemCell
     */
    protected HistoryNavItem (HistoryNavItemCell cell)
	{
		super(cell);
	}


	/**
     * 
     * @param token String
     */
    public void setHistoryToken (String token)
    {
        this.getCell().setHistoryToken(token);
    }
    
    
    /**
     * 
     * @param matchMode MatchMode
     */
    public void setMatchMode (MatchMode matchMode)
    {
        this.getCell().setMatchMode(matchMode);
    }


    /**
     * 
     * @return HistoryNavItemCell
     */
    protected HistoryNavItemCell getCell ()
    {
        return (HistoryNavItemCell) super.getCell();
    }

}
