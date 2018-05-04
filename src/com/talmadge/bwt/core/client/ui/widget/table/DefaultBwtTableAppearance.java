package com.talmadge.bwt.core.client.ui.widget.table;

import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 */
public class DefaultBwtTableAppearance extends DefaultBwtWidgetContainerAppearance implements BwtTableAppearance
{
    /**
     * 
     */
    public DefaultBwtTableAppearance ()
    {
        super(DOM.createTable());
    }

    
    /**
     * 
     */
    @Override
    protected void build ()
    {
        this.ensureCssName("table");
  
        this.ensureCssName("table-hover");
        
        this.setBordered(true);
        this.setStriped(true);
        
        this.getElement().setAttribute("cellspacing", "0");
    }
    
    
    /**
     * 
     * @param bordered boolean
     */
    @Override
    public void setBordered (boolean bordered)
    {
        this.toggleCssName("table-bordered", bordered);        
    }
    

    /**
     * 
     * @param striped boolean
     */
    @Override
    public void setStriped (boolean striped)
    {
        this.toggleCssName("table-striped", striped);        
    }
    
    
}
