package com.talmadge.bwt.core.client.ui.widget.appearance;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.HasCssName;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.ResponsiveDisplay;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.util.BwtElementUtils;

/**
 * 
 * @author Noah
 *
 */
public abstract class DefaultBwtWidgetAppearance implements BwtWidgetAppearance
{
	/**
	 */
	private Element element;
	
	
	/**
	 * Constructor
	 * 
	 * @param element Element
	 */
	protected DefaultBwtWidgetAppearance (Element element)
	{	
		this.setElement(element);
		
		this.build();
	}
	
	
	/**
	 * 
	 * @param cssName String css class name to add
	 */
	public void addClassName (String cssName)
	{
		this.getElement().addClassName(cssName);		
	}
	
	
	/**
	 * 
	 * @param element Element
	 */
	public void append (Element element)
	{
		this.getElement().appendChild(element);
	}
	
	
	/**
	 * 
	 */
	public void clear ()
	{
		this.getElement().removeAllChildren();
	}
	
	
	/**
	 * 
	 */
	public void clearCssNames ()
	{
		this.getElement().setAttribute("class", "");
	}
	
	
    /**
	 * 
	 * @param cssName HasCssName
	 */
	public void ensureCssName (HasCssName cssName) 
	{
		this.ensureCssName(this.getElement(), cssName.getCssName());		
	}


	/**
	 * 
	 * @param cssName String
	 */
	public void ensureCssName (String cssName)
	{
		this.ensureCssName(this.getElement(), cssName);		
	}


	/**
	 * 
	 * @param element Element
	 * @param cssName String
	 */
	public void ensureCssName (Element element, String cssName)
	{
		BwtElementUtils.ensureCssName(element, cssName);		
	}


	/**
     * 
     * @return int
     */
    public int getAbsoluteHeight ()
    {
        return this.getElement().getAbsoluteBottom() - this.getElement().getAbsoluteTop();
    }

    
    /**
     * 
     * @return int
     */
    public int getAbsoluteWidth ()
    {
        return this.getElement().getAbsoluteRight() - this.getElement().getAbsoluteLeft();
    }

    
	/**
	 * 
	 * @return Element 
	 */
	public Element getElement ()
	{
		return this.element;
	}
	
	
	/**
	 * 
	 * @return int
	 */
	public int getHeight ()
	{
	    return this.getElement().getClientHeight();
	}
	
	
	/**
     *
     * @return int;
     */
    public int getWidth ()
    {
        return this.getElement().getClientWidth();
    }
	
	
	
	/**
	 * 
	 * @param cssName String cssName
	 * @return boolean
	 */
	public boolean hasCssName (String cssName)
	{
		return this.getElement().hasClassName(cssName);
	}
	
	
	/**
	 * 
	 * @param element Element
	 */
	public void prepend (Element element)
	{
		this.getElement().insertFirst(element);
	}
	
	
	/**
	 * 
	 * @param cssName String
	 */
	public void removeCssName (String cssName)
	{
		this.removeCssName(this.getElement(), cssName);		
	}
	
	
	/**
	 * 
	 * @param element Element
	 * @param cssName String
	 */
	public void removeCssName (Element element, String cssName)
	{
		BwtElementUtils.removeCssName(element, cssName);		
	}
	
	
	
	/**
	 * 
	 * @param cssNames HasCssName[]
	 */
	public void removeCssNames (HasCssName[] cssNames)
	{
		this.removeCssNames(this.getElement(), cssNames);		
	}


	/**
	 * 
	 * @param element Element
	 * @param cssNames HasCssName[]
	 */
	public void removeCssNames (Element element, HasCssName[] cssNames)
	{
		BwtElementUtils.removeCssNames(element, cssNames);		
	}
	
	
    /**
     * 
     * @param centered boolean
     */
    public void setCentered (boolean centered)
    {
        this.toggleCssName("center-block", centered);
    }
    
    
    /**
     *
     * @param left String
     */
    public void setLeft (String left)
    {
    	this.getElement().getStyle().setProperty("left", left);
    }
    
    
    /**
	 * 
	 * @param margin int
	 */
	public void setMargin (int margin)
	{
		this.getElement().getStyle().setMargin(margin, Unit.PX);	
	}
    
    
    /**
      * 
	 * @param marginBottom int
	 */
	public void setMarginBottom (int marginBottom)
	{
		this.getElement().getStyle().setMarginBottom(marginBottom, Unit.PX);
		
	}

	
	/**
	 * 
	 * @param marginLeft int
	 */
	public void setMarginLeft (int marginLeft)
	{
		this.getElement().getStyle().setMarginLeft(marginLeft, Unit.PX);			
	}

	
	/**
	 * 
	 * @param marginRight int
	 */
	public void setMarginRight (int marginRight)
	{
		this.getElement().getStyle().setMarginRight(marginRight, Unit.PX);				
	}

	
	/**
	 * 
	 * @param marginTop int
	 */
	public void setMarginTop (int marginTop)
	{
		this.getElement().getStyle().setMarginTop(marginTop, Unit.PX);		
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
	 * @param size Size
	 * @param display ResponsiveDisplay
	 */
	public void setResponsiveDisplay (Size size, ResponsiveDisplay display)
	{
		this.removeCssNames(ResponsiveDisplay.values(size));
		
		this.ensureCssName(display.getCssName(size));
	}

	
	/**
	 * 
	 * @param top String
	 */
	public void setTop (String top)
	{
		this.getElement().getStyle().setProperty("top", top);
	}
	
	
	/**
	 * 
	 * @param value double
	 * @param unit Unit
	 */
	public void setTop (double value, Unit unit)
	{
		this.getElement().getStyle().setTop(value, unit);
	}
	

	/**
	 * 
	 * @param cssName String
	 * @param toggle boolean
	 */
	public void toggleCssName (String cssName, boolean toggle)
	{
		this.toggleCssName(this.getElement(), cssName, toggle);
		
	}

	
	/**
	 * 
	 * @param element Element
	 * @param cssName String
	 * @param toggle boolean
	 */
	public void toggleCssName (Element element, String cssName, boolean toggle)
	{
		BwtElementUtils.toggleCssName(element, cssName, toggle);
	}


	/**
	 * 
	 */
	protected abstract void build ();
	
	
	/**
	 * 
	 * @param element Element
	 */
	protected void setElement (Element element)
	{
		this.element = element;
	}

}
