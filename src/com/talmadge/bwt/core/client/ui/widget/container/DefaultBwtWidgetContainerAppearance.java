package com.talmadge.bwt.core.client.ui.widget.container;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.dom.style.Border;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.BwtTextAlign;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.mask.BwtMask;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;


/**
 * 
 * @author Noah
 *
 */
public abstract class DefaultBwtWidgetContainerAppearance extends DefaultBwtWidgetAppearance implements BwtWidgetContainerAppearance
{	
	/**
	 * 
	 */
	private BwtMask mask;

	

	/**
	 * Constructor
	 * 
	 */
	public DefaultBwtWidgetContainerAppearance ()
	{
		this(Document.get().createDivElement());
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param element Element
	 */
	protected DefaultBwtWidgetContainerAppearance (Element element)
	{
		super(element);
	}


	/**
	 * 
	 * @param widget Widget
	 */
	public void add (Widget widget)
	{
		this.getElement().appendChild(widget.getElement());
	}
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param margins Margins
	 */
	public void add (Widget widget, Margins margins)
	{
		widget.getElement().getStyle().setMarginTop(margins.getTop(), Unit.PX);
		widget.getElement().getStyle().setMarginRight(margins.getRight(), Unit.PX);
		widget.getElement().getStyle().setMarginBottom(margins.getBottom(), Unit.PX);
		widget.getElement().getStyle().setMarginLeft(margins.getLeft(), Unit.PX);
		
		this.add(widget);
	}
	
	
	/**
	 * 
     * @return String
     */
    public String getCornerRadiusTopLeft ()
    {
        return this._getCornerRadiusTopLeft(this.getElement().getId());
    }
    
    
    /**
	 * 
     * @return String
     */
    public String getCornerRadiusTopRight ()
    {
        return this._getCornerRadiusBottomLeft(this.getElement().getId());
    }
    
    
    /**
	 * 
     * @return String
     */
    public String getCornerRadiusBottomRight ()
    {
        return this._getCornerRadiusBottomRight(this.getElement().getId());
    }
	
	
	/**
	 * 
     * @return String
     */
    public String getCornerRadiusBottomLeft ()
    {
        return this._getCornerRadiusBottomLeft(this.getElement().getId());
    }

    
    /**
	 * 
	 * @param widget Widget
	 * @param index int
	 */
	public void insert (Widget widget, int index)
	{
		this.getElement().insertBefore(widget.getElement(), this.getElement().getChildNodes().getItem(index));
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
		if (mask == null)
		{
			this.mask = new BwtMask(this.getElement(), message); 
			this.mask.mask();
		}
	}
	
	
	/**
	 * 
	 * @param widget Widget
	 * @return boolean return true if the widget exits
	 */
	public boolean remove (Widget widget)
	{
		if (this.getElement().isOrHasChild(widget.getElement()))
		{
			this.getElement().removeChild(widget.getElement());
			return true;
		}
		
		return false;
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
	 * @param affix Affix
	 */
	public void setAffix (Affix affix)
	{
	    switch (affix)
	    {
	        case BOTTOM:
	            this.ensureCssName("navbar-static-bottom");
	            this.setMarginBottom(0);
	            break;
	        case TOP:
	            this.ensureCssName("navbar-fixed-top");
	            this.setMarginTop(0);
	            break;
	        default:
	    }
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderBottom (Border border)
	{
		if (Border.NONE.equals(border))
		{
			this.getElement().getStyle().setProperty("borderBottomStyle", "none");
			return;
		}
		
		this.getElement().getStyle().setProperty("borderBottomWidth", border.getWidth(), Unit.PX);
		this.getElement().getStyle().setProperty("borderBottomStyle", border.getStyle().getCssName());
		this.getElement().getStyle().setProperty("borderBottomColor", border.getColor());
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderLeft (Border border)
	{
		if (Border.NONE.equals(border))
		{
			this.getElement().getStyle().setProperty("borderLeftStyle", "none");
			return;
		}
		
		this.getElement().getStyle().setProperty("borderLeftWidth", border.getWidth(), Unit.PX);
		this.getElement().getStyle().setProperty("borderLeftStyle", border.getStyle().getCssName());
		this.getElement().getStyle().setProperty("borderLeftColor", border.getColor());
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderRight (Border border)
	{
		if (Border.NONE.equals(border))
		{
			this.getElement().getStyle().setProperty("borderRightStyle", "none");
			return;
		}
		
		this.getElement().getStyle().setProperty("borderRightWidth", border.getWidth(), Unit.PX);
		this.getElement().getStyle().setProperty("borderRightStyle", border.getStyle().getCssName());
		this.getElement().getStyle().setProperty("borderRightColor", border.getColor());
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderTop (Border border)
	{
		if (Border.NONE.equals(border))
		{
			this.getElement().getStyle().setProperty("borderTopStyle", "none");
			return;
		}
		
		this.getElement().getStyle().setProperty("borderTopWidth", border.getWidth(), Unit.PX);
		this.getElement().getStyle().setProperty("borderTopStyle", border.getStyle().getCssName());
		this.getElement().getStyle().setProperty("borderTopColor", border.getColor());
	}
	
	
	
	/**
	 * 
	 * @param align ContentAlign
	 */
	public void setContentAlign (ContentAlign align)
	{
	    this.removeCssNames(BwtTextAlign.values());
	    this.removeCssNames(ContentAlign.values());
	    
	    this.ensureCssName(align);
	}
	
	
	/**
	 * 
     * @param radius int
     */
    public void setCornerRadiusBottomLeft (int radius)
    {
        this.getElement().getStyle().setProperty("borderBottomLeftRadius", radius, Unit.PX);
    }
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadiusBottomRight (int radius)
    {
        this.getElement().getStyle().setProperty("borderBottomRightRadius", radius, Unit.PX);
    }
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadiusTopLeft (int radius)
    {
        this.getElement().getStyle().setProperty("borderTopLeftRadius", radius, Unit.PX);
    }
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadiusTopRight (int radius)
    {
        this.getElement().getStyle().setProperty("borderTopRightRadius", radius, Unit.PX);
    }
	
	
	/**
	 * 
	 * @param display Display
	 */
	public void setDisplay (Display display)
	{
		this.getElement().getStyle().setDisplay(display);
	}

	
	/**
	 * @param width int
	 */
	public void setMaxWidth (int width)
	{
		this.getElement().getStyle().setProperty("maxWidth", width, Unit.PX);
	}
	
	
	/**
	 * 
	 * @param height int
	 */
	public void setMinHeight (int height)
	{
		this.getElement().getStyle().setProperty("minHeight", height, Unit.PX);
	}
	
	
	/**
	 * 
	 * @param height String
	 */
	public void setMinHeight (String height)
	{
		this.getElement().getStyle().setProperty("minHeight", height);
	}
	
	
	/**
	 * 
	 * @param padding Padding
	 */
	public void setPadding (Padding padding)
	{
		this.setPaddingTop(padding.getTop());
		this.setPaddingRight(padding.getRight());
		this.setPaddingBottom(padding.getBottom());
		this.setPaddingLeft(padding.getLeft());
	}
	
	
	/**
	 * 
	 * @param padding int
	 */
	public void setPadding (int padding)
	{
		this.getElement().getStyle().setPadding(padding, Unit.PX);
		
	}

	
	/**
	 *
	 * @param paddingBottom int
	 */
	public void setPaddingBottom (int paddingBottom)
	{
		this.getElement().getStyle().setPaddingBottom(paddingBottom, Unit.PX);
		
	}

	
	/**
	 * @param paddingLeft int
	 */
	public void setPaddingLeft (int paddingLeft)
	{
		this.getElement().getStyle().setPaddingLeft(paddingLeft, Unit.PX);
		
	}

	
	/**
	 * 
	 * @param paddingRight int
	 */
	public void setPaddingRight (int paddingRight)
	{
		this.getElement().getStyle().setPaddingRight(paddingRight, Unit.PX);
	}

	/**
	 * 
	 * @param paddingTop int
	 */
	public void setPaddingTop (int paddingTop)
	{
		this.getElement().getStyle().setPaddingTop(paddingTop, Unit.PX);		
	}

	
	/**
	 * 
	 * @param config
	 */
	public void setShadow(ShadowConfig config)
	{
		this.getElement().getStyle().setProperty("boxShadow", config.toString());
	}
	
	
	/**
	 * 
	 * @param alignment TextAlign
	 */
	public void setTextAlign (TextAlign alignment)
	{
		this.getElement().getStyle().setTextAlign(alignment);
	}

	
	/**
	 * 
	 * @param align VerticalAlign VerticalAlign
	 */
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getElement().getStyle().setVerticalAlign(align);
	}
	
	
	/**
	 * 
	 */
	public void unmask ()
	{
		if (this.mask != null)
		{
			this.mask.unmask();
			this.mask = null;
		}
	}
	
	
	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusTopLeft (String id) /*-{
		
		return $wnd.$("#" + id).css("border-top-left-radius");
		
	}-*/;
	
	
	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusTopRight (String id) /*-{
		
		return $wnd.$("#" + id).css("border-top-right-radius");
		
	}-*/;
	
	
	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusBottomRight (String id) /*-{
		
		return $wnd.$("#" + id).css("border-bottom-right-radius");
		
	}-*/;
	
	
	/**
	 * 
	 * @param id String
	 * @return String
	 */
	private native String _getCornerRadiusBottomLeft (String id) /*-{
		
		return $wnd.$("#" + id).css("border-bottom-left-radius");
		
	}-*/;
	
	

}
