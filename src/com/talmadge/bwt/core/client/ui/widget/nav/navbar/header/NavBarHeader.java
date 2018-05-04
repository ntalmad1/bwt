package com.talmadge.bwt.core.client.ui.widget.nav.navbar.header;

import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainer;
import com.talmadge.bwt.core.client.ui.widget.html.a.A;
import com.talmadge.bwt.core.client.ui.widget.image.BwtImage;

/**
 * 
 *
 */
public class NavBarHeader extends BwtWidgetContainer 
{
    /**
     */
    private A navBarBrand;
    
    
    /**
     * Constructor
     *  
     */
    public NavBarHeader ()
    {
        this(new DefaultNavBarHeaderAppearance());
    }
    
    
    /**
     * Hidden Constructor
     * 
     * @param appearance NavBarHeaderAppearance
     */
    protected NavBarHeader (NavBarHeaderAppearance appearance)
    {
        super(appearance);
        
        this.navBarBrand = new A();
        this.navBarBrand.ensureCssName("navbar-brand");
        this.navBarBrand.getElement().getStyle().setCursor(Cursor.POINTER);
        this.navBarBrand.hide();
        
        this.bindBrand();
        
        
        this.add(this.navBarBrand);
    }

    
    /**
     * 
     * @return A
     */
    public A getBrand ()
    {
        return this.navBarBrand;
    }


    /**
     * 
     * @param image ImageResource
     */
    public void setIcon (ImageResource image)
    {
        A navBarBrand = this.getNavBarBrand();     
        navBarBrand.clear(); 
        navBarBrand.add(new BwtImage(image)); 
        navBarBrand.setVisible(true);
    }

    
    /**
     * 
     * @param targetId String
     */
    public void setToggleTarget (String targetId)
    {
        this.getAppearance().setToggleTarget(targetId);        
    }


    /**
     * 
     */
    protected void bindBrand ()
    {   
        this.navBarBrand.addClickHandler(new ClickHandler()
        {
            public void onClick (ClickEvent event)
            {
                NavBarHeader.this.onBrandClick();                
            }
        });
        
    }

    
    /**
     * 
     * @return NavBarHeaderAppearance
     */
    protected NavBarHeaderAppearance getAppearance ()
    {
        return (NavBarHeaderAppearance) super.getAppearance();
    }
    

    /**
     * 
     *  @return A
     */
    protected A getNavBarBrand ()
    {
        return this.navBarBrand;        
    }

    
    
    /**
     * 
     */
    protected void onBrandClick ()
    {
       
    }

}
