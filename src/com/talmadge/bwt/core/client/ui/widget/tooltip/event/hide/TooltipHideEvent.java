package com.talmadge.bwt.core.client.ui.widget.tooltip.event.hide;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.TooltipHelper;
import com.talmadge.bwt.core.client.ui.widget.tooltip.TooltipInstance;

/**
 * 
 *
 */
public class TooltipHideEvent extends GwtEvent<TooltipHideHandler>
{
	/**
	 */
	private static final GwtEvent.Type<TooltipHideHandler> TYPE = new GwtEvent.Type<TooltipHideHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeTooltipShowHandler>
	 */
	public static GwtEvent.Type<TooltipHideHandler> getType ()
	{
		return TYPE;
	}
	
	
	/**
	 */
	private Tooltip tooltip;
	
	/**
	 */
	private TooltipHelper tooltipHelper;
	
	/**
	 */
	private TooltipInstance tooltipInstance;
	
	
	
	/**
	 * Constructor
	 *  
	 */
	public TooltipHideEvent (Tooltip tooltip, TooltipInstance instance, TooltipHelper helper)
	{
		super();
		
		this.tooltip         = tooltip;
		this.tooltipInstance = instance;
		this.tooltipHelper   = helper;
	}
	
	
	/**
	 * 
	 */
	@Override
	public GwtEvent.Type<TooltipHideHandler> getAssociatedType ()
	{
		return TYPE;
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
	 * @return TooltipHelper
	 */
	public TooltipHelper getHelper ()
	{
		return this.tooltipHelper;
	}
	
	
	/**
	 * 
	 * @return TooltipInstance
	 */
	public TooltipInstance getInstance ()
	{
		return this.tooltipInstance;
	}
	
	
	/**
	 * 
	 * @param handler TooltipHideHandler
	 */
	@Override
	protected void dispatch (TooltipHideHandler handler)
	{
		handler.onTooltipHide(this);		
	}
	
}
