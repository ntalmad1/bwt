package com.talmadge.bwt.core.client.ui.widget.tooltip;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.BwtDom;
import com.talmadge.bwt.core.client.ui.util.BwtWidgetUtils;
import com.talmadge.bwt.core.client.ui.widget.event.click.ClickEvent;
import com.talmadge.bwt.core.client.ui.widget.event.click.ClickHandler;
import com.talmadge.bwt.core.client.ui.widget.event.click.HasClickHandlers;
import com.talmadge.bwt.core.client.ui.widget.tooltip.config.TooltipConfig;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow.BeforeTooltipShowEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow.BeforeTooltipShowHandler;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow.HasBeforeTooltipShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.hide.HasTooltipHideHandlers;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.hide.TooltipHideEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.hide.TooltipHideHandler;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.show.HasTooltipShowHandlers;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.show.TooltipShowEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.event.show.TooltipShowHandler;

/**
 * 
 * 
 */
public class Tooltip implements HasBeforeTooltipShowHandlers, HasTooltipHideHandlers, HasTooltipShowHandlers, HasClickHandlers<Tooltip>
{	
	/**
     */
    private static int id = 0;
    
    
    /**
	 * 
	 * @param Element target
	 * @param content String
	 * @return Tooltip
	 */
	public static Tooltip tooltip (Element target, String content)
	{
		TooltipConfig config = new TooltipConfig();
		config.setContent(content);
		
		return Tooltip.tooltip(target, config);
	}


	/**
     * 
     * @param element Element
     * @param tooltipConfig TooltipConfig
     */
    public static Tooltip tooltip (Element element, TooltipConfig tooltipConfig)
	{
		return  new Tooltip(element, tooltipConfig);
	}
    
    
    /**
     * 
     * @param widget Widget
     * @param tooltipConfig TooltipConfig
     */
    public static Tooltip tooltip (Widget widget, TooltipConfig tooltipConfig)
	{
		return Tooltip.tooltip(widget.getElement(), tooltipConfig);
	}


    /**
     * 
     * @return String
     */
    private static String nextId ()
    {
        ++id;
        
        return ("tooltipFunction" + id); 
    }
	
    
    
	/**
	 */
	private TooltipInstance instance;
	
	/**
	 */
	private HandlerRegistration closeOnKeyPressHandlerReg;

	/**
	 */
	private TooltipConfig config;
	
	/**
	 */
	private HandlerManager handlerManager;
	
	/**
	 */
	private Element target;

	
	
	/**
	 * Constructor 
	 *  
	 * @param target Element
	 * @param config TooltipConfig
	 */
	public Tooltip (Element target, TooltipConfig config)
	{
		this.handlerManager = new HandlerManager(this);
		
		this.target = target;
		this.config = config;
		
		this.bindConfig();
		
		this._tooltipster(this.target, this.config.getJavaScriptObject()); 
	}


	/**
	 * Constructor 
	 *  
	 * @param target Element
	 * @param tooltip String
	 * @param config TooltipConfig
	 */
	public Tooltip (Element target, String tooltip, TooltipConfig config)
	{
		this.handlerManager = new HandlerManager(this);
		
		this.target = target;
		this.config = config;
		
		this.bindConfig();
		
		this.config.setContent(tooltip);
		this._tooltipster(this.target, this.config.getJavaScriptObject()); 
	}
	
	
	/**
	 * 
	 * @param handler BeforeTooltipShowHandler
	 * @return HandlerRegistration
	 */
	@Override
	public HandlerRegistration addBeforeTooltipShowHandler (BeforeTooltipShowHandler handler)
	{
		return this.handlerManager.addHandler(BeforeTooltipShowEvent.getType(), handler);
	}

	
	/**
	 * 
	 * @param handler ClickHandler<Tooltip>
	 */
	@Override
	public HandlerRegistration addClickHandler (ClickHandler<Tooltip> handler)
	{
		return this.handlerManager.addHandler(ClickEvent.getType(), handler);
	}


	/**
	 * 
	 * @param handler TooltipHideHandler
	 * @return HandlerRegistration
	 */
	@Override
	public HandlerRegistration addTooltipHideHandler (TooltipHideHandler handler)
	{
		return this.handlerManager.addHandler(TooltipHideEvent.getType(), handler);
	}


	/**
	 * 
	 * @param handler TooltipShowHandler
	 * @return HandlerRegistration
	 */
	@Override
	public HandlerRegistration addTooltipShowHandler (TooltipShowHandler handler)
	{
		return this.handlerManager.addHandler(TooltipShowEvent.getType(), handler);
	}


