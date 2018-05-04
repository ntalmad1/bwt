package com.talmadge.bwt.core.client.ui.jqueryui.interaction;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.draggable.Draggable;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.draggable.DraggableConfig;

/**
 * 
 *
 */
public abstract class Interaction 
{
	/**
	 * 
	 * @param widget Widget 
	 * @param config DraggableConfig
	 */
	public static Draggable draggable (Widget widget, DraggableConfig config)
	{
		return new Draggable(widget, config);		
	}

	
	/**
	 * 
	 */
	private InteractionConfig config;
	
	/**
	 */
	private Element target;
	
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param config DraggableConfig
	 */
	public Interaction (Widget widget, DraggableConfig config)
	{
		this.target = widget.getElement();
		this.config = config;
	}
	
	
	/**
	 * 
	 * @return InteractionConfig
	 */
	public InteractionConfig getConfig ()
	{
		return this.config;
	}


	/**
	 * 
	 * @return Element
	 */
	public Element getTarget ()
	{
		return this.target;
	}
}
