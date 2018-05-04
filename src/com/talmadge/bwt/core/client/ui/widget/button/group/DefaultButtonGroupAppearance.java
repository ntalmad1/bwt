package com.talmadge.bwt.core.client.ui.widget.button.group;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultButtonGroupAppearance extends DefaultBwtWidgetContainerAppearance implements ButtonGroupAppearance
{
	/**
	 * Constructor
	 *  
	 */
	public DefaultButtonGroupAppearance ()
    {
	    super(Document.get().createDivElement());
	    
	    
    }

	
	/**
	 * 
	 * @param button Button
	 */
    public void add (Button button)
    {
	    this.getElement().appendChild(button.getElement());	    
    }


	/**
	 * 
	 * @param button Button
	 */
	public void remove (Button button)
	{
		if (this.getElement().isOrHasChild(button.getElement()))
		{
			this.getElement().removeChild(button.getElement());
		}
	}


	/**
	 * 
	 * @param isBlock boolean
	 */
	public void setBlock (boolean isBlock)
	{
		this.toggleCssName("btn-group-justified", isBlock);		
	}


	/**
	 * 
	 * @param isVertical boolean
	 */
	public void setVertical (boolean isVertical)
	{
		this.toggleCssName("btn-group", !isVertical);
		this.toggleCssName("btn-group-vertical", isVertical);
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("btn-group");
	}
}
