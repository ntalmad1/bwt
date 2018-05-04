package com.talmadge.bwt.core.client.ui.widget.container;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.WidgetCollection;

/**
 * @author Noah
 *
 */
public interface HasChildren extends HasWidgets
{
	/**
	 *
	 * @param child IsWidget
	 */
	void add (IsWidget child);

	
	/**
	 *
	 * @param child IsWidget
	 * @return boolean
	 */
    boolean remove (IsWidget child);

    
    /**
     *
     * @return WidgetCollection
     */
    WidgetCollection getChildren ();
}
