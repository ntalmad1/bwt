package com.talmadge.bwt.core.client.ui.widget.tabpanel.tab;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Widget;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutUtils;
import com.talmadge.bwt.core.client.ui.dom.layout.margin.Margins;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.widget.container.DefaultBwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.flowpanel.BwtFlowPanel;

/**
 * @author Noah
 *
 */
public class DefaultTabAppearance extends DefaultBwtWidgetContainerAppearance implements TabAppearance
{
    /**
     */
    private BwtPanelInterface panel;



    /**
     * Constructor
     *
     */
    public DefaultTabAppearance ()
    {
        super(Document.get().createDivElement());
    }

    
	/**
	 *
	 * @param widget Widget
	 */
	public void add (Widget widget)
	{
		this.panel.add(widget);
	}
    

    /**
     *
     * @param widget Widget
     * @param margins Margins
     */
    public void add (Widget widget, Margins margins)
    {
    	this.panel.add(widget, margins);
    }


    /**
     * 
     * @return BwtPanel
     */
	public BwtPanelInterface getPanel ()
	{
		return this.panel;
	}


	/**
	 * 
	 */
	public void clear ()
	{
		this.getPanel().clear();
	}

	
	/**
	 * 
	 * @param widget Widget
	 * @return boolean true if the widget exists
	 */
	public boolean remove (Widget widget)
	{
		return this.getPanel().remove(widget);
	}
	

	/**
     *
     * @param active boolean
     */
    public void setActive (boolean active)
    {
    	this.toggleCssName("active", active);
        

        if (this.getElement().hasClassName("fade"))
        {
            this.ensureCssName("in");
        }
    }


	/**
	 * 
	 * @param fxFade boolean
	 */
	public void setFxFade (boolean fxFade)
	{
		this.toggleCssName("fade", fxFade);		
	}


	/**
	 * 
	 * @param padding Padding
	 */
	public void setPadding (Padding padding)
	{
		LayoutUtils.applyPadding(this.getPanel().asWidget(), padding);		
	}


	/**
	 * 
	 */
	protected void build ()
	{
		this.getElement().addClassName("tab-pane");

		this.panel = new BwtFlowPanel();
		this.getElement().appendChild(this.panel.getElement());

	}
}
