package com.talmadge.bwt.core.client.ui.widget.screenmask;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Image;
import com.talmadge.bwt.core.client.ui.resources.BwtResources;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;

/**
 * 
 *
 */
public class DefaultScreenMaskAppearance extends DefaultBwtWidgetAppearance implements ScreenMaskAppearance
{
    /**
     */
    private Element imgElement;
    
    /**
     */
    private Element msgElement;
    
    
    
    /**
     * Constrcutor
     * 
     */
    public DefaultScreenMaskAppearance ()
    {
        this(DOM.createDiv());
    }
    
    
    /**
     * Hidden Constructor
     * 
     * @param element Element
     */
    protected DefaultScreenMaskAppearance (Element element)
    {
        super(element);
    }

    
    /**
     * 
     */
    @Override
    protected void build ()
    {
        this.ensureCssName("screenMask");
            
        Image image = new Image(BwtResources.INSTANCE.ajaxLoader());
        this.imgElement = image.getElement();
        this.imgElement.setId("screenMaskImage");
        this.imgElement.addClassName("screenMaskImage");
        this.getElement().appendChild(this.imgElement);
            
        this.msgElement = DOM.createDiv();
        this.msgElement.addClassName("screenMaskMessage");
        this.getElement().appendChild(this.msgElement);                
    }
    
    
    
    /**
     * 
     */
    public void layout ()
    {
        int imgTop = (Window.getClientHeight() / 2) - 25;
        int messageTop = (Window.getClientHeight() / 2) + 35;
        
        this.imgElement.getStyle().setTop(imgTop, Unit.PX);   
        this.msgElement.getStyle().setTop(messageTop, Unit.PX);  
    }


    /**
     * 
     * @param message String
     */
    @Override
    public void setText (String message)
    {
        this.msgElement.setInnerHTML(message);
    }
}