	/**
	 * 
	 */
	public void close ()
	{
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			public void execute () {
				Tooltip.this._close(Tooltip.this.target);		
			}
		});
	}

	
	/**
	 * 
	 */
	public void destroy ()
	{
		this._destroy(this.target);
	}


	/**
	 * 
	 */
	public void hide ()
	{
		this.close();
	}
	
	
	/**
	 * 
	 * @param closeOnKeypress boolean
	 * @return Tooltip
	 */
	public Tooltip setCloseOnKeypress (boolean closeOnKeypress)
	{
		if (closeOnKeypress)
		{
			if (this.closeOnKeyPressHandlerReg == null)
			{
				this.closeOnKeyPressHandlerReg = BwtDom.getInstance().addKeyPressHandler(new KeyPressHandler(){
					public void onKeyPress (KeyPressEvent event)
					{
						Tooltip.this.close();			
					}
				});
			}
		}
		else
		{
			if (this.closeOnKeyPressHandlerReg != null)
			{
				this.closeOnKeyPressHandlerReg.removeHandler();
				this.closeOnKeyPressHandlerReg = null;
			}
		}
		
		return this;		
	}


	/**
	 * 
	 */
	public void show ()
	{
		this._open(this.target);		
	}

	
	/**
	 * 
	 * @param content String
	 */
	public void update (final String content)
	{
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			public void execute () {
				Tooltip.this._update(Tooltip.this.target, "content", content);
			}
		});
	}


	/**
	 * 
	 */
	protected void bindConfig ()
	{
		JavaScriptObject functionAfter = this._exportFunctionAfter(this, Tooltip.nextId());
		JavaScriptObject functionBefore = this._exportFunctionBefore(this, Tooltip.nextId());
		JavaScriptObject functionReady = this._exportFunctionReady(this, Tooltip.nextId());
		
		
		this.config.put("functionAfter", functionAfter);
		this.config.put("functionBefore", functionBefore);
		this.config.put("functionReady", functionReady);
	}


	/**
	 * 
	 * @param instance TooltipInstance
	 * @param helper TooltipHelper
	 */
	protected void onClick (TooltipInstance instance, TooltipHelper helper)
	{
		this.handlerManager.fireEvent(new ClickEvent<Tooltip>(this));
	
	}
	
	
	/**
	 * 
	 * @param instance TooltipInstance
	 * @param helper TooltipHelper
	 */
	protected void onBeforeShow (TooltipInstance instance, TooltipHelper helper)
	{
		this.handlerManager.fireEvent(new BeforeTooltipShowEvent(this, instance, helper));
	}
	
	
	/**
	 * 
	 * @param instance TooltipInstance
	 * @param helper TooltipHelper
	 */
	protected void onHide (TooltipInstance instance, TooltipHelper helper)
	{
		this.handlerManager.fireEvent(new TooltipHideEvent(this, instance, helper));
	}
	
	
	/**
	 * 
	 * @param instance TooltipInstance
	 * @param helper TooltipHelper
	 */
	protected void onShow (final TooltipInstance instance, final TooltipHelper helper)
	{
		Element tooltipElement = helper.getTooltipElement();
		
		Event.sinkEvents(tooltipElement, Event.ONCLICK);
		Event.setEventListener(tooltipElement, new EventListener() {
	        public void onBrowserEvent(Event event) {
	             if(Event.ONCLICK == event.getTypeInt()) {
	                 Tooltip.this.onClick(instance, helper);
	             }
	        }
	    });
		
		
		
		if (this.config.hasWidget() && !this.config.getWidget().isAttached())
		{
			BwtWidgetUtils.attachWidget(Tooltip.this.config.getWidget());
		}
		
		this.handlerManager.fireEvent(new TooltipShowEvent(this, instance, helper));
	}

	
	/**
	 * 
	 * @param target JavaScriptObject
	 */
	private native void _close (Element target) /*-{
		$wnd.$(target).tooltipster("close");		
	}-*/;
	
	
	/**
	 * 
	 * @param target JavaScriptObject
	 */
	private native void _destroy (Element target) /*-{
		$wnd.$(target).tooltipster("destroy");		
	}-*/;
	
	
	/**
	 * 
	 * @param target JavaScriptObject
	 */
	private native void _open (Element target) /*-{
		$wnd.$(target).tooltipster("open");		
	}-*/;

	
	/**
     * 
     * @param tooltip Tooltip
     * @param functionName String
     */
    private native JavaScriptObject _exportFunctionAfter (Tooltip tooltip, String functionName) /*-{
   
        $wnd[functionName] = function(instance, helper) {
            return tooltip.@com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip::onHide(Lcom/talmadge/bwt/core/client/ui/widget/tooltip/TooltipInstance;Lcom/talmadge/bwt/core/client/ui/widget/tooltip/TooltipHelper;)(instance, helper);
        };
        
        return $wnd[functionName];
        
    }-*/;
    
    
    /**
     * 
     * @param tooltip Tooltip
     * @param functionName String
     */
    private native JavaScriptObject _exportFunctionBefore (Tooltip tooltip, String functionName) /*-{
   
        $wnd[functionName] = function(instance, helper) {
            return tooltip.@com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip::onBeforeShow(Lcom/talmadge/bwt/core/client/ui/widget/tooltip/TooltipInstance;Lcom/talmadge/bwt/core/client/ui/widget/tooltip/TooltipHelper;)(instance, helper);
        };
        
        return $wnd[functionName];
        
    }-*/;
		
	
	/**
     * 
     * @param tooltip Tooltip
     * @param functionName String
     */
    private native JavaScriptObject _exportFunctionReady (Tooltip tooltip, String functionName) /*-{
   
        $wnd[functionName] = function(instance, helper) {
            return tooltip.@com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip::onShow(Lcom/talmadge/bwt/core/client/ui/widget/tooltip/TooltipInstance;Lcom/talmadge/bwt/core/client/ui/widget/tooltip/TooltipHelper;)(instance, helper);
        };
        
        return $wnd[functionName];
        
    }-*/;
	

	/**
	 * 
	 * @param target JavaScriptObject
	 * @param config JavaScriptObject
	 */
	private native void _tooltipster (JavaScriptObject target, JavaScriptObject config) /*-{
		$wnd.$(target).tooltipster(config);
	}-*/;


	/**
	 * 
	 * @param target JavaScriptObject
	 * @param key String
	 * @param value String
	 */
	private native void _update (JavaScriptObject target, String key, String value) /*-{
		$wnd.$(target).tooltipster(key, value);
	}-*/;
}
