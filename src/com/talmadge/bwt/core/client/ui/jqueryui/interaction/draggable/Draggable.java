package com.talmadge.bwt.core.client.ui.jqueryui.interaction.draggable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.Interaction;

/**
 * 
 *
 */
public class Draggable extends Interaction
{
	/**
	 */
	private DraggableInstance instance;
	
	
	/**
	 * 
	 * @param widget Widget
	 * @param config DraggableConfig
	 */
	public Draggable (Widget widget, DraggableConfig config)
	{
		super(widget, config);
		
		this.instance = this._draggable(this.getTarget(), this.getConfig().getJavaScriptObject()); 
	}
	
	
	/**
	 * 
	 * @param target JavaScriptObject
	 * @param config JavaScriptObject
	 * @return DraggableInstance
	 */
	private native DraggableInstance _draggable (JavaScriptObject target, JavaScriptObject config) /*-{
		
		return $wnd.$(target).draggable(config);
	}-*/;

}
