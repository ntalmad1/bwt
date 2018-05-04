/**
 *
 */
package com.talmadge.bwt.core.client.ui.widget.tabpanel;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.Style.Unit;
import com.talmadge.bwt.core.client.ui.dom.layout.LayoutUtils;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.widget.appearance.DefaultBwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tab.Tab;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tabheader.TabHeader;


/**
 * @author Noah
 *
 */
public class DefaultTabPanelAppearance extends DefaultBwtWidgetAppearance implements TabPanelAppearance
{
    /**
     */
    protected interface Defaults
    {
        /**
         */
        int BODY_PADDING = 10;
    }

    /**
     */
    private Element tabHeaders;

    /**
     */
    private Element tabPanes;


    /**
     * Constructor
     *
     */
    public DefaultTabPanelAppearance ()
    {
        super(Document.get().createDivElement());
    }


    /**
     *
     * @param padding int
     */
    public void setBodyPadding (int padding)
    {
        this.setBodyPadding(new Padding(padding));
    }


    /**
     * 
     * @param padding Padding
     */
	public void setBodyPadding (Padding padding)
	{
    	LayoutUtils.applyPadding(this.tabPanes, padding);
	}


	/**
     * 
     * @param header TabHeader
     */
    public void add (TabHeader header)
    {
        this.tabHeaders.appendChild(header.getElement());
        
        for (Tab tab : header.getTabs())
        {
        	this.tabPanes.appendChild(tab.getElement());
        }
    }


    /**
     * 
     * @return Element
     */
    public Element getActiveTab ()
    {
        NodeList<Node> panes = this.tabPanes.getChildNodes();

        for (int i = 0; i < panes.getLength(); ++i)
        {
            Element tab = panes.getItem(i).cast();

            if (tab.hasClassName("active"))
            {
                return tab;
            }
        }

        return null;
    }


    /**
     *
     * @param height int
     */
    public void setBodyHeight (int height)
    {
        this.tabPanes.getStyle().setHeight(height, Unit.PX);
    }



	/**
	 * 
	 */
	protected void build ()
	{
		this.tabHeaders = Document.get().createULElement();
        this.tabHeaders.addClassName("nav");
        this.tabHeaders.addClassName("nav-tabs");

        this.tabPanes = Document.get().createDivElement();
        this.tabPanes.addClassName("tab-content");
        this.tabPanes.addClassName("bwt-tab-pane");

        this.getElement().appendChild(this.tabHeaders);
        this.getElement().appendChild(this.tabPanes);

        this.setBodyPadding(Defaults.BODY_PADDING);
	}
}
