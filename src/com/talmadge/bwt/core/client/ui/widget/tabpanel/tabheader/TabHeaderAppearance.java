package com.talmadge.bwt.core.client.ui.widget.tabpanel.tabheader;

import com.google.gwt.dom.client.Element;
import com.talmadge.bwt.core.client.ui.widget.appearance.BwtWidgetAppearance;

/**
 * @author Noah
 *
 */
public interface TabHeaderAppearance extends BwtWidgetAppearance
{
	/**
	 * 
	 * @param tabHeader TabHeader
	 */
    void add (TabHeader tabHeader);


	/**
     * @param target Element
     */
    void setTarget (Element target);


    /**
     * @param active boolean
     */
    void setActive (boolean active);

    
    /**
     * 
     * @param isGroup boolean 
     */
	void setIsTabGroup (boolean isGroup);

	
	/**
	 * 
	 * @param text String
	 */
	void setText (String text);
}
