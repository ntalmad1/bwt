package com.talmadge.bwt.core.client.ui.jqueryui.interaction.draggable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.talmadge.bwt.core.client.config.javascriptobject.JavaScriptObjectParameter;
import com.talmadge.bwt.core.client.ui.jqueryui.event.JQueryUiActionHandler;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.InteractionConfig;
import com.talmadge.bwt.core.client.ui.jqueryui.interaction.helper.InteractionHelper;


/**
 * 
 *
 */
public class DraggableConfig extends InteractionConfig
{
	/**
	 * Constructor
	 * 
	 */
	public DraggableConfig ()
	{
		super((DraggableConfigOverlay) JavaScriptObject.createObject());
	}
	
	
	/**
	 * 
	 * @param x int
	 * @param y int
	 */
	public void setGrid (int x, int y)
	{
		JSONArray array = new JSONArray();
		array.set(0, new JSONNumber(x));
		array.set(1, new JSONNumber(y));
		
		this.put("grid", array);
	}

	
	/**
	 * 
	 * @param helper InteractionHelper
	 */
	public void setHelper (InteractionHelper helper)
	{
		this.put("helper", helper.toString());		
	}

	
	/**
	 * 
	 * @param revert boolean
	 */
	public void setRevert (boolean revert)
	{
		this.put("revert", revert);				
	}
	
	
	/**
	 * 
	 * @param javaScriptObjectParameter JavaScriptObjectParameter
	 */
	public void setRevert (JavaScriptObjectParameter javaScriptObjectParameter)
	{
		this.put("revert", javaScriptObjectParameter);		
	}

	
	/**
	 * 
	 * @param scroll
	 */
	public void setScroll (boolean scroll)
	{
		this.put("scroll", scroll);		
	}

	
	/**
	 * 
	 * @param cancel boolean
	 */
	public void setCancel (boolean cancel)
	{
		this.put("cancel", cancel);
	}

	
	/**
	 * 
	 * @param jQueryUiActionHandler JQueryUiActionHandler
	 */
	public void setStart (JQueryUiActionHandler jQueryUiActionHandler)
	{
		this.put("start", jQueryUiActionHandler);		
	}
}
