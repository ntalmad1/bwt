package com.talmadge.bwt.core.client.ui.widget.carousel;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Unit;
import com.talmadge.bwt.core.client.ui.widget.carousel.item.CarouselItem;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 *
 */
public class DefaultCarouselAppearance extends DefaultBwtWidgetContainerAppearance implements CarouselAppearance
{
    /**
     */
    private Element indicatorsElement;
    
    /**
     */
    private Element innerElement;
    
    /**
     */
    private Element leftControlElement;
    
    /**
     */
    private Element rightControlElement;
    
    /**
     */
    private List<Element> indicators;
    
    /**
     */
    private List<Element> items; 
    
    
    
    /**
     * Constructor
     * 
     */
    protected DefaultCarouselAppearance ()
    {
        super(Document.get().createDivElement());
        
        this.indicators = new ArrayList<Element>();
        this.items = new ArrayList<Element>();
    }

    
    /**
     * 
     */
    public void clearActive ()
    {
        for (Element indicator : this.indicators)
        {
            this.toggleCssName(indicator, "active", false);
        }
        
        for (Element item : this.items)
        {
            this.toggleCssName(item, "active", false);
        }
    }


    /**
     * 
     *  @param items List<CarouselItem>
     */
    @Override
    public void onItemAdded (List<CarouselItem> items)
    {
        this.indicatorsElement.removeAllChildren();
        this.innerElement.removeAllChildren();
        
        this.indicators.clear();
        this.items.clear();
        
        
        int index = 0;
        for (CarouselItem item : items)
        {
            Element li = Document.get().createLIElement();
            li.setAttribute("data-target", "#" + this.getElement().getId());
            li.setAttribute("data-slide-to", "" + index);
        
            this.indicators.add(li);
            this.indicatorsElement.appendChild(li);
            
            this.items.add(item.getElement());
            this.innerElement.appendChild(item.getElement());
            
            ++index;
        }
    }

    
    /**
     * 
     * @param index int
     */
    @Override
    public void setActive (int index)
    {
        if (!this.indicators.isEmpty() && this.indicators.size() > index)
        {
            this.clearActive();
            
            this.toggleCssName(this.indicators.get(index), "active", true);
            this.toggleCssName(this.items.get(index), "active", true);
        }
        
    }


    /**
     * 
     * @param id String
     */
    @Override
    public void setId (String id)
    {
        this.leftControlElement.setAttribute("href", "#" + id);
        this.rightControlElement.setAttribute("href", "#" + id);
    }

    
    /**
     * 
     * @param height int
     */
    @Override
    public void setHeight (int height)
    {
        this.innerElement.getStyle().setHeight(height, Unit.PX);
    }


    /**
     * 
     */
    @Override
    protected void build ()
    {
        this.ensureCssName("carousel");
        this.ensureCssName("slide");
        
        this.getElement().setAttribute("data-ride", "carousel");
        
        this.indicatorsElement = Document.get().createOLElement();
        this.ensureCssName(this.indicatorsElement, "carousel-indicators");
        
        this.innerElement = Document.get().createDivElement();
        this.ensureCssName(this.innerElement, "carousel-inner");
        
        this.createLeftControl();
        this.createRightControl();
        
        this.getElement().appendChild(this.indicatorsElement);
        this.getElement().appendChild(this.innerElement);
        this.getElement().appendChild(this.leftControlElement);
        this.getElement().appendChild(this.rightControlElement);
    }

    
    /**
     * 
     */
    private void createRightControl ()
    {
        this.leftControlElement = Document.get().createAnchorElement();
        this.ensureCssName(this.leftControlElement, "left");
        this.ensureCssName(this.leftControlElement, "carousel-control");
        this.leftControlElement.setAttribute("data-slide", "prev");
        
        Element icon = Document.get().createSpanElement();
        this.ensureCssName(icon, "glyphicon");
        this.ensureCssName(icon, "glyphicon-chevron-left");
        
        this.leftControlElement.appendChild(icon);
    }

    
    /**
     * 
     */
    private void createLeftControl ()
    {
        this.rightControlElement = Document.get().createAnchorElement();
        this.ensureCssName(this.rightControlElement, "right");
        this.ensureCssName(this.rightControlElement, "carousel-control");
        this.rightControlElement.setAttribute("data-slide", "next");
        
        Element icon = Document.get().createSpanElement();
        this.ensureCssName(icon, "glyphicon");
        this.ensureCssName(icon, "glyphicon-chevron-right");
        
        this.rightControlElement.appendChild(icon);
    }

}
