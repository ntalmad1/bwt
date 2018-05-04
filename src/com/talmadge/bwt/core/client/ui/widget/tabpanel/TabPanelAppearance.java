/**
 *
 */
package com.talmadge.bwt.core.client.ui.widget.tabpanel;

import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.dom.layout.padding.Padding;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;
import com.talmadge.bwt.core.client.ui.widget.tabpanel.tabheader.TabHeader;



/**
 * 
 * @author Noah
 *
 */
public interface TabPanelAppearance extends BwtWidgetAppearance
{
	/**
	 * @param tabHeader TabHeader
	 */
    void add (TabHeader tabHeader);

    
	/**
	 * @return Element
     */
    Element getActiveTab ();
    
    
    /**
     * @param height int
     */
    void setBodyHeight (int height);

    /**
     * @param padding Padding
     */
	void setBodyPadding (Padding padding);
}
