package com.talmadge.bwt.core.client.ui.widget.tooltip.event.beforeshow;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.TooltipHelper;
import com.talmadge.bwt.core.client.ui.widget.tooltip.TooltipInstance;

/**
 * 
 *
 */
public class BeforeTooltipShowEvent extends GwtEvent<BeforeTooltipShowHandler>
{
	/**
	 */
	private static final GwtEvent.Type<BeforeTooltipShowHandler> TYPE = new GwtEvent.Type<BeforeTooltipShowHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeTooltipShowHandler>
	 */
	public static GwtEvent.Type<BeforeTooltipShowHandler> getType ()
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
	public BeforeTooltipShowEvent (Tooltip tooltip, TooltipInstance instance, TooltipHelper helper)
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
	public GwtEvent.Type<BeforeTooltipShowHandler> getAssociatedType ()
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
	 * @param handler BeforeTooltipShowHandler
	 */
	@Override
	protected void dispatch (BeforeTooltipShowHandler handler)
	{
		handler.onBeforeTooltipShow(this);		
	}
	
}
