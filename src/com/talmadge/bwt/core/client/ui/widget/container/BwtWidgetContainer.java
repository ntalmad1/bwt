package com.talmadge.bwt.core.client.ui.widget.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;
import com.talmadge.bwt.core.client.ui.Bwt;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutUtils;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.dom.style.Border;
import com.talmadge.bwt.core.client.ui.dom.style.BwtStyle.ContentAlign;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.BwtWidget;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.html.Html;
import com.talmadge.bwt.core.client.ui.widget.html.HtmlTag;

/**
 * 
 *
 */
public abstract class BwtWidgetContainer extends BwtWidget implements BwtWidgetContainerInterface
{
	/**
     */
    private WidgetCollection children;
	
    
    /**
     * 
     * @param panel
     * @return BwtWidgetContainer
     * @throws Exception 
     */
	public static BwtWidgetContainer wrap (Panel panel) throws Exception
	{
		if (panel.getElement().getId() == null || panel.getElement().getId().isEmpty())
		{
			// throw new Exception("Panel ID cannot be null.");
			panel.getElement().setId(BwtWidgetUtils.uniqueId());
		}
		
		return Bwt.getContainerById(panel.getElement().getId());
	}


	/**
	 * Constructor
	 * 
	 * @param appearance Appearance
	 */
	protected BwtWidgetContainer (BwtWidgetAppearance appearance)
	{
		super(appearance);
		
		this.children = new WidgetCollection(this);
	}

	
	/**
	 *
	 * @param child IsWidget
	 */
	public void add (IsWidget child)
	{
	    this.add(child.asWidget());
	}

	
	/**
	 *
	 * @param child Widget
	 */
	public void add (Widget child)
	{
	    this.getChildren().add(child);
	
	    this.getAppearance().add(child);
	    
	    if (this.isAttached())
	    {
	        this.attachChild(child);
	    }
	}
	
	
	/**
	 * 
	 * @param child widget
	 * @param index int
	 */
	public void insertWidget (Widget widget, int index)
	{
		this.getChildren().insert(widget, index);
		
		this.getAppearance().insert(widget, index);
		
		if (this.isAttached())
	    {
	        this.attachChild(widget);
	    }
	}
	
	
	/**
	 * 
	 * @param html String
	 */
	public void add (String html)
	{
		this.add(new HTML(html));
	}
	
	
	/**
	 * 
	 * @param child Widget
	 * @param margins Margins
	 */
	public void add (Widget child, Margins... margins)
	{
		for (int i = 0; i < margins.length; ++i)
		{
			LayoutUtils.applyMargins(child, margins[i]);
		}
		
		this.add(child);
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
	 * @param child Widget
	 * @param padding Padding
	 */
	public void add (Widget child, Padding padding)
	{
		LayoutUtils.applyPadding(child, padding);
		
		this.add(child);
	}
	
	
	/**
	 * 
	 */
	public void br ()
	{
		this.br(0);
	}
	
	
	/**
	 * 
	 * @param height int
	 */
	public void br (int height)
	{
		Html spacer = new  Html(HtmlTag.DIV);
		spacer.setHeight(height);
		
		this.add(spacer);
	}
	
	
	/**
	 * 
	 */
	public void clear ()
	{
		List<Widget> widgetsToRemove = new ArrayList<Widget>();
		
		for (Widget widget : this.getChildren())
		{
		    widgetsToRemove.add(widget);
		}
		
		for (Widget widget : widgetsToRemove)
		{
			this.remove(widget);
		}
	}
	
	
	/**
	 *
	 * @return WidgetCollection
	 */
	public WidgetCollection getChildren ()
	{
	    return this.children;
	}
	

	/**
	 * 
	 * @return Iterator<Widget>
	 */
	public Iterator<Widget> iterator ()
	{
		return this.children.iterator();
	}
	
	
	/**
	 * 
	 */
	public void mask ()
	{
		this.getAppearance().mask();
	}
	
	
	/**
	 * 
	 */
	public void mask (String message)
	{
		this.getAppearance().mask(message);
	}
	
	
	/**
	 *
	 * @param child IsWidget
	 * @return boolean true if the widget was present
	 */
	public boolean remove (IsWidget child)
	{
		return this.remove(child.asWidget());
	}

	
	/**
	 *
	 * @param child Widget
	 * @return boolean true if the widget was present
	 */
	public boolean remove (Widget child)
	{
		if (this.getChildren().contains(child))
	    {
	        this.getChildren().remove(child);
	        
	        this.getAppearance().remove(child);
	
	        if (this.isAttached())
	        {
	            this.detachChild(child);
	        }
	        
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}
	
	
	/**
	 * 
	 * @param affix Affix
	 */
	public void setAffix (Affix affix)
	{
	    this.getAppearance().setAffix(affix); 
	}
	
	
	/**
	 * 
	 * @param color String
	 */
	public void setBackgroundColor (String color)
    {
        this.getAppearance().setBackgroundColor(color);
    }
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorders (Border border)
	{
		this.setBorderBottom(border);
		this.setBorderLeft(border);
		this.setBorderRight(border);
		this.setBorderTop(border);
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderBottom (Border border)
	{
		this.getAppearance().setBorderBottom(border);
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderLeft (Border border)
	{
		this.getAppearance().setBorderLeft(border);
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderRight (Border border)
	{
		this.getAppearance().setBorderRight(border);
	}
	
	
	/**
	 * 
	 * @param border Border
	 */
	public void setBorderTop (Border border)
	{
		this.getAppearance().setBorderTop(border);
	}
	
	
	/**
	 * This function means that this component should be centered in its parent container.
	 * To center content use content align
	 * 
	 * @param centered booelan
	 */
	public void setCentered (boolean centered)
	{
	    this.getAppearance().setCentered(centered);
	}
	
	
	/**
	 * 
	 * 
	 * @param align ContentAlign
	 */
    public void setContentAlign (ContentAlign align)
    {
        this.getAppearance().setContentAlign(align);
    }
    
	
	/**
	 * 
	 * @param radius int
	 */
    public void setCornerRadius (int radius)
    {
        this.setCornerRadiusBottomLeft(radius);
        this.setCornerRadiusBottomRight(radius);
        this.setCornerRadiusTopLeft(radius);
        this.setCornerRadiusTopRight(radius);
    }
    
    
    /**
     * 
     * @param topLeft int 
     * @param topRight int 
     * @param bottomRight int 
     * @param bottomLeft int
     */
	public void setCornerRadius (int topLeft, int topRight, int bottomRight, int bottomLeft)
	{
		 this.setCornerRadiusBottomLeft(bottomLeft);
        this.setCornerRadiusBottomRight(bottomRight);
        this.setCornerRadiusTopLeft(topLeft);
        this.setCornerRadiusTopRight(topRight);
		
	}
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadiusBottomLeft (int radius)
    {
        this.getAppearance().setCornerRadiusBottomLeft(radius);
    }
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadiusBottomRight (int radius)
    {
        this.getAppearance().setCornerRadiusBottomRight(radius);
    }
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadiusTopLeft (int radius)
    {
        this.getAppearance().setCornerRadiusTopLeft(radius);
    }
    
    
    /**
     * 
     * @param radius int
     */
    public void setCornerRadiusTopRight (int radius)
    {
        this.getAppearance().setCornerRadiusTopRight(radius);
    }
	
    
	/**
	 * 
	 * @param display Display
	 */
	public void setDisplay (Display display)
	{
		this.getAppearance().setDisplay(display);
		
	}
	
	
	/**
	 * 
	 * @param width int
	 */
	public BwtWidgetContainer setMaxWidth (int width)
	{
		this.getAppearance().setMaxWidth(width);
		
		return this; 
	}
	
	
	/**
	 * 
	 * @param height int
	 */
	public void setMinHeight (int height)
	{
		this.getAppearance().setMinHeight(height); 
	}
	
	
	/**
	 * 
	 * @param height String
	 */
	public void setMinHeight (String height)
	{
		this.getAppearance().setMinHeight(height); 		
	}
	
	
	/**
	 * 
	 * @param top int
	 * @param right int
	 * @param bottom int 
	 * @param left int
	 */
    public void setPadding (int top, int right, int bottom, int left)
    {
        this.setPaddingTop(top);
        this.setPaddingRight(right);
        this.setPaddingBottom(bottom);
        this.setPaddingLeft(left);
    }
	
    
	/**
	 * 
	 * @param padding int  
	 */
	public void setPadding (int padding)
	{
	    this.setPaddingTop(padding);
	    this.setPaddingRight(padding);
	    this.setPaddingBottom(padding);
	    this.setPaddingLeft(padding);
	}
	
	
	/**
	 * 
	 * @param paddingBottom int
	 */
	public void setPaddingBottom (int paddingBottom)
	{
		this.getAppearance().setPaddingLeft(paddingBottom);
		
	}
	
	
	/**
	 * 
	 * @param paddingLeft int
	 */
	public void setPaddingLeft (int paddingLeft)
	{
		this.getAppearance().setPaddingLeft(paddingLeft);
		
	}
	
	
	/**
	 * 
	 * @param paddingRight int
	 */
	public void setPaddingRight (int paddingRight)
	{
		this.getAppearance().setPaddingLeft(paddingRight);
		
	}
	
	
	/**
	 * 
	 * @param paddingTop int
	 */
	public void setPaddingTop (int paddingTop)
	{
		this.getAppearance().setPaddingTop(paddingTop);	 	
	}
	
	
	/**
	 * 
	 * @param hasShadow boolean
	 */
	public void setShadow (boolean hasShadow)
	{
		if (hasShadow)
		{
			this.setShadow(ShadowConfig.DEFAULT);
		}
		else 
		{
			this.setShadow(ShadowConfig.NONE);
		}
	}
	
	
	/**
	 * 
	 */
	public void setShadow (ShadowConfig config)
	{
		this.getAppearance().setShadow(config);
	}
	
	
	/**
	 * 
	 * @param alignment TextAlign
	 */
	public void setTextAlign (TextAlign alignment)
	{
		this.getAppearance().setTextAlign(alignment);
	}
	
	
	/**
	 * 
	 * @param align VerticalAlign
	 */
	public void setVerticalAlign (VerticalAlign align)
	{
		this.getAppearance().setVerticalAlign(align);		
	}
	
	
	/**
	 * 
	 */
	public void unmask ()
	{
		this.getAppearance().unmask();		
	}


	/**
	 *
	 * @param widget Widget
	 */
	protected void attachChild (Widget widget)
	{
		BwtWidgetUtils.attachWidget(widget);
	}


	/**
	 *
	 * @param widget Widget
	 */
	protected void detachChild (Widget widget)
	{
		BwtWidgetUtils.detachWidget(widget);
	}

	
	/**
	 * 
	 * @return BwtWidgetContainerAppearance
	 */
	protected BwtWidgetContainerAppearance getAppearance ()
	{
		return (BwtWidgetContainerAppearance) super.getAppearance();
	}
	

	/**
	 *
	 */
	protected void onAttach ()
	{
		super.onAttach();

		for (Widget widget : this.children)
		{
			this.attachChild(widget);
		}
	}


	/**
	 *
	 */
	protected void onDetach ()
	{
		super.onDetach();

		for (Widget widget : this.children)
		{
			this.detachChild(widget);
		}
	}
}
