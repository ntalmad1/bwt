package com.talmadge.bwt.core.client.ui.widget.nav.navitem.history;

/**
 * 
 * @author Noah
 *
 */
public class RedirectNavItem extends HistoryNavItem
{
    /**
     * Constructor 
     */
    public RedirectNavItem () 
    {
       super(new RedirectNavItemCell());
    }
    

    /**
     * 
     * @param text String
     */
    public RedirectNavItem (String text)
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
    public RedirectNavItem (String historyToken, String text)
    {
        this();
        
        this.setHistoryToken(historyToken);
        this.setText(text);
    }

    
    /**
     * 
     * @return RedirectNavItemCell
     */
    protected RedirectNavItemCell getCell ()
    {
        return (RedirectNavItemCell) super.getCell();
    }

}
