package com.talmadge.bwt.core.client.ui.widget.tooltip.config;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.config.javascriptobject.AbstractJavaScriptObjectConfig;
import com.talmadge.bwt.core.client.ui.util.Position;
import com.talmadge.bwt.core.client.ui.widget.tooltip.animation.TooltipAnimation;
import com.talmadge.bwt.core.client.ui.widget.tooltip.theme.TooltipTheme;
import com.talmadge.bwt.core.client.ui.widget.tooltip.trigger.TooltipTrigger;

/**
 * 
 * @param <T> extends JavaScriptObject
 */
public class TooltipConfig extends AbstractJavaScriptObjectConfig 
{
	/**
	 */
	private Widget widget;
	
	/**
	 */
	private JSONArray plugins;
	
	
    /**
     * Constructor
     * 
     */
    public TooltipConfig ()
    {
       super((TooltipConfigOverlay) ((new JSONObject()).getJavaScriptObject())); 
       
       this.plugins = new JSONArray();
       this.put("plugins", this.plugins);
    }
    
    
    /**
     * 
     * @return Widget
     */
    public Widget getWidget ()
    {
    	return this.widget;
    }
    
    
    /**
     * 
     * @return boolean
     */
    public boolean hasWidget ()
    {
    	return (this.widget != null);
    }
    
    
    /**
	 * 
	 * @param animation TooltipAnimation
	 */
	public void setAnimation (TooltipAnimation animation)
	{
		this.put("animation", animation.toString());
	}


	/**
     * 
     * @param content String
     */
	public void setContent (String content)
	{
		this.put("content", content);	
		
		this.widget = null;
	}
	
	
	/**
     * 
     * @param isWidget IsWidget
     */
	public void setContent (IsWidget isWidget)
	{
		this.setContent(isWidget.asWidget());
	}

	
	/**
	 * 
	 * @param widget Widget
	 */
	public void setContent (Widget widget)
	{
		this.put("content", widget.getElement());
		
		this.widget = widget;
	}
	
	
	/**
	 * 
	 * @param asHtml boolean
	 */
	public void setContentAsHtml (boolean asHtml)
	{
		this.put("contentAsHTML", asHtml);
		
	}


	/**
	 * 
	 * @param boolean isInteractive
	 */
	public void setInteractive (boolean isInteractive)
	{
		this.put("interactive", isInteractive);		
	}

	
	/**
	 * 
	 * @param width int
	 */
	public void setMaxWidth (int width)
	{
		this.put("maxWidth", width); 		
	}

	
	/**
	 * 
	 * @param moustracking boolean
	 */
	public void setMouseTracking (boolean mouseTracking)
	{
		if (mouseTracking)
		{
			this.plugins.set(this.plugins.size(), new JSONString("follower"));
		}
	}


	/**
	 * 
	 * @param allowMultiple boolean
	 */
	public void setMultiple (boolean allowMultiple)
	{
		this.put("multiple", allowMultiple);
		
	}


	/**
	 * 
	 * @param position Position
	 */
	public void setPosition (Position position)
	{
		this.put("side", position.toString());		
	}
	
	
	/**
	 * 
	 * @param side Position
	 */
	public void setSide (Position side)
	{
		this.setPosition(side);
	}

	
	/**
	 * 
	 * @param theme TooltipTheme
	 */
	public void setTheme (TooltipTheme theme)
	{
		this.put("theme", theme.toString());		
	}


	/**
	 * 
	 * @param interval int
	 */
	public void setTrackerInterval (int interval)
	{
		this.put("trackerInterval", interval);
	}
	
	
	/**
	 * 
	 * @param trackOrigin boolean
	 */
	public void setTrackOrigin (boolean trackOrigin)
	{
		this.put("trackOrigin", trackOrigin);
	}


	/**
	 * 
	 * @param trigger TooltipTrigger
	 */
	public void setTrigger (TooltipTrigger trigger)
	{
		this.put("trigger", trigger.getTrigger());		
	}
}
