package com.talmadge.bwt.core.client.ui.widget.tabpanel.tab;

import com.talmadge.bwt.core.client.ui.widget.container.BwtWidgetContainerAppearance;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelAppearance;
import com.talmadge.bwt.core.client.ui.widget.layout.panel.BwtPanelInterface;

/**
 * 
 * @author Noah
 *
 */
public interface TabAppearance extends BwtWidgetContainerAppearance, BwtPanelAppearance
{
	/**
	 * @return BwtPanelInterface
	 */
	BwtPanelInterface getPanel ();
	
	
    /**
     * @param active boolean
     */
    void setActive (boolean active);


    /**
     * @param fade boolean
     */
    void setFxFade (boolean fade);
}
