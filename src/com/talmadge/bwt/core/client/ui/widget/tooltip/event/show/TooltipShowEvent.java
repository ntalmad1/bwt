package com.talmadge.bwt.core.client.ui.widget.tooltip.event.show;

import com.google.gwt.event.shared.GwtEvent;
import com.talmadge.bwt.core.client.ui.widget.tooltip.Tooltip;
import com.talmadge.bwt.core.client.ui.widget.tooltip.TooltipHelper;
import com.talmadge.bwt.core.client.ui.widget.tooltip.TooltipInstance;

/**
 * 
 *
 */
public class TooltipShowEvent extends GwtEvent<TooltipShowHandler>
{
	/**
	 */
	private static final GwtEvent.Type<TooltipShowHandler> TYPE = new GwtEvent.Type<TooltipShowHandler>();
	
	
	/**
	 * 
	 * @return GwtEvent.Type<BeforeTooltipShowHandler>
	 */
	public static GwtEvent.Type<TooltipShowHandler> getType ()
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
	public TooltipShowEvent (Tooltip tooltip, TooltipInstance instance, TooltipHelper helper)
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
	public GwtEvent.Type<TooltipShowHandler> getAssociatedType ()
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
	 * @param handler TooltipShowHandler
	 */
	@Override
	protected void dispatch (TooltipShowHandler handler)
	{
		handler.onTooltipShow(this);		
	}
	
}
