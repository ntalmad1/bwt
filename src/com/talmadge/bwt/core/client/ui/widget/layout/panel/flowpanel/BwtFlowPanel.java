package com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutUtils;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.mask.BwtMask;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;

/**
 * 
 *
 */
public class BwtFlowPanel extends FlowPanel implements BwtPanelInterface
{
	/**
	 */
	private BwtMask mask;
	
	
	
	/**
	 * Constructor
	 * 
	 */
	public BwtFlowPanel ()
	{
		super();
		
		BwtElementUtils.ensureCssName(this.getElement(), "bwt-panel");		
	}
	
	
	/**
	 * Constrctor 
	 * 
	 * @param widget Widget
	 */
	public BwtFlowPanel (Widget widget)
	{
		this();
		
		this.add(widget);
	}

	/**
	 * 
	 * @param widget IsWidget
	 * @param margins Margins...
	 */
	public void add (IsWidget widget, Margins... margins)
	{
	    this.add(widget.asWidget(), margins);	    
	}


	/**
	 * 
	 * @param widget Widget
	 * @param margins Margins...
	 */
	public void add (Widget widget, Margins... margins)
	{
		for (int i = 0; i < margins.length; ++i)
		{
			LayoutUtils.applyMargins(widget, margins[i]);
		}
		
		this.add(widget);
	}
    
	
	/**
	 * 
	 * @return WidgetCollection
	 */
	public WidgetCollection getChildren ()
	{
		return super.getChildren();
	}

	
	/**
	 * 
	 * @param cssName String
	 */
	public void ensureCssName (String cssName)
	{
		if (!this.getElement().hasClassName(cssName))
		{
			this.getElement().addClassName(cssName);
		}
	}
	
	
	/**
	 * 
	 * @return String
	 */
	@Override
    public String getId ()
    {
        return this.getElement().getId();
    }

	
	/**
	 * 
	 */
	@Override
	public void mask ()
	{
		this.mask(null);		
	}

	
	/**
	 * 
	 */
	@Override
	public void mask (String message)
	{
		if (this.mask == null)
		{
			this.mask = new BwtMask(this.getElement(), message);
			this.mask.mask();
		}
	}
	

	/**
	 * 
	 * @param color String
	 */
	public void setBackgroundColor (String color)
	{
		this.getElement().getStyle().setBackgroundColor(color);		
	}


	/**
	 * 
	 * @param isCentered boolean
	 */
    @Override
    public void setCentered (boolean isCentered)
    {
        BwtElementUtils.toggleCssName(this.getElement(), "center-block", isCentered);
    }

    
    /**
     * 
     * @param align ContentAlign
     */
    @Override
    public void setContentAlign (ContentAlign align)
    {
        BwtElementUtils.removeCssNames(this.getElement(), ContentAlign.values());
        BwtElementUtils.ensureCssName(this.getElement(), align.getCssName());
    }

    
    /**
     * 
     * @param display Display
     */
    @Override
	public void setDisplay (Display display)
	{
    	this.getElement().getStyle().setDisplay(display);
	}


	/**
	 * 
	 * @param height int
	 */
    public void setHeight (int height)
    {
        this.setHeight(height + "px");        
    }

    
    /**
     * 
     * @param id String
     */
    @Override
    public void setId (String id)
    {
       this.getElement().setId(id);
    }
    
    
    /**
     * 
     * @param height String
     */
    public void setMinHeight (int height)
    {
        this.getElement().getStyle().setProperty("minHeight", height, Unit.PX);
    }

    
    /**
     * 
     * @param position Position
     */
    public void setPosition (Position position)
	{
		this.getElement().getStyle().setPosition(position);		
	}


	/**
     * 
     * @param align VerticalAlign
     */
	@Override
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getElement().getStyle().setVerticalAlign(align);		
	}

	
	/**
	 * 
	 * @param width int
	 */
	public void setWidth (int width)
	{
		this.getElement().getStyle().setWidth(width, Unit.PX);		
	}


	@Override
	public void unmask ()
	{
		if (this.mask != null)
		{
			this.mask.unmask();
			this.mask = null;
		}
	}
}
