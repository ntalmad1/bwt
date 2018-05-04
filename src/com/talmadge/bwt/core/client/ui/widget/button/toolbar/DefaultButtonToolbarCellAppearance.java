package com.talmadge.bwt.core.client.ui.widget.button.toolbar;

import com.google.gwt.dom.client.Document;
import com.talmadge.bwt.core.client.ui.widget.button.Button;
import com.talmadge.bwt.core.client.ui.widget.button.group.ButtonGroup;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;

/**
 * 
 * @author Noah
 *
 */
public class DefaultButtonToolbarCellAppearance extends DefaultBwtWidgetContainerAppearance implements ButtonToolbarAppearance
{
	/**
	 * Constructor
	 *  
	 */
	public DefaultButtonToolbarCellAppearance ()
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
	 * @param buttonGroup ButtonGroup
	 */
    public void add (ButtonGroup buttonGroup)
    {
	    this.getElement().appendChild(buttonGroup.getElement());	    
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
	 * @param buttonGroup Button
	 */
	public void remove (ButtonGroup buttonGroup)
	{
		if (this.getElement().isOrHasChild(buttonGroup.getElement()))
		{
			this.getElement().removeChild(buttonGroup.getElement());
		}
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("btn-toolbar");
	}
}
