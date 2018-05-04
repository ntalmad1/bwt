package com.talmadge.bwt.core.client.ui.widget;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.ResponsiveDisplay;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutContstants.Size;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.event.hide.HasHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.hide.HideEvent;
import com.talmadge.bwt.core.client.ui.widget.event.hide.HideHandler;
import com.talmadge.bwt.core.client.ui.widget.event.resize.BwtResizeEvent;
import com.talmadge.bwt.core.client.ui.widget.event.resize.BwtResizeHandler;
import com.talmadge.bwt.core.client.ui.widget.event.resize.HasBwtResizeHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.show.HasShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.event.show.ShowEvent;
import com.talmadge.bwt.core.client.ui.widget.event.show.ShowHandler;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;


/**
 * 
 * @author Noah
 *
 */
public abstract class BwtWidget extends Widget implements 
		BwtWidgetInterface,
		HasHideHandlers,		
		HasShowHandlers,
		HasBwtResizeHandlers
{
	/**
	 */
	private BwtWidgetAppearance appearance;
	
	/**
	 */
	private boolean hasBeenAttached;
	
	/**
     */
    // private BwtDimensions lastAbsoluteDimensions;
    
	/**
	 */
	private BwtDimension lastDimension;
	
	/**
	 */
	private Timer resizeTimer;
	
	/**
	 * milliseconds
     */
    private int resizeDelay = 250;
    
    /**
     */
    private Tooltip tooltip;
   
	
	
	/**
	 * Constructor
	 *  
	 * @param appearance Appearance
	 */
	protected BwtWidget (BwtWidgetAppearance appearance)
	{
		super();
		    
		this.setAppearance(appearance);
		this.setElement(appearance.getElement());
		
		if (this.getId() == null || this.getId().isEmpty())
		{
			this.setId(BwtWidgetUtils.uniqueId());
		}
	}
	
	
	/**
	 * 
	 * @param className String css class name to add
	 */
	public void addClassName (String className)
	{
		this.getAppearance().addClassName(className);		
	}
	
	
	/**
	 * 
	 * @param handler HideHandler<W>
	 * @return HandlerRegistration
	 * 
	 * @param <W> extends BwtWidget
	 */
	public <W extends BwtWidget> HandlerRegistration addHideHandler (HideHandler<W> handler)
	{
		return this.addHandler(handler, HideEvent.getType());
	}
	
	
	/**
	 * 
	 * @param handler ResizeHandler
	 * @return HandlerRegistration
	 */
	public HandlerRegistration addBwtResizeHandler (BwtResizeHandler handler)
	{
	    if (this.resizeTimer == null)
	    {
	        this.resizeTimer = new Timer()
            {
                public void run ()
                {
                    BwtWidget.this._onResize();
                    
                }
            };
	        
    	    Window.addResizeHandler(new ResizeHandler()
            {
                public void onResize (ResizeEvent event)
                {
                    BwtWidget.this.resizeTimer.schedule(BwtWidget.this.resizeDelay);
                }
            });
    	    
    	    if (this.isAttached())
    	    {
    	        this.lastDimension = new BwtDimension(this.getWidth(), this.getHeight());
    	        // this.lastAbsoluteDimensions = new BwtDimensions(this.getAbsoluteWidth(), this.getAbsoluteHeight());
    	    }
	    }
	    
	    return this.addHandler(handler, BwtResizeEvent.getType());
	}


	/**
	 * 
	 * @param handler ShowHandler<W>
	 * @return HandlerRegistration
	 * 
	 * @param <W> extends BwtWidget
	 */
	public <W extends BwtWidget> HandlerRegistration addShowHandler (ShowHandler<W> handler)
	{
		return this.addHandler(handler, ShowEvent.getType());
	}
	
	
	/**
	 * 
	 */
	public void blur ()
	{
		this.getElement().blur();
	}

	
	/**
     * 
     * @return int
     */
    public int getAbsoluteHeight ()
    {
        return this.getAppearance().getAbsoluteHeight();
    }


    /**
     * 
     * @return int
     */
    public int getAbsoluteWidth ()
    {
        return this.getAppearance().getAbsoluteWidth();
    }
	
	
	/**
	 * 
	 */
	public void focus ()
	{
		this.getElement().focus();
	}
	

	/**
	 * 
	 * @return String
	 */
	public String getId ()
	{
		return this.getElement().getId();
	}

	
	/**
	 * 
	 * @return int
	 */
	public int getHeight ()
    {
        return this.getAppearance().getHeight();
    }

	
	/**
	 * 
	 * @return Tooltip
	 */
	public Tooltip getTooltip ()
	{
		return this.tooltip;
	}

	

	/**
	 * 
	 * @return int
	 */
    public int getWidth ()
    {
        return this.getAppearance().getWidth();
    }


    /**
	 * 
	 * @param cssName String
	 */
	public void ensureCssName (String cssName)
	{
		this.getAppearance().ensureCssName(cssName);		
	}
	

	/**
	 * 
	 * @return boolean
	 */
	public boolean hasBeenAttached ()
	{
		return this.hasBeenAttached;
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
     */
	public void hide ()
	{
		this.setVisible(false);
	}

	
	/**
	 * 
	 * @param id String
	 */
	public void setId (String id)
	{
		this.getElement().setId(id);		
	}

	/**
	 * 
	 * @param left String
	 */
	public void setLeft (String left)
	{
		this.getAppearance().setLeft(left);		
	}
	
	
	/**
     * 
     * @param margin int
     */
    public void setMarginBottom (int margin)
    {
        this.getAppearance().setMarginBottom(margin);
    }
	
    
    /**
     * 
     * @param margin int
     */
    public void setMarginLeft (int margin)
	{
		this.getAppearance().setMarginLeft(margin);
		
	}
    
    
    /**
     * 
     * @param margin int
     */
    public void setMarginRight (int margin)
	{
		this.getAppearance().setMarginRight(margin);
		
	}    
    
	
	/**
	 * 
	 * @param margin int
	 */
	public void setMarginTop (int margin)
	{
		this.getAppearance().setMarginTop(margin);	
	}
	
	
	/**
	 * 
	 * @param position Position
	 */
	public void setPosition (Position position)
	{
		this.getAppearance().setPosition(position);		
	}
	
	/**
	 * 
	 * @param size Size
	 * @param display ResponsiveDisplay
	 */
	public void setResponsiveDisplay (Size size, ResponsiveDisplay display)
	{
		this.getAppearance().setResponsiveDisplay(size, display);
	}
	
	
	/**
	 * 
	 * @param tooltip String
	 */
	public Tooltip setTooltip (String tooltip)
	{
		return this.setTooltip(tooltip, new TooltipConfig());
	}
	
	
	/**
	 * 
	 * @param tooltip String
	 */
	public Tooltip setTooltip (TooltipConfig tooltipConfig)
	{
		return this.setTooltip(new Tooltip(this.getAppearance().getElement(), tooltipConfig));
	}
	
	
	/**
	 * 
	 * @param tooltip String
	 * @param config TooltipConfig
	 */
	public Tooltip setTooltip (String tooltip, TooltipConfig config)
	{
		return this.setTooltip(new Tooltip(this.getAppearance().getElement(), tooltip, config));
	}
	
	
	/**
	 * 
	 * @param tooltip Tooltip
	 */
	public Tooltip setTooltip (Tooltip tooltip)
	{
		this.tooltip = tooltip;
		
		return this.tooltip;
	}
	
	
	/**
	 * 
	 * @param top String
	 */
	public void setTop (String top)
	{
		this.getAppearance().setTop(top);		
	}
	

	/**
	 * 
	 * @param visible boolean
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setVisible (boolean visible)
	{
		if ((this.isVisible() && visible) || (!this.isVisible() && !visible))
		{
			return;
		}

		super.setVisible(visible);

		if (visible)
		{
			this.fireEvent(new ShowEvent(this));
			this.onShow();			
		}
		else
		{
			this.fireEvent(new HideEvent(this));
			this.onHide();
		}
	}
	
	
	/**
	 * 
	 * @param width int
	 */
	public void setWidth (int width)
	{
	    super.setWidth(width + "px");
	}
	

	/**
     * 
     */
	public void show ()
	{
		this.setVisible(true);
	}


	/**
	 *
	 * @return Appearance
	 */
	protected BwtWidgetAppearance getAppearance ()
	{
	    return this.appearance;
	}


	/**
     *
     */
	protected void onAttach () 
	{
		super.onAttach();

		if (!this.hasBeenAttached()) 
		{
			this.onInitialAttach();
		}
		
		this.hasBeenAttached = true;
	}
	
	
	/**
	 * 
	 */
	protected void onHide ()
	{
		
	}

	
	/**
	 * 
	 */
	protected void onInitialAttach () 
	{
		
	}
	
	/**
	 * 
	 */
	protected void onShow ()
	{
		
	}
	
	
	/**
	 */
	private void _onResize ()
    {
	    BwtDimension currentDimension = new BwtDimension(this.getWidth(), this.getHeight());
	    
	    if (this.lastDimension != null  && this.lastDimension.equals(currentDimension))
	    {
	        return;
	    }
	    
	    BwtDimension currentAbsoluteDimension = new BwtDimension(this.getAbsoluteWidth(), this.getAbsoluteHeight());
	    
	    BwtResizeEvent event = new BwtResizeEvent(currentDimension, currentAbsoluteDimension);
	    
	    this.lastDimension = currentDimension;
	    // this.lastAbsoluteDimensions = currentAbsoluteDimensions;
	    
	    this.fireEvent(event);
    }


    /**
	 * 
	 * @param appearance Appearance
	 */
	private void setAppearance (BwtWidgetAppearance appearance)
	{
		this.appearance = appearance;
		
	}
}
