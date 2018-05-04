package com.talmadge.bwt.core.client.ui.widget.nav.navbar.header;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultNavBarHeaderAppearance extends DefaultBwtWidgetContainerAppearance implements NavBarHeaderAppearance
{
    /**
     */
    private Element toggleButton;
    
    
    
    /**
     * Constructor
     * 
     */
    public DefaultNavBarHeaderAppearance ()
    {
        super();
    }
    
    
    /**
     * 
     */
    protected void build ()
    {
        this.ensureCssName("navbar-header");
        
        
        this.toggleButton = DOM.createButton();
        
        // <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        this.ensureCssName(this.toggleButton, "navbar-toggle");
        this.ensureCssName(this.toggleButton, "collapsed");
        
        this.toggleButton.setAttribute("data-toggle", "collapse");
        
        Element srOnly = DOM.createSpan();
        srOnly.setInnerHTML("Toggle navigation");
        this.ensureCssName(srOnly, "sr-only");
        
        Element iconBarOne = DOM.createSpan(); 
        this.ensureCssName(iconBarOne, "icon-bar");
        
        Element iconBarTwo = DOM.createSpan(); 
        this.ensureCssName(iconBarTwo, "icon-bar");
        
        Element iconBarThree = DOM.createSpan(); 
        this.ensureCssName(iconBarThree, "icon-bar");
        
        this.toggleButton.appendChild(srOnly);
        this.toggleButton.appendChild(iconBarOne);
        this.toggleButton.appendChild(iconBarTwo);
        this.toggleButton.appendChild(iconBarThree);
        
        this.getElement().appendChild(this.toggleButton);
        
    }
    
    
    /**
     * 
     * @param targetId String
     */
    public void setToggleTarget (String targetId)
    {
        this.toggleButton.setAttribute("data-target", "#" + targetId);
    }
}
